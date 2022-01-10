package com.chenshuhong.blog.state;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-07 15:21
 */
public class ConnectedState implements State {
  public String init() {
    return "Hello, I'm Bob.";
  }

  public String reply(String input) {
    if (input.endsWith("?")) {
      return "Yes. " + input.substring(0, input.length() - 1) + "!";
    }
    if (input.endsWith(".")) {
      return input.substring(0, input.length() - 1) + "!";
    }
    return input.substring(0, input.length() - 1) + "?";
  }
}
