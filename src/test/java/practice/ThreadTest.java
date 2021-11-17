package practice;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.*;

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
 * volatile（告诉服务器每次去拿最新的值）
 * volatile关键字的目的是告诉虚拟机：
 *     每次访问变量时，总是获取主内存的最新值；
 *     每次修改变量后，立刻回写到主内存。
 *
 *
 * （wait  notify 用于多线程协作运行 ）
 * wait  等待
 * notify  唤醒
 * notifyAll 唤醒所有线程
 *
 * 用reentrantLock (重入锁)
 * 或者锁   condition （在reentrantLock  中获取到的     .newCondition）
 * await ：等待  （跟synchronized 的wait等价）
 * signal ： 信号  （跟synchronized  的notify等价）
 * signalAll ： 全部信号  （跟synchronized 的notifyAll 等价）
 *
 *
 *
 * ReentrantReadwriteLock (重入读写锁)
 * 使用ReadWriteLock可以提高读取效率：
 * ReadWriteLock只允许一个线程写入
 * ReadWriteLock允许多个线程在没有写入时同时读取
 * ReadWriteLock适合读多写少的场景
 *
 *
 *
 * StampedLock提供了乐观读锁，可取代ReadWriteLock以进一步提升并发性能；
 *
 * StampedLock是不可重入锁。
 *
 *
 *
 *
 * concurrent 的应用
 *
 *  新建一个线程安全
 *  Map m = new ConcurrentHashMap();
 *
 *  将旧的容器改成线程安全的容器  concurrent提供的转换器
 *   Map unsafeMap = new HashMap();
 *   Map threadSafeMap = Collections.synchronizedMap(unsafeMap);
 *
 *
 *
 *
 *
 *
 *   atomic操作
 *    使用java.util.concurrent.atomic提供的原子操作可以简化多线程编程：
 *
 *         原子操作实现了无锁的线程安全；
 *
 *         适用于计数器，累加器等。
 *
 *    增加值并返回新值：int addAndGet(int delta)
 *    加1后返回新值：int incrementAndGet()
 *    获取当前值：int get()
 *    用CAS方式设置：int compareAndSet(int expect, int update)
 *
 *
 *    ThreadLocal表示线程的“局部变量”，它确保每个线程的ThreadLocal变量都是各自独立的；
 *
 * ThreadLocal适合在一个线程的处理流程中保持上下文（避免了同一参数在所有方法中传递）；
 *
 * 使用ThreadLocal要用try ... finally结构，并在finally中清除。
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


  /**
   *
   * @throws InterruptedException
   * （wait  notify 用于多线程协作运行 ）
   * wait  等待
   * notify  唤醒
   * notifyAll 唤醒所有线程
   *
   *
   */

  @Test
  public void notifyWaitThread() throws InterruptedException {
    List<Thread> ts = new ArrayList();
    TaskQueue taskQueue = new TaskQueue();
    Thread t1= new Thread(()->{

      while (true){
        String task = null;
        try {
          task = taskQueue.getTask();
        } catch (InterruptedException e) {
          return;
        }
        System.out.println("获取到的数据：    "+ task);
      }

    });
    ts.add(t1);

    Thread t2 = new Thread(()->{


      for(int i = 0; i<10; i++){
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        taskQueue.addTask("hello +"+ i);
      }


    });
    ts.add(t2);
    t1.start();
    t2.start();
    t2.join();
    ts.stream().forEach(x->x.interrupt());


  }



  /**
   *   notify  唤醒线程
   *   wait    等待线程
   *
   *
   */

  class TaskQueue{
   Queue<String> queue = new LinkedList();
   public synchronized void addTask(String s ){
     this.queue.add(s);
     //唤醒
     this.notify();
   }


   public synchronized String getTask() throws InterruptedException {
     while (queue.isEmpty()){
       //等待
        this.wait();
     }
     return  queue.remove();
   }


  }

  /**
   * synchronized 是java语言层面提供的语法，所以不需要考虑异常，ReentrantLock是java 代码实现的锁，我们需要在finally中正确释放锁
   * ReentrantLock 是可重入锁，它和synchronized 一样，一个线程可以多次获取同一个锁
   * 和synchronized不同的是，ReentrantLock可以尝试获取锁
   * ReentrantLock比synchronized获取锁更安全
   *
   */

  static class   ReenTranLockCount{

    Lock lock = new ReentrantLock();
    public static  volatile  int  count=0;

    public void add(){
      try {
        lock.lock();
        count ++;
      }finally {
        lock.unlock();
      }


    }

    public void dec(){
      try {
      lock.lock();
      count--;
      }finally {
        lock.unlock();
      }

    }

    public static int get(){
      return  count;
    }
  }


  /**
   *
   * @throws InterruptedException
   *
   * 用reentrantLock (重入锁)
   * await ：等待  （跟synchronized 的wait等价）
   * signal ： 信号  （跟synchronized  的notify等价）
   * signalAll ： 全部信号  （跟synchronized 的notifyAll 等价）
   *
   */

  @Test
  public void conditionThread() throws InterruptedException {
    List<Thread> list= new ArrayList();

    TaskQueueCondition t = new TaskQueueCondition();
    Thread t1 = new Thread(()->{
      while (true){
        String s = t.get();
        if(s==null){
          return;
        }
        System.out.println("得到的数据：    "+s);
      }

    });

    list.add(t1);

    Thread t2 = new Thread(()->{
     for(int i = 0;i<10; i++){
       try {
         Thread.sleep(10);
         t.add("data "+i);
       } catch (InterruptedException e) {
         e.printStackTrace();
       }

     }
    });

    list.add(t2);
    t1.start();
    t2.start();
    t2.join();

    list.stream().forEach(x->x.interrupt());


  }

  class TaskQueueCondition{

    private final   Lock lock =  new ReentrantLock();
    private final Condition condition = lock.newCondition();

   Queue<String> q = new LinkedList();

   public void add(String s){
     try {
       lock.lock();
       q.add(s);
       condition.signal();
     }finally {
       lock.unlock();
     }

   }


   public String get(){
     try {
       lock.lock();
       while (q.isEmpty()){
         condition.await();
       }
       return  q.remove();

     } catch (InterruptedException e) {

     } finally {
       lock.unlock();
     }
    return null;
   }
  }


  /**
   *
   * readwriteLock(读写锁的作用：可以多线程进行读取，写：允许一个线程进行写入，提供读的效率)
   */
  static class readWriteLockCount{

    //读写所对象
    private final ReadWriteLock  rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();

    public static int  count =0;

    public void add(){
      try {
        wlock.lock();
        count++;
      }finally {
        wlock.unlock();
      }


    }

    public int get(){
      try {
        rlock.lock();
        return  count;
      }finally {
        rlock.unlock();
      }

    }

  }

  /**
   * 是用读的过程中也允许获取写锁后写入
   *
   * 先使用乐观锁，然后判断版本号，如果版本号一致就通过，提高效率，如果版本号不一致，使用悲观锁从新获取数据
   *
   */
  class Point {
    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
      long stamp = stampedLock.writeLock(); // 获取写锁
      try {
        x += deltaX;
        y += deltaY;
      } finally {
        stampedLock.unlockWrite(stamp); // 释放写锁
      }
    }

    public double distanceFromOrigin() {
      long stamp = stampedLock.tryOptimisticRead(); // 获得一个乐观读锁
      // 注意下面两行代码不是原子操作
      // 假设x,y = (100,200)
      double currentX = x;
      // 此处已读取到x=100，但x,y可能被写线程修改为(300,400)
      double currentY = y;
      // 此处已读取到y，如果没有写入，读取是正确的(100,200)
      // 如果有写入，读取是错误的(100,400)
      if (!stampedLock.validate(stamp)) { // 检查乐观读锁后是否有其他写锁发生
        stamp = stampedLock.readLock(); // 获取一个悲观读锁
        try {
          currentX = x;
          currentY = y;
        } finally {
          stampedLock.unlockRead(stamp); // 释放悲观读锁
        }
      }
      return Math.sqrt(currentX * currentX + currentY * currentY);
    }
  }

  /**
   * 使用java.util.concurrent.atomic提供的原子操作可以简化多线程编程：
   *
   *     原子操作实现了无锁的线程安全；
   *
   *     适用于计数器，累加器等。
   *
   增加值并返回新值：int addAndGet(int delta)
   加1后返回新值：int incrementAndGet()
   获取当前值：int get()
   用CAS方式设置：int compareAndSet(int expect, int update)

   */
  @Test
  public void atomicThread(){
    AtomicLong atomicLong = new AtomicLong();
    System.out.println(atomicLong.addAndGet(1));
    System.out.println(atomicLong.incrementAndGet());
  }


  /**
   * ThreadLocal  的应用
   *  实现了接口AutoCloseable
   *  为了保证能释放ThreadLocal关联的实例，我们可以通过AutoCloseable接口配合try (resource) {...}结构，让编译器自动为我们关闭。例如，一个保存了当前用户名的ThreadLocal可以封装为一个UserContext对象：
   *
   *
   */

  @Test
  public void threadLocalTest() throws InterruptedException {
    Thread t = new Thread(()->{
      //ThreadLocal的释放交给编译器
      try (UserContext  ctx = new UserContext("Bob")) {
        // 可任意调用UserContext.currentUser():
        String currentUser = UserContext.currentUser();
        System.out.println(currentUser);
      } // 在此自动调用UserContext.close()方法释放ThreadLocal关联对象

    });
    t.start();
    t.join();

  }

  static class UserContext implements AutoCloseable {

    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public UserContext(String user) {
      ctx.set(user);
    }

    public static String currentUser() {
      return ctx.get();
    }

    @Override
    public void close() {
      ctx.remove();
    }
  }
}
