package info.dineshkumars.reactivesample.controller;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import info.dineshkumars.reactivesample.model.Student;
import info.dineshkumars.reactivesample.service.InMemoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Controller
public class DemoController {

  @Autowired
  InMemoryService inMemoryService;

  public Mono<ServerResponse> getSampleDemo() {
    Mono<Student> student = inMemoryService.getStudent();
    return ok().body(student, Student.class);
  }

  public Mono<ServerResponse> getNames() {
    Mono<List<String>> names = inMemoryService.getNames();
    return ok().body(names, List.class);
  }
}
