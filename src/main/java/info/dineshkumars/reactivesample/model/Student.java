package info.dineshkumars.reactivesample.model;

import javax.validation.Valid;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Valid
@Document(collection = "student")
public class Student {

  @Id
  private String id;
  private String name;
  private int age;
  private String location;
  private Marks marks;

  public Student() {

  }

  public Student(String id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.location = "Chennai";
  }


  public Student(String id, String name, int age, String location, Marks marks) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.location = location;
    this.marks = marks;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Marks getMarks() {
    return marks;
  }

  public void setMarks(Marks marks) {
    this.marks = marks;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", location='" + location + '\'' +
        ", marks=" + marks +
        '}';
  }
}
