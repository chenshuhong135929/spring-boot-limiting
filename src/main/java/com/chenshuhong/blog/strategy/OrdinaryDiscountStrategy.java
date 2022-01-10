package com.chenshuhong.blog.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-10 15:25
 * 普通用户
 */
public class OrdinaryDiscountStrategy  implements  DiscountStrategy{
  @Override
  public BigDecimal getDiscount(BigDecimal total) {
    // 普通会员打九折:
    return total.multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.DOWN);
  }
}
