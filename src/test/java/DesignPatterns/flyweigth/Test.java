package DesignPatterns.flyweigth;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-04 15:50
 */
public class Test {

  public static void main(String[] args) {

    //第一次创建是二级缓存没有新建的
    Student.createStudent(1, "xiaoming");

    //第二次创建直接在缓存里面拿
    Student.createStudent(1, "xiaoming");
  }


}
