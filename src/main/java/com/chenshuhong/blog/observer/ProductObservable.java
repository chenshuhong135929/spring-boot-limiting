package com.chenshuhong.blog.observer;

public interface ProductObservable {
  //添加观察者
  void addProductObserver(ProductObserver productObserver);


  //删除观察者
  void removedProductObserver(ProductObserver productObserver);

}
