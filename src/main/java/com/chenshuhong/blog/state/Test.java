package com.chenshuhong.blog.state;

import java.util.Scanner;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-07 15:34
 */
public class Test {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BotContext bot = new BotContext();
    for (;;) {
      System.out.print("> ");
      String input = scanner.nextLine();
      String output = bot.chat(input);
      System.out.println(output.isEmpty() ? "(no reply)" : "< " + output);
    }
  }
}
