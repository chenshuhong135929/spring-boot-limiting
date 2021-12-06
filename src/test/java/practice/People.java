package practice;

import java.io.Serializable;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-06 14:43
 */
public class People  implements Serializable {
  private  String name;
  private int age;


  public People(String name, int age) {
    this.name = name;
    this.age = age;
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
}
