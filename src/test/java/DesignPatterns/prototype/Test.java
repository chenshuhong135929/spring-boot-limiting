package DesignPatterns.prototype;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-29 11:35
 */

public class Test {

  @org.junit.Test
  public void test(){

    Student student = new Student(1,"xiaoming",22);
    Student studentClone = student.clone();
    System.out.println(studentClone.getName());
  }

}
