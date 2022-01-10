package com.chenshuhong.blog.observer;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-07 14:02
 */
public class Customer implements ProductObserver {


  public  void   onPublished(Product product){

    System.out.println("consumer published");
  }

  public   void onPriceChanged(Product product){
    System.out.println("admin onPriceChanged");
  }
}
