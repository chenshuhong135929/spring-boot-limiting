package base;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @Auther ChenShuHong
 * @Date 2021-11-24 10:48
 * BigInteger用于表示任意大小的整数；
 *
 * BigInteger是不变类，并且继承自Number；
 *
 * 将BigInteger转换成基本类型时可使用longValueExact()等方法保证结果准确。
 *
 *
 * BigDecimal用于表示精确的小数，常用于财务计算；
 *
 * 比较BigDecimal的值是否相等，必须使用compareTo()而不能使用equals()。
 *
 *
 *
 *
 * Math：数学计算
 *
 * Random：生成伪随机数
 *
 * SecureRandom：生成安全的随机数
 *
 */
public class ExampleTest {


  @Test
  public static void main(String[] args) {

    BigInteger i1 = new BigInteger("1234567890");
    BigInteger i2 = new BigInteger("12345678901234567890");
    BigInteger sum = i1.add(i2);
    BigInteger i = new BigInteger("123456789000");
    System.out.println(i.longValue()); // 123456789000
    System.out.println(i.multiply(i).longValueExact());


  //  和BigInteger类似，BigDecimal可以表示一个任意大小且精度完全准确的浮点数。

    BigDecimal bd = new BigDecimal("123.4567");
    System.out.println(bd.multiply(bd)); // 15241.55677489

    //BigDecimal用scale()表示小数位数，例如：

    BigDecimal d1 = new BigDecimal("123.45");
    BigDecimal d2 = new BigDecimal("123.4500");
    BigDecimal d3 = new BigDecimal("1234500");
    System.out.println(d1.scale()); // 2,两位小数
    System.out.println(d2.scale()); // 4
    System.out.println(d3.scale()); // 0
    sacleTest();


  }

  private static void sacleTest() {
    //如果一个BigDecimal的scale()返回负数，例如，-2，表示这个数是个整数，并且末尾有2个0。

    // 可以对一个BigDecimal设置它的scale，如果精度比原始值低，那么按照指定的方法进行四舍五入或者直接截断：
    BigDecimal d11 = new BigDecimal("123.456789");
    BigDecimal d22 = d11.setScale(4, RoundingMode.HALF_UP); // 四舍五入，123.4568
    BigDecimal d33 = d11.setScale(4, RoundingMode.DOWN); // 直接截断，123.4567
    System.out.println(d22);
    System.out.println(d33);
  }
  private static void divideTest() {
    //对BigDecimal做加、减、乘时，精度不会丢失，但是做除法时，存在无法除尽的情况，这时，就必须指定精度以及如何进行截断：

    BigDecimal d1 = new BigDecimal("123.456");
    BigDecimal d2 = new BigDecimal("23.456789");
    BigDecimal d3 = d1.divide(d2, 10, RoundingMode.HALF_UP); // 保留10位小数并四舍五入
    BigDecimal d4 = d1.divide(d2); // 报错：ArithmeticException，因为除不尽
  }
  private static void divideAndRemainderTest() {
  //还可以对BigDecimal做除法的同时求余数：

  BigDecimal n = new BigDecimal("12.345");
  BigDecimal m = new BigDecimal("0.12");
  BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]); // 102
        System.out.println(dr[1]); // 0.105

    //调用divideAndRemainder()方法时，返回的数组包含两个BigDecimal，分别是商和余数，其中商总是整数，余数不会大于除数。我们可以利用这个方法判断两个BigDecimal是否是整数倍数：


    if (dr[1].signum() == 0) {
      // n是m的整数倍
    }

  }

  private static void compareToTest() {
    // 比较BigDecimal

    //在比较两个BigDecimal的值是否相等时，要特别注意，使用equals()方法不但要求两个BigDecimal的值相等，还要求它们的scale()相等：

    BigDecimal d1 = new BigDecimal("123.456");
    BigDecimal d2 = new BigDecimal("123.45600");
    System.out.println(d1.equals(d2)); // false,因为scale不同
    System.out.println(d1.equals(d2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为2
    System.out.println(d1.compareTo(d2)); // 0

    // 必须使用compareTo()方法来比较，它根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于。
  }



}
