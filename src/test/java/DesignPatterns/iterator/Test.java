package DesignPatterns.iterator;

import java.util.Iterator;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-05 17:09
 * 迭代器
 */
public class Test {
  public static void main(String[] args) {
    ReverseArrayCollection<String> reverseArrayCollection = new ReverseArrayCollection<>("a", "b", "c");
    Iterator<String> iterator = reverseArrayCollection.iterator();
    while (iterator.hasNext()){
      System.out.println(iterator.next());
    }
  }
}
