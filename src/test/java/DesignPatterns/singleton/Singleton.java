package DesignPatterns.singleton;


/**
 * @Auther ChenShuHong
 * @Date 2021-12-29 14:22
 */
public class Singleton {

  //静态字段应用唯一实例
  private static final Singleton singleton = new Singleton();

  //通过静态方法返回实例
  public static  Singleton getInstance(){
    return  singleton;
  }


  //private 构建方法保证外部无法实例化
  private Singleton(){

  }


}
