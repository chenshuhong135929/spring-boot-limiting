package com.chenshuhong.blog.observer;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-07 14:03
 */
public class Admin implements ProductObserver{


  public   void onPublished(Product product){
    System.out.println("admin published");
  }
  public   void onPriceChanged(Product product){
    System.out.println("admin onPriceChanged");
  }

}
