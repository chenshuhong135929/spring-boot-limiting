package DesignPatterns.command;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-05 14:36
 */
public class CopyCommand implements Command {

  private TextEditor textEditor;



  public CopyCommand(TextEditor textEditor) {
    this.textEditor=textEditor;
  }

  @Override
  public void execute() {
    textEditor.copy();
  }
}
