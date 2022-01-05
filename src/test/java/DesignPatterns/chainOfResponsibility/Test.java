package DesignPatterns.chainOfResponsibility;

import java.math.BigDecimal;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-05 13:43
 */
public class Test {
  public static void main(String[] args) {

    HandlerChain handlerChain = new HandlerChain();
    handlerChain.addHandler(new ManagerHandler());
    handlerChain.process(new Request("Bob", new BigDecimal("123.45")));
  }
}
