package DesignPatterns.command;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-05 14:39
 */
public class DeleteCommand implements  Command {

  private  TextEditor  textEditor;

  public DeleteCommand(TextEditor textEditor) {
    this.textEditor = textEditor;
  }

  @Override
  public void execute() {

    textEditor.delete();
  }
}
