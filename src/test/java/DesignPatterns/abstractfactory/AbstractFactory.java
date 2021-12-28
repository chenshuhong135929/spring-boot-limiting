package DesignPatterns.abstractfactory;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-10 17:04
 */
public  interface AbstractFactory {
   static AbstractFactory createFactory(String name) {
    if (name.equalsIgnoreCase("fast")) {
      return new FastFactory();
    } else if (name.equalsIgnoreCase("good")) {
      return new GoodFactory();
    } else {
      throw new IllegalArgumentException("Invalid factory name");
    }
  }

}
