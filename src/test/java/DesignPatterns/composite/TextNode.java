package DesignPatterns.composite;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-31 14:43
 */
public class TextNode implements Node {
  private String text;

  public TextNode(String text) {
    this.text = text;
  }

  public Node add(Node node) {
    throw new UnsupportedOperationException();
  }

  public List<Node> children() {
    return Arrays.asList();
  }

  public String toXml() {
    return text;
  }
}
