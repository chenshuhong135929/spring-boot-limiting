package DesignPatterns.bridging;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-31 11:27
 */
public class BossCar extends RefinedCar {
  public BossCar(Engine engine) {
    super(engine);
  }

  public String getBrand() {
    return "Boss";
  }
}
