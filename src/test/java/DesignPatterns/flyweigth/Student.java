package DesignPatterns.flyweigth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-04 15:37
 *
 * 二级缓存就是享元模式的实例
 *
 */
public class Student {

  final  static   ConcurrentMap<String ,Student>map = new ConcurrentHashMap<>();

  private int id ;
  private String name;

  public Student() {
  }

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


  public Student(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public static  Student createStudent(int id, String name){

    String key = id+"/n"+name;

    Student std  = map.get(key);
    if(std ==null){

      System.out.println(String.format("create new Student(%s, %s)", id, name));
       std  = new Student(id, name);
      map.put(key,new Student(id,name));


    }else {
      System.out.println(String.format("create cache  Student(%s, %s)", id, name));

    }


    return  std ;
  }

}
