package DesignPatterns.factorymethod;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-10 16:47
 */
public interface NumberFactory {
  // 创建方法:
  Number parse(String s);

  // 获取工厂实例:
  static NumberFactory getFactory() {
    return impl;
  }

  NumberFactory impl = new NumberFactoryImpl();




}
