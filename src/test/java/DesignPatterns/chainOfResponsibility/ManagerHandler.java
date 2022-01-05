package DesignPatterns.chainOfResponsibility;

import java.math.BigDecimal;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-05 11:05
 */
public class ManagerHandler  implements Handler {
  public Boolean process(Request request) {
    // 如果超过1000元，处理不了，交下一个处理:
    if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
      return null;
    }

    // 对Bob有偏见:
    return !request.getName().equalsIgnoreCase("bob");
  }
}
