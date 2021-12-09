package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;


/**
 * @Auther ChenShuHong
 * @Date 2021-12-08 14:45
 */
public class JuniTest {
  /**
   *
   * Junit5.0以下有一些注解不能使用  5.0以下  @Before @After   5.0以上  @BeforeEach @AfterEach
   *
   * JUnit是一个单元测试框架，专门用于运行我们编写的单元测试：
   * 一个JUnit测试包含若干@Test方法，并使用Assertions进行断言，注意浮点数assertEquals()要指定delta。
   *
   *
   * 编写Fixture是指针对每个@Test方法，编写@BeforeEach方法用于初始化测试资源，编写@AfterEach用于清理测试资源；
   * 必要时，可以编写@BeforeAll和@AfterAll，使用静态变量来初始化耗时的资源，并且在所有@Test方法的运行前后仅执行一次。
   *
   *
   *
   * 测试异常可以使用assertThrows()，期待捕获到指定类型的异常；
   *
   * 对可能发生的每种类型的异常都必须进行测试。
   *
   * 参数既可以在测试代码中写死，也可以通过@CsvFileSource放到外部的CSV文件中。
   */





  Calculator calculator;

  // @BeforeEach
  @Before
  public void setUp() {
    System.out.println("before  之前  初始化");
    this.calculator = new Calculator();
  }

  //  @AfterEach
  @After
  public void tearDown() {
    this.calculator = null;
    System.out.println("After 之后");
  }

  @Test
  public  void testAdd() {

    Assertions.assertEquals(100, this.calculator.add(100));
    Assertions.assertEquals(150, this.calculator.add(50));
    Assertions.assertEquals(130, this.calculator.add(-20));
  }

  @Test
  public  void testSub() {
    System.out.println("执行内容。。。");
    Assertions.assertEquals(-100, this.calculator.sub(100));
    Assertions.assertEquals(-150, this.calculator.sub(50));
    Assertions.assertEquals(-130, this.calculator.sub(-20));
  }


  /**
   * 测试异常可以使用assertThrows()，期待捕获到指定类型的异常；
   *
   * 对可能发生的每种类型的异常都必须进行测试。
   */

  @Test
  public void  testException(){
    Assertions.assertThrows(RuntimeException.class,()->{});
    exceptionAdd();
  }



  public  void   exceptionAdd(){
    throw new RuntimeException("异常");
  }


  @ParameterizedTest
  @ValueSource(ints = { 0, 1, 5, 100 })
  public  void testAbs(int x) {
    System.out.println(x);
    Assertions.assertEquals(x, Math.abs(x));
  }


//最简单的方法是通过@MethodSource注解，它允许我们编写一个同名的静态方法来提供测试参数
/*  @ParameterizedTest
  @MethodSource
  void testCapitalize(String input, String result) {
    System.out.println(input+"   "+result);
    Assertions.assertEquals(result, StringUtils.capitalize(input));
  }*/

  static List<Arguments> testCapitalize() {
    return Arrays.asList( // arguments:
        Arguments.arguments("abc", "Abc"), //
        Arguments.arguments("APPLE", "Apple"), //
        Arguments.arguments("gooD", "Good"));
  }

//另一种传入测试参数的方法是使用@CsvSource，它的每一个字符串表示一行，一行包含的若干参数用,分隔，因此，上述测试又可以改写如下：
  @ParameterizedTest
  @CsvSource({ "abc, Abc", "APPLE, Apple", "gooD, Good" })
  void testCapitalize(String input, String result) {
    System.out.println(input+"   "+result);
    Assertions.assertEquals(result, StringUtils.capitalize(input));
  }

//如果有成百上千的测试输入，那么，直接写@CsvSource就很不方便。这个时候，我们可以把测试数据提到一个独立的CSV文件中，然后标注上@CsvFileSource：
  @ParameterizedTest
  @CsvFileSource(resources = { "/test-capitalize.csv" })
  void testCapitalizeUsingCsvFile(String input, String result) {
    Assertions.assertEquals(result, StringUtils.capitalize(input));
  }
}
