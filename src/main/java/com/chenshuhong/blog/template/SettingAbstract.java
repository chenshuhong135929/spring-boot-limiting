package com.chenshuhong.blog.template;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-11 10:45
 */
public abstract  class SettingAbstract {


  String getString(String key){
    String value = getCache(key);
    if (value == null) {
      value = readFromDatabase(key);
      putCache(key, value);
    }

    return value;
  }

  protected abstract String readFromDatabase(String key);


  protected  abstract  String  getCache(String key);

  protected  abstract  String putCache(String key,String value);



}
