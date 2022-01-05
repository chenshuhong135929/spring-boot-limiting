package DesignPatterns.decorator;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-04 10:45
 */
public class BoldDecorator extends NodeDecorator {
  public BoldDecorator(TextNode target) {
    super(target);
  }

  public String getText() {
    return "<b>" + target.getText() + "</b>";
  }
}
