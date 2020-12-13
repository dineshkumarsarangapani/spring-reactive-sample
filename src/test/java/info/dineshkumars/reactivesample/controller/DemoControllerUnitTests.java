package info.dineshkumars.reactivesample.controller;


import info.dineshkumars.reactivesample.service.InMemoryService;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class DemoControllerUnitTests {

  @Mock
  InMemoryService inMemoryService;

  @InjectMocks
  DemoController demoController;


  @Test
  public void getListTest() {
    Mockito.when(inMemoryService.getNames())
        .thenReturn(Mono.just(Arrays.asList("Dinesh", "kumar")));

    StepVerifier.create(demoController.getNames())
        .assertNext(response -> response.statusCode().equals(200))
        .assertNext(
            response -> response.headers().getContentType().equals(MediaType.APPLICATION_JSON));
  }

}
