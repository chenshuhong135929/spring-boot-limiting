package DesignPatterns.proxy;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-04 16:26
 */
public class Test {

  /**
   * 代理模式 proxy
   *
   * @param args
   */

  public static void main(String[] args) {
    A a = new AImpl();
    AProxy aProxy = new AProxy(a);
    aProxy.a();
  }


}
