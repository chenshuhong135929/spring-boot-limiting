package DesignPatterns.adapter;

import java.util.concurrent.Callable;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-29 15:08
 */
public class Test {

  public static void main(String[] args) {


    Callable callable = new Task(1l);

    Thread t = new Thread(new RunAdapter(callable));
    t.start();

  }

}
