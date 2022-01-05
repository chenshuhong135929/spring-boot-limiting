package DesignPatterns.command;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-05 14:35
 */
public class TextEditor {
  private StringBuilder buffer = new StringBuilder();

  public void copy() {

  }

  public void paste() {

    add("dd");
  }

  public void add(String s) {
    buffer.append(s);
  }

  public void delete() {
    if (buffer.length() > 0) {
      buffer.deleteCharAt(buffer.length() - 1);
    }
  }

  public String getState() {
    return buffer.toString();
  }

}
