package practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther ChenShuHong
 * @Date 2021-11-09 10:45
 *
 * 动态代理的示例
 *
 */
public class InvokeTest {


  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    //动态代理，调用方法
    HelloService helloService = HelloProxyHandler();
    String hello = helloService.Hello("shuHong.Chen");
    System.out.println(hello);



    //通过反射调用方法
    Method helloMethod = helloService.getClass().getMethod("Hello", String.class);
    Object text = helloMethod.invoke(helloService,"小明");
    System.out.println(text);
  }


  private static  HelloService  HelloProxyHandler() {
    InvocationHandler invocationHandler =(proxy, method, a)->{
      if(method.getName().equals("Hello")){
          return a[0]+"  Hello";
      }
      return null;
    };
   return (HelloService) Proxy.newProxyInstance(HelloService.class.getClassLoader(), new Class[]{HelloService.class}, invocationHandler);
  }


}


interface  HelloService{

  String Hello(String text);

}
