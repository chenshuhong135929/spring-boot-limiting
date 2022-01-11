package com.chenshuhong.blog.template;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-11 13:53
 */
public class SettingCache extends  SettingAbstract {

  private final Map<String,String>cacheContarner = new HashMap<>();


  @Override
  protected String readFromDatabase(String key) {
    return String.valueOf(new Random().nextInt(100));
  }

  @Override
  protected String getCache(String key) {
    return cacheContarner.get(key);
  }

  @Override
  protected String putCache(String key,String value) {

    return cacheContarner.put(key,value);
  }
}
