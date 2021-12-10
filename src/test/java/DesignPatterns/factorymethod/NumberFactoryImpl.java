package DesignPatterns.factorymethod;

import java.math.BigDecimal;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-10 16:49
 */
public class NumberFactoryImpl implements NumberFactory {

  @Override
  public Number parse(String s) {
    return new BigDecimal(s);
  }
}
