package base;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringJoiner;

/**
 * @Auther ChenShuHong
 * @Date 2021-11-19 10:46
 *
 * java 8 大类型
 *
 *  byte  8 (-2^7~2^7-1) short  16(-2^15~2^15-1)  int  32 (-2^31~2^31-1) long   64(-2^63~2^63-1)   boolean 8 (true false ) float  32 (-2^31~2^31-1)  char  16 (0~2^16-1)  double 64(-2^63~2^63-1)
 *  StringBuffer   StringBuilder  说明 ：StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）
 *  （1）多线程操作字符串缓冲区下操作大量数据 StringBuffer；
 *  （2）单线程操作字符串缓冲区下操作大量数据 StringBuilder.
 * break会跳出当前循环，也就是整个循环都不会执行了。而continue则是提前结束本次循环，直接继续执行下次循环。
 *
 *
 *
 * 作用域
 * protected  public   private(私有化)
 * public   : 定义为public的class、interface可以被其他任何类访问：
 * private  : 定义为private的field、method无法被其他类访问：
 * protected  : protected作用于继承关系。定义为protected的字段和方法可以被子类访问，以及子类的子类：
 *
 *
 * JavaBean是一种符合命名规范的class，它通过getter和setter来定义属性；
 *
 * 属性是一种通用的叫法，并非Java语法规定；
 *
 * 可以利用IDE快速生成getter和setter；
 *
 * 使用Introspector.getBeanInfo()可以获取属性列表。
 *
 */
public class Constants{


  /**
   * break会跳出当前循环，也就是整个循环都不会执行了。而continue则是提前结束本次循环，直接继续执行下次循环。
   */
  @Test
  public  void  BreakContinueTest(){
    while (true){
      System.out.println(1);
      break;
    }

    while (true){
      System.out.println(3);
      continue;
    }

  }

  /**
   * Arrays数组提供了打印方法  Arrays.toString();
   * Arrays数组停供了排序方法  Arrays.sort()
   */
  @Test
  public void arraysIntTest(){

    int [] arrays ={3,5,1,9,6};
    System.out.println(Arrays.toString(arrays));
    Arrays.sort(arrays);
    System.out.println(Arrays.toString(arrays));
  }

  /**
   * 二维数组
   * Arrays.deepToString打印二维数组
   */
  @Test
  public void twoArraysIntTest(){

    int [][] arrays ={{3,5,1,9,6},{2,6,4,8,},{8,6,5,4}};
    System.out.println(Arrays.deepToString(arrays));

  }


  /**
   * java 多态
   */
  @Test
  public void  polymorphism(){

    Person p = new Student("chenshuhong",27);
    p.run();

  }


  //父类
  class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return this.name;
    }

    public int getAge() {
      return this.age;
    }
    public void run(){
      System.out.println("我是父类");
    }

  }

  /**
   * java继承，子类可以引用父类方法，也可以重新父类方法
   */
  class  Student extends  Person{

    public Student(String name, int age) {
      super(name, age);
    }

    @Override
    public void run() {
      System.out.println("我是子类");
    }
  }


  /**
   * 方法重载
   *
   * 构造方法
   */
  @Test
  public void overLoad(){
//方法重载
    Hello hello = new Hello();
    hello.hello();
    hello.hello("cheshuhong");

//构造方法
    Person p = new Person("chenshuhong",27);
  }

  class Hello {
    public void hello(){
      System.out.println("hello 我是无参方法");
    }

    public void hello(String text){
      System.out.println(text+"    hello 我是有参方法");
    }

  }

  /**
   * 抽象类实例
   */

  @Test
  public void abstractTest(){
    AbstractPerson abstractPerson=   new AbstractStudent();
    abstractPerson.run();
  }


  //抽象类
  abstract class  AbstractPerson {

    public void run(){
      System.out.println("abstractPerson");
    }


  }


  class  AbstractStudent extends AbstractPerson{
    @Override
    public void run() {
      System.out.println("AbstractStudent");
    }
  }

  /**
   * 内部类Class的实例不能单独存在，必须依附于一个父类 Class的实例
   */
  @Test
  public void innerTest(){
    Constants constants = new Constants();
    Inner inner = constants.new Inner();
    inner.hello();
  }

  class Inner{
    void hello(){
      System.out.println("hello");
    }
  }

    public static void main(String[] args) {
      HashMap<String, String> map1 = new HashMap<>();
      HashMap<String, String> map2 = new HashMap() {}; // 匿名类!
      HashMap<String, String> map3 = new HashMap() {
        {
          put("A", "1");
          put("B", "2");
        }
      };
      System.out.println(map3.get("A"));
      MapTest  t = new MapTest(){
        {
          dd("dd");
        }
      };
    }

    @Test
    public void stringJoin(){

    String [] strings = new String[]{"chen","shu","hong"};


      StringJoiner stringJoiner = new StringJoiner(",","start","end");

      Arrays.stream(strings).forEach(x->stringJoiner.add(x));

      System.out.println(stringJoiner.toString());
      String join = String.join(",", strings);
      System.out.println(join);
    }

}
