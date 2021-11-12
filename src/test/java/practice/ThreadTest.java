package practice;

import org.junit.Test;

/**
 * @Auther ChenShuHong
 * @Date 2021-11-11 10:09
 *
 * 多线程的模式
 *
 * 计算机里面一个任务代表一个进程，（一个进程里面有多个线程）都线程的逻辑就是多个任务多个线程
 * 进程和线程的关系就是：一个进程可以包含一个或多个线程，但至少会有一个线程。
 *
 *
 * java程序时间上是一个JVM进程，JVM进程用一个主线程来执行main  方法，在main方法内部，我们可以启动多个线程
 * 此外，JVM还有一些负责垃圾回收的其他工作线程等
 *
 * 使用Thread可以启动多一个先的线程  里面实现的runnable  可以实现操作
 *
 *
 * 第二阶段 线程有一下六种状态
 *
 * New：新创建的线程，尚未执行；
 * Runnable：运行中的线程，正在执行run()方法的Java代码；
 * Blocked：运行中的线程，因为某些操作被阻塞而挂起；
 * Waiting：运行中的线程，因为某些操作在等待中；
 * Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
 * Terminated：线程已终止，因为run()方法执行完毕
 *
 * 第三阶段
 *
 * join  线程等待返回再往下执行
 * volatile（告诉服务器每次去拿最新的值）
 * 多个线程，可以定义线程的优先级
 * thread.setPriority(1); // 1~10, 默认值5
 * 线程中断（例如用户下载文件，感觉下载太慢，点击取消）
 * thread.interrupt();
 * 守护线程（类似任务定时器，等其他线程都结束的时候，它也必须结束，jvm退出）
 *  thread.setDaemon(true);
 *
 *
 *
 */
public class ThreadTest {


  /**
   * 新创建多一个线程示例
   */
  @Test
  public void newThread() {
    System.out.println("main  star ");
    Thread thread = new Thread(()->{
      System.out.println("run star");
      System.out.println("process run new Thread  ");
      System.out.println("run end");
    });
    thread.start();
    System.out.println("main  end ");
  }

  /**
   * 等待线程返回结果，主线程才执行结束
   * join 等待
   * 如果是多个线程的话可以设置线程优先级
   * thread.setPriority(1); // 1~10, 默认值5
   */
  @Test
  public void stopReturnThread() throws InterruptedException {

    System.out.println("main star");
    Thread thread = new Thread(()->{
      System.out.println("star run Thread ");
    });
    thread.setPriority(1); // 1~10, 默认值5
    thread.start();
    thread.join();
    System.out.println("main end");
  }

  /**
   *
   * @throws InterruptedException
   *
   * 线程中断
   *  thread.interrupt();
   *  等待返回
   *  thread.join();
   *
   *
   */

  @Test
  public void stopThread() throws InterruptedException {

    Thread thread = new MyThread();
    thread.start();
    Thread.sleep(10);
    thread.interrupt();
    thread.join();
    System.out.println("end");


  }

  class  MyThread extends  Thread{
    @Override
    public void run() {
      int n =0;
      while (!isInterrupted()){
        n++;
        System.out.println("run    "+n);
      }
    }
  }


  /**
   *
   * @throws InterruptedException
   *
   * volatile（告诉服务器每次去拿最新的值）
   * volatile关键字的目的是告诉虚拟机：
   *     每次访问变量时，总是获取主内存的最新值；
   *     每次修改变量后，立刻回写到主内存。
   */
  @Test
  public void interruptThread() throws InterruptedException {

    HelloThread t= new HelloThread();
    t.start();
    Thread.sleep(1000);
    System.out.println("end");
    t.runnig=false;


  }

  class  HelloThread extends  Thread{

    public volatile  boolean runnig=true;

    @Override
    public void run() {
    int n=0;
    while (runnig){
      System.out.println(n +"hello ");
      n++;
    }
    }
  }

  /**
   *
   * @throws InterruptedException
   * 主线程结束之后，守护线程自动结束
   *   thread.setDaemon(true);
   */
  @Test
  public void daemonThread() throws InterruptedException {
    Thread thread = new DaemonThread();
    thread.setDaemon(true);
    thread.start();
    Thread.sleep(100);
  }
  class  DaemonThread extends  Thread{
    @Override
    public void run() {
      while (true){
        System.out.println("daemon  run .....");
      }
    }
  }

  /**
   *
   * @throws InterruptedException
   */

  @Test
  public void synchronizeThread() throws InterruptedException {

    Thread addThread = new AddThread();
    addThread.start();
    Thread decThread = new DecThread();
    decThread.start();

    addThread.join();
    decThread.join();
    System.out.println(Counter.count);

  }


  /**
   * 操作对象，为了保证同时只有一个人操作的唯一性，所以锁是定义在该对象里面的
   */
  static class Counter{
    public static  final  Object lock=new Object();
    public static int count=0;
  }

  class  AddThread extends  Thread{

    @Override
    public void run() {
      for(int i=0;i<100;i++){
        synchronized (Counter.lock){
          Counter.count ++;
        }
      }
    }
  }


  class  DecThread extends  Thread{

    @Override
    public void run() {
      for(int i=0;i<100;i++){
        synchronized (Counter.lock){
          Counter.count --;
        }
      }
    }
  }


  /**
   *
   * @throws InterruptedException
   *
   * 同步方法：
   *
   *  synchronized  锁住的是对象的this 即当前实例，这又是创建多个CountSynchronized实例的时候，它们之间不会相互影响，可以并发执行
   *
   */

  @Test
  public void synchronizedThread() throws InterruptedException {

    AddSynchronize  addThread = new AddSynchronize();
    addThread.start();

    DecSynchronized decThread = new DecSynchronized();
    decThread.start();

    addThread.join();
    decThread.join();

    System.out.println("return   "+ CountSynchronized.get());

  }

  /**
   * 定义同步方法，锁this当前对象
   */
  static  class CountSynchronized{

    public  static  volatile int  count=0;


   void addCount(){
      synchronized (this) {
        count++;
      }
    }

    void decCount(){
      synchronized (this) {
        count--;
      }
    }

    static  int get(){
      return  count;
    }

  }


  class AddSynchronize  extends  Thread{

    @Override
    public void run() {
      CountSynchronized countSynchronized = new CountSynchronized();
      for(int i=0; i<100;i++){
        countSynchronized.addCount();

      }
    }
  }

  class  DecSynchronized extends Thread{
    @Override
    public void run() {
      CountSynchronized countSynchronized = new CountSynchronized();
      for(int i=0; i<100;i++){
        countSynchronized.decCount();
      }
    }
  }

}
