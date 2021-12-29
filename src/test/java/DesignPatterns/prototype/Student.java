package DesignPatterns.prototype;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-29 11:18
 */
public class Student implements Cloneable {
  private int id;
  private String name;
  private int score;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public Student(int id, String name, int score) {
    this.id = id;
    this.name = name;
    this.score = score;
  }

  @Override
  protected Student clone() {
    Student student=null;
    try {
      student=(Student)super.clone();

    }catch (CloneNotSupportedException e){
      e.printStackTrace();
    }
    return  student;
  }
}
