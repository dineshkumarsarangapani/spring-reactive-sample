package info.dineshkumars.reactivesample.controller;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import info.dineshkumars.reactivesample.model.Student;
import info.dineshkumars.reactivesample.service.InMemoryService;
import info.dineshkumars.reactivesample.service.PersistenceService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Controller
public class DemoController {

  Logger logger = LoggerFactory.getLogger(DemoController.class);

  @Autowired
  InMemoryService inMemoryService;

  @Autowired
  PersistenceService persistenceService;

  public Mono<ServerResponse> getSampleDemo() {
    return inMemoryService.getStudent()
        .flatMap(student -> ok().bodyValue(student));
  }

  public Mono<ServerResponse> getNames() {
    return inMemoryService.getNames()
        .flatMap(names -> ok().bodyValue(names));
  }

  public Mono<ServerResponse> insertStudent(Mono<Student> student) {
    return student.flatMap(stg -> persistenceService.insertStudent(stg))
        .flatMap(success -> ok().contentType(MediaType.APPLICATION_JSON).body(student, Student.class));
  }

}
