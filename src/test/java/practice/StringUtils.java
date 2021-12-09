package practice;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-09 10:31
 */
public class StringUtils {
  public static String capitalize(String s) {
    if (s.length() == 0) {
      return s;
    }
    return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
  }
}
