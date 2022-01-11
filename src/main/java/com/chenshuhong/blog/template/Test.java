package com.chenshuhong.blog.template;


/**
 * @Auther ChenShuHong
 * @Date 2022-01-11 14:39
 */
public class Test {

  public static void main(String[] args) {

    //使用模板一
    SettingAbstract settingAbstract = new SettingCache();
    String cache = settingAbstract.getString("1");
    System.out.println(cache);
     cache = settingAbstract.getString("1");
    System.out.println(cache);

    //使用模板二
    SettingAbstract settingRedis = new SettingRedis();

  }

}
