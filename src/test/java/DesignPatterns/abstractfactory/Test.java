package DesignPatterns.abstractfactory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-10 17:18
 * 抽象工厂模式是为了让创建工厂和一组产品与使用相分离，并可以随时切换到另一个工厂以及另一组产品；
 * 抽象工厂模式实现的关键点是定义工厂接口和产品接口，但如何实现工厂与产品本身需要留给具体的子类实现，客户端只和抽象工厂与抽象产品打交道
 */
public class Test {

  public static void main(String[] args) throws IOException {
    FastFactory fast = (FastFactory) AbstractFactory.createFactory("fast");
    HtmlDocument h = fast.createHtml("d");
    h.save(Paths.get(".",  h.toHtml()));
    WordDocument w = fast.createWord("d");
    w.save(Paths.get(".", "fast.doc"));

  }
}
