package info.dineshkumars.reactivesample.service;


import static info.dineshkumars.reactivesample.model.Marks.getRandomMarks;

import info.dineshkumars.reactivesample.model.Student;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class InMemoryService {

  static Map<String, Student> studentList;

  static List<String> names = Arrays
      .asList("dinesh", "Sandy", "Kumar", "Sarangapani", "Divya", "Jagadeeswari");

  static {
    studentList = names.stream()
        .map(name ->
            new Student(UUID.randomUUID().toString(), name, 30, "chennai", getRandomMarks()))
        .collect(Collectors.toMap(Student::getId, Function.identity()));
    System.out.println(studentList);
  }

  public Mono<List<String>> getNames() {
    return Mono.just(names);
  }

  public Mono<Student> getStudent() {
    String next = studentList.keySet().stream().iterator().next();
    return Mono.just(studentList.get(next));
  }

}
