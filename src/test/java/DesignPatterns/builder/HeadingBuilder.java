package DesignPatterns.builder;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-28 14:51
 */
public class HeadingBuilder {
  public String buildHeading(String line) {
    int n = 0;
    while (line.charAt(0) == '#') {
      n++;
      line = line.substring(1);
    }
    return String.format("<h%d>%s</h%d>", n, line, n);
  }
}
