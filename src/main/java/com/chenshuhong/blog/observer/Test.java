package com.chenshuhong.blog.observer;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-07 14:24
 */
public class Test {

  public static void main(String[] args) {
    Customer customer = new Customer();
    Admin admin= new Admin();


    Store store = new Store();
    store.addProductObserver(customer);
    store.addProductObserver(admin);
    store.addNewProduct("yifu",11);
  }


}
