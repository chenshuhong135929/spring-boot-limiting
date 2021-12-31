package DesignPatterns.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-31 14:30
 */
public class ElementNode implements Node {
  private String name;
  private List<Node> list = new ArrayList<>();

  public ElementNode(String name) {
    this.name = name;
  }

  public Node add(Node node) {
    list.add(node);
    return this;
  }

  public List<Node> children() {
    return list;
  }

  public String toXml() {
    String start = "<" + name + ">\n";
    String end = "</" + name + ">\n";
    StringJoiner sj = new StringJoiner("", start, end);
    list.forEach(node -> {
      sj.add(node.toXml() + "\n");
    });
    return sj.toString();
  }
}
