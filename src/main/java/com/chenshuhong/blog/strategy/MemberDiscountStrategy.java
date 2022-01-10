package com.chenshuhong.blog.strategy;

import java.math.BigDecimal;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-10 15:28
 * 会员策略
 */
public class MemberDiscountStrategy implements  DiscountStrategy {
  @Override
  public BigDecimal getDiscount(BigDecimal total) {

    return total.compareTo(BigDecimal.valueOf(100)) >= 0? total.subtract(BigDecimal.valueOf(20)):total  ;
  }


}
