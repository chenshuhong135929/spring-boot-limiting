package DesignPatterns.decorator;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-04 10:43
 */
public class SpanNode implements TextNode {
  private String text;

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return "<span>" + text + "</span>";
  }

}
