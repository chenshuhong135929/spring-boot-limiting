package DesignPatterns.adapter;

import java.util.concurrent.Callable;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-29 15:01
 */
public class Task implements Callable<Long> {

  private long x;


  public Task(long x) {
    this.x = x;
  }

  @Override
  public Long call() throws Exception {
    return x;
  }
}
