package base;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @Auther ChenShuHong
 * @Date 2021-11-24 9:52
 * JavaBean是一种符合命名规范的class，它通过getter和setter来定义属性；
 *
 * 属性是一种通用的叫法，并非Java语法规定；
 *
 * 可以利用IDE快速生成getter和setter；
 *
 * 使用Introspector.getBeanInfo()可以获取属性列表
 */
public class JavaBeanTest {

  private String userName;
  private String password;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public static void main(String[] args) throws IntrospectionException {

    BeanInfo info = Introspector.getBeanInfo(JavaBeanTest.class);
    for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
      System.out.println(pd.getName());
      System.out.println("  " + pd.getReadMethod());
      System.out.println("  " + pd.getWriteMethod());
    }
  }
}
