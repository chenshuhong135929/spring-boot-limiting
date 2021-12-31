package DesignPatterns.bridging;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-31 11:29
 */
public class Test {
  public static void main(String[] args) {
    RefinedCar car = new BossCar(new HybridEngine());
    car.drive();
  }
}
