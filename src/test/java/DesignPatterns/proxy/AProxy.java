package DesignPatterns.proxy;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-04 16:20
 */
public class AProxy  implements A {
  private A a;
  public AProxy(A a) {
    this.a = a;
  }
  public void a() {
    //可以在调用方法前缀，或者后缀
    System.out.println("before  ");
    this.a.a();
    System.out.println("after  ");
  }
}
