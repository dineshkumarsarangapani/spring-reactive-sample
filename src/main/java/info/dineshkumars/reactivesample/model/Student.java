package info.dineshkumars.reactivesample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Student {

  private String id;
  private String name;
  private int age;
  private String location;
  private Marks marks;

  public Student(String id, String name, int age, String location, Marks marks) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.location = location;
    this.marks = marks;
  }

}
