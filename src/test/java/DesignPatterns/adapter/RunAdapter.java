package DesignPatterns.adapter;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-29 15:09
 */
public class RunAdapter implements  Runnable {

  public RunAdapter(Callable callable) {
    this.callable = callable;
  }

  private Callable callable;

  @SneakyThrows
  @Override
  public void run() {
    Object call = callable.call();
    System.out.println(call);
  }
}
