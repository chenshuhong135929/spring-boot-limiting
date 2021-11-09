package practice;

import java.util.function.Consumer;

/**
 * @Auther ChenShuHong
 * @Date 2021-11-09 11:45
 */
public class LambdaTest {
  public static void main(String[] args) {

  //  consumer().accept("你好");


  }


  /*
  消费者类型
  调用：
  consumer.accept("你好");
  * */
  private static Consumer<String> consumer() {
    Consumer<String> consumer=(x)->
      System.out.println(x);

  return consumer;
  }
}
