package practice;

import org.junit.Test;

import java.util.*;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-01 15:24
 *
 *
 *  List是按索引顺序访问的长度可变的有序表，优先使用ArrayList而不是LinkedList；
 *
 *  可以直接使用for each遍历List；
 *
 *  List可以和Array相互转换。
 *
 *  HashSet是无序的，因为它实现了Set接口，并没有实现SortedSet接口；
 *  TreeSet是有序的，因为它实现了SortedSet接口。
 *
 *  队列Queue实现了一个先进先出（FIFO）的数据结构：
 *
 *     通过add()/offer()方法将元素添加到队尾；
 *     通过remove()/poll()从队首获取元素并删除；
 *     通过element()/peek()从队首获取元素但不删除。
 *
 *     PriorityQueue实现了一个优先队列：从队首获取元素时，总是获取优先级最高的元素。
 *
 * PriorityQueue默认按元素比较的顺序排序（必须实现Comparable接口），也可以通过Comparator自定义排序算法（元素就不必实现Comparable接口）。
 *
 *
 * Deque实现了一个双端队列（Double Ended Queue），它可以：
 *
 *     将元素添加到队尾或队首：addLast()/offerLast()/addFirst()/offerFirst()；
 *     从队首／队尾获取元素并删除：removeFirst()/pollFirst()/removeLast()/pollLast()；
 *     从队首／队尾获取元素但不删除：getFirst()/peekFirst()/getLast()/peekLast()；
 *     总是调用xxxFirst()/xxxLast()以便与Queue的方法区分开；
 *
 *     线程安全集合
 *
 * Collections还提供了一组方法，可以把线程不安全的集合变为线程安全的集合：
 *
 *     变为线程安全的List：List<T> synchronizedList(List<T> list)
 *     变为线程安全的Set：Set<T> synchronizedSet(Set<T> s)
 *     变为线程安全的Map：Map<K,V> synchronizedMap(Map<K,V> m)
 *
 */
public class ListTest {


  @Test
  public void test1(){
    List<String> list = Arrays.asList("a", "b", "c");
    LinkedList<Object> objects = new LinkedList<>();
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()){
      System.out.println(iterator.next());
    }

  }

  @Test
  public void test2(){
    Queue<String> q = new LinkedList<>();
    // 添加3个元素到队列:
    q.offer("apple");
    q.offer("pear");
    q.offer("banana");
    // 从队列取出元素:
    System.out.println(q.poll()); // apple
    System.out.println(q.poll()); // pear
    System.out.println(q.poll()); // banana
    System.out.println(q.poll()); // null,因为队列是空的


  }
  @Test
  public void test3() {
    PriorityQueue<User> queue =new  PriorityQueue(new UserComparator());
    queue.offer(new User("a","aa"));
    queue.offer(new User("Va","V"));
    queue.offer(new User("ad","ada"));
    queue.offer(new User("Vad","Vd"));

    for(User u : queue){
      System.out.println(u.numder);
    }
  }


  class   UserComparator implements  Comparator<User>{


    @Override
    public int compare(User o1, User o2) {

      if(o1.numder.charAt(0)==o2.numder.charAt(0)){

        return   o1.numder.compareTo(o2.numder);

      }

      if(o1.numder.charAt(0)  == 'V'){
          return -1;
      }else {
        return 1;
      }


    }
  }


  class  User{

    private  String name;
    private String  numder;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getNumder() {
      return numder;
    }

    public void setNumder(String numder) {
      this.numder = numder;
    }

    public User(String name, String numder) {
      this.name = name;
      this.numder = numder;
    }
  }
  @Test
  public void test4() {

    Deque<String> deque = new LinkedList<>();
    deque.offerLast("A"); // A
    deque.offerLast("B"); // A <- B
    deque.offerFirst("C"); // C <- A <- B
    System.out.println(deque.pollFirst()); // C, 剩下A <- B
    System.out.println(deque.pollLast()); // B, 剩下A
    System.out.println(deque.pollFirst()); // A
    System.out.println(deque.pollFirst()); // null

  }

}
