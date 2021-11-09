package practice;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Auther ChenShuHong
 * @Date 2021-11-09 11:28
 */
public class CompletableFutureTest {


  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<String> future = completableFutureHello();
    future.get();
  }

  private static CompletableFuture<String> completableFutureHello() {
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
    return future;
  }


  public static  String  hello(String args ){
    return args;
  }
  public static  String  hello(){
    return "无参";
  }
}


