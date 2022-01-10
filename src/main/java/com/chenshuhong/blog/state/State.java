package com.chenshuhong.blog.state;

public interface State {
  String init();
  String reply(String input);
}
