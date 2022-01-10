package com.chenshuhong.blog.strategy;

import java.math.BigDecimal;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-10 15:29
 */
public class DiscountStrategyContext {

  //默认的用户处理策略
  private  DiscountStrategy discountStrategy= new OrdinaryDiscountStrategy();

  public void  setDiscountStrategy(DiscountStrategy discountStrategy){
    this.discountStrategy=discountStrategy;
  }



  public BigDecimal getDiscount(BigDecimal total){
   return discountStrategy.getDiscount(total);
  }



}
