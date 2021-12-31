package DesignPatterns.bridging;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-31 11:26
 */
public abstract  class RefinedCar extends Car {

  public RefinedCar(Engine engine) {
    super(engine);
  }
  public void drive() {
    this.engine.start();
    System.out.println("Drive " + getBrand() + " car...");
  }

  public abstract String getBrand();
}
