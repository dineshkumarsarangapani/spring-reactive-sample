package info.dineshkumars.reactivesample.service;

import info.dineshkumars.reactivesample.controller.DemoController;
import info.dineshkumars.reactivesample.model.Student;
import info.dineshkumars.reactivesample.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PersistenceService {

  Logger logger = LoggerFactory.getLogger(DemoController.class);
  @Autowired
  StudentRepository studentRepository;

  public Mono<Student> insertStudent(Student student) {
    logger.info("Came here " + student);
    return studentRepository.insert(student);
  }

}
