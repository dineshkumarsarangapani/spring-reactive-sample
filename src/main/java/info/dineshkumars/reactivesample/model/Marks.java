package info.dineshkumars.reactivesample.model;


import java.util.Random;

public class Marks {

  private int english;
  private int datascience;
  private int math;
  private int stats;

  public Marks() {

  }

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

  public int getEnglish() {
    return english;
  }

  public void setEnglish(int english) {
    this.english = english;
  }

  public int getDatascience() {
    return datascience;
  }

  public void setDatascience(int datascience) {
    this.datascience = datascience;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }

  public int getStats() {
    return stats;
  }

  public void setStats(int stats) {
    this.stats = stats;
  }

  @Override
  public String toString() {
    return "Marks{" +
        "english=" + english +
        ", datascience=" + datascience +
        ", math=" + math +
        ", stats=" + stats +
        '}';
  }
}
