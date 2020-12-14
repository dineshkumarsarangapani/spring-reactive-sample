package info.dineshkumars.reactivesample.repository;

import info.dineshkumars.reactivesample.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student, String> {

}
