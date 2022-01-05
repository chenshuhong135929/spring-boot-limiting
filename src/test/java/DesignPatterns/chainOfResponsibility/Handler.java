package DesignPatterns.chainOfResponsibility;

public interface Handler {

  /**
   * 返回Boolean true = 成功
   * 返回Boolean false = 拒绝
   * 返回Null = 交给下一个处理
   *
   * @param request
   * @return
   */
  Boolean process(Request request);

}
