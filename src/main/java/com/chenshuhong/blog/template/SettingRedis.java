package com.chenshuhong.blog.template;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-11 15:07
 */
public class SettingRedis  extends  SettingAbstract{
  @Override
  protected String readFromDatabase(String key) {
    return null;
  }

  @Override
  protected String getCache(String key) {
    return null;
  }

  @Override
  protected String putCache(String key, String value) {
    return null;
  }
}
