package com.chenshuhong.blog.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-07 14:02
 */
public class Store implements  ProductObservable{
  /*

  将观察者定义在list  ProductObserver中，如果需要再添加通知的时候就直接用class implements  ProductObserver
   */
  private static List<ProductObserver> observers = new ArrayList<>();

  private Map<String ,Product>products = new HashMap<>();




  //添加观察者
  public   void addProductObserver(ProductObserver productObserver){

    observers.add(productObserver);
  }


  //删除观察者
  public   void removedProductObserver(ProductObserver productObserver){
    observers.remove(productObserver);
  }



  public void  addNewProduct(String name , double price){
    Product product = new Product(name,price);
    products.put(product.getName(),product);
    observers.stream().forEach(x->x.onPublished(product));

  }


  public void setProductPrice(String name, double price){
    Product product = products.get(name);
    product.setPrice(price);
    observers.stream().forEach(x->x.onPriceChanged(product));

  }

}
