package practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther ChenShuHong
 * @Date 2021-11-09 14:59
 *
FixedThreadPool：线程数固定的线程池；
CachedThreadPool：线程数根据任务动态调整的线程池；
SingleThreadExecutor：仅单线程执行的线程池。

 线程池主要是复用已有的线程执行操作，可以避免没必要的创建跟销毁线程的时间

 */
public class ExecutorTest {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    //ExecutorService executorService = Executors.newFixedThreadPool(10);
   // ExecutorService executorService = Executors.newSingleThreadExecutor();
    for(int i=0;i<100;i++){
      executorService.submit(()->
        System.out.println(Thread.currentThread().getName())
      );
    }

    executorService.shutdown();
  }


}
