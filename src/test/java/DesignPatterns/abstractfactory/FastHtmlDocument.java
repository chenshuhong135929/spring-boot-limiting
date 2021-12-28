package DesignPatterns.abstractfactory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-10 17:10
 */
public class FastHtmlDocument implements  HtmlDocument {
  private String md;
  public FastHtmlDocument(String md) {
    this.md=md;
  }

  @Override
  public String toHtml() {
    return md+".html";
  }

  @Override
  public void save(Path path) throws IOException {
    System.out.println(path+"   "+md);
  }
}
