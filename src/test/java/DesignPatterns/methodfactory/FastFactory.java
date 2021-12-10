package DesignPatterns.methodfactory;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-10 17:11
 */
public class FastFactory implements AbstractFactory {
  public HtmlDocument createHtml(String md) {
    return new FastHtmlDocument(md);
  }
  public WordDocument createWord(String md) {
    return new FastWordDocument(md);
  }
}
