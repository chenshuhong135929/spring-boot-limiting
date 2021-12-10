package DesignPatterns.methodfactory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-10 17:10
 */
public class FastWordDocument implements  WordDocument {
  private String md;
  public FastWordDocument(String md) {
    this.md=md;
  }

  @Override
  public void save(Path path) throws IOException {
    System.out.println(path+"   "+md);
  }
}
