package DesignPatterns.decorator;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-04 10:57
 */
public class UnderlineDecorator extends   NodeDecorator {

  protected UnderlineDecorator(TextNode target) {
    super(target);
  }

  @Override
  public String getText() {
    return "<UnderLineDecorator>"+target.getText()+"</UnderLineDecorator>";
  }
}
