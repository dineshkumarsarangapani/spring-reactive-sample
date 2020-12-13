package info.dineshkumars.reactivesample.controller;


import static org.hamcrest.Matchers.equalTo;

import info.dineshkumars.reactivesample.ReactiveSampleApplication;
import info.dineshkumars.reactivesample.service.InMemoryService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(classes = ReactiveSampleApplication.class)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
public class DemoControllerTest {

  @Autowired
  WebTestClient webTestClient;

  @MockBean
  InMemoryService inMemoryService;

  @Test
  void getNamesListTest() {
    Mockito.when(inMemoryService.getNames())
        .thenReturn(Mono.just(Arrays.asList("Dinesh")));

    webTestClient.get().uri("/demo/list")
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .expectBody(List.class)
        .value(li -> li.get(0), equalTo("Dinesh"));
  }

}
