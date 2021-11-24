package base;

import java.util.Arrays;

/**
 * Java使用enum定义枚举类型，它被编译器编译为final class Xxx extends Enum { … }；
 *
 * 通过name()获取常量定义的字符串，注意不要使用toString()；
 *
 * 通过ordinal()返回常量定义的顺序（无实质意义）；
 *
 * 可以为enum编写构造方法、字段和方法
 *
 * enum的构造方法要声明为private，字段强烈建议声明为final；
 *
 * enum适合用在switch语句中。
 */
public enum EnumEntityTest {

  ONE(1,"星期一"),
  TWO(2,"星期二"),
  THREE(3,"星期三"),
  FOUR(4,"星期四"),
  FIVE(5,"星期五"),
  six(6,"星期六"),
  day(7,"星期日");



  private int  key;
  private  String value;

  EnumEntityTest(int key, String value) {
    this.key = key;
    this.value = value;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  static String getValueOf(int key){
    return Arrays.stream(values()).filter(x->x.key==key).findFirst().orElse(null).getValue();
  }

  public static void main(String[] args) {
    String valueOf = EnumEntityTest.getValueOf(EnumEntityTest.day.getKey());
    System.out.println(valueOf);
  }
}
