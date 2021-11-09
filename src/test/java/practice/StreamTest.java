package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther ChenShuHong
 * @Date 2021-11-09 11:14
 */
public class StreamTest {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("小明", "小红", "小强", "小梅");

    List<Student>students =  list.stream().map(Student::new).collect(Collectors.toList());
    students.stream().forEach(System.out::println);
    students.stream().sorted(Comparator.comparing(x->x.getName() ));
    students.stream().filter(x->x.getName().equals("小明")).forEach(System.out::println);
  }



}

class  Student{

  private String name;

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}




