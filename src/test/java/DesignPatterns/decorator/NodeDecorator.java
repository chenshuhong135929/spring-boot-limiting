package DesignPatterns.decorator;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-04 10:44
 */
public abstract class NodeDecorator implements TextNode {
  protected final TextNode target;

  protected NodeDecorator(TextNode target) {
    this.target = target;
  }

  public void setText(String text) {
    this.target.setText(text);
  }
}
