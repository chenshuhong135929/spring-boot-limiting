package DesignPatterns.command;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-05 14:40
 */
public class Test {


  public static void main(String[] args) {

    /**
     * 命令行模式
     */

    TextEditor textEditor = new TextEditor();
    Command copyCommand = new CopyCommand(textEditor);
    copyCommand.execute();
    Command deleteCommand = new DeleteCommand(textEditor);
    deleteCommand.execute();
    Command pasteCommand = new PasteCommand(textEditor);
    pasteCommand.execute();
  }


}
