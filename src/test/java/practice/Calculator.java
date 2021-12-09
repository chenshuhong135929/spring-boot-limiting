package practice;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-08 15:17
 */
public class Calculator {
  private long n = 0;

  public long add(long x) {
    n = n + x;
    return n;
  }

  public long sub(long x) {
    n = n - x;
    return n;
  }
}
