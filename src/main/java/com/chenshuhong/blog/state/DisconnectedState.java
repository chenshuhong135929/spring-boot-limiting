package com.chenshuhong.blog.state;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-07 15:35
 */
public class DisconnectedState implements State {
  public String init() {
    return "Bye!";
  }

  public String reply(String input) {
    return "";
  }
}
