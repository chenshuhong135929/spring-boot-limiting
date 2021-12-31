package DesignPatterns.bridging;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-31 11:17
 */
public abstract class Car {
  // 引用Engine:
  protected Engine engine;

  public Car(Engine engine) {
    this.engine = engine;
  }

  public abstract void drive();
}
