package com.chenshuhong.blog.strategy;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-07 15:55
 */
public class Test {
  public static void main(String[] args)  {
   /* String[] array = { "apple", "Pear", "Banana", "orange" };
    Arrays.sort(array, String::compareToIgnoreCase);

    System.out.println(Arrays.toString(array));
    Arrays.stream(array).sorted(String::compareToIgnoreCase).forEach(System.out::println);*/


   DiscountStrategyContext discountStrategy=new DiscountStrategyContext() ;

// 默认使用普通会员折扣
    BigDecimal discount = discountStrategy.getDiscount(new BigDecimal(50));
    System.out.println(discount);
//使用会员
    discountStrategy.setDiscountStrategy(new MemberDiscountStrategy());
     discount = discountStrategy.getDiscount(new BigDecimal(100));
    System.out.println(discount);
  }
}
