package practice;

import io.swagger.models.auth.In;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    List<String> test1 = Arrays.asList("a,b,c,d,d", "1,12,3,6,5");
    test1.stream().map(x -> x.replaceAll(",", "")).forEach(System.out::println);

    test1.stream().flatMap(x -> {
      String[] split = x.split(",");
      return Arrays.stream(split);
    }).forEach(System.out::print);


    long count = Arrays.asList(1, 62, 3, 59, 8, 142, 5, 4, 55).stream().count();
    System.out.println("总汇="+count);
    Integer max = Arrays.asList(1, 62, 3, 59, 8, 142, 5, 4, 55).stream().max(Integer::compareTo).get();
    System.out.println("最大值="+max);
    Integer min = Arrays.asList(1, 62, 3, 59, 8, 142, 5, 4, 55).stream().min(Integer::compareTo).get();
    System.out.println("最小值="+min);
    Integer first = Arrays.asList(1, 62, 3, 59, 8, 142, 5, 4, 55).stream().findFirst().get();
    System.out.println("第一个元素="+ first);
    Integer any = Arrays.asList(1, 62, 3, 59, 8, 142, 5, 4, 55).stream().findAny().get();
    System.out.println("随机值="+any);
    boolean match= Arrays.asList(1, 62, 3, 59, 8, 142, 5, 4, 55).stream().allMatch(x -> x >= 1);
    System.out.println("全部匹配="+match);
    boolean anyMatch = Arrays.asList(1, 62, 3, 59, 8, 142, 5, 4, 55).stream().anyMatch(x -> x > 8);
    System.out.println("任意匹配="+anyMatch);



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




