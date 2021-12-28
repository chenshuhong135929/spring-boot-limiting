package DesignPatterns.builder;

import java.util.Arrays;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-28 14:50
 */
public class HtmlBuilder {
  private HeadingBuilder headingBuilder = new HeadingBuilder();
  private HrBuilder hrBuilder = new HrBuilder();
 // private ParagraphBuilder paragraphBuilder = new ParagraphBuilder();
  private QuoteBuilder quoteBuilder = new QuoteBuilder();

  public String toHtml(String markdown) {
    StringBuilder buffer = new StringBuilder();
    Arrays.stream(markdown.split("/n")).forEach(line -> {
      if (line.startsWith("#")) {
        buffer.append(headingBuilder.buildHeading(line)).append('\n');
      } else if (line.startsWith(">")) {
        buffer.append(quoteBuilder.buildQuote(line)).append('\n');
      } else if (line.startsWith("---")) {
        buffer.append(hrBuilder.buildHr(line)).append('\n');
      } else {
      //  buffer.append(paragraphBuilder.buildParagraph(line)).append('\n');
      }
    });
    return buffer.toString();
  }


  public static void main(String[] args) {
    HtmlBuilder htmlBuilder = new HtmlBuilder();
    System.out.println(htmlBuilder.toHtml("#HtmlBuilder"));
    System.out.println(htmlBuilder.toHtml(">HtmlBuilder"));
    System.out.println(htmlBuilder.toHtml("-HtmlBuilder"));
  }
}
