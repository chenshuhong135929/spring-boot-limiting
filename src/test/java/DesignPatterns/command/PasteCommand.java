package DesignPatterns.command;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-05 14:37
 */
public class PasteCommand implements  Command {

  private TextEditor textEditor;

  public PasteCommand(TextEditor textEditor) {
    this.textEditor = textEditor;
  }

  @Override
  public void execute() {
    textEditor.paste();
  }
}
