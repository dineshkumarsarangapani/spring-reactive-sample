package info.dineshkumars.reactivesample.model;


import java.util.Random;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Marks {

  private int english;
  private int datascience;
  private int math;
  private int stats;

  public Marks(int english, int datascience, int math, int stats) {
    this.english = english;
    this.datascience = datascience;
    this.math = math;
    this.stats = stats;
  }

  public static Marks getRandomMarks() {
    Random random = new Random();
    int english = random.nextInt(100);
    int datascience = random.nextInt(100);
    int math = random.nextInt(100);
    int stats = random.nextInt(100);
    return new Marks(english, datascience, math, stats);
  }
}
