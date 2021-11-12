package practice;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Auther ChenShuHong
 * @Date 2021-11-09 11:28
 */
public class CompletableFutureTest {


  public static void main(String[] args) throws ExecutionException, InterruptedException {
 completableFutureHello();

  }

  private static  void  completableFutureHello() {
    //无参调用
  //  CompletableFuture<String> future = CompletableFuture.supplyAsync(CompletableFutureTest::hello);
    //有参调用
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> hello("nihao "));

    future.thenAccept(x->{
      System.out.println(x);
    });
    future.exceptionally(x->{
      throw new RuntimeException(x);
    });

  }


  public static  String  hello(String args ){
    return args;
  }
  public static  String  hello(){
    return "无参";
  }
}


