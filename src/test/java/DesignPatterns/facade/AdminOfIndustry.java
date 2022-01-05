package DesignPatterns.facade;

/**
 * @Auther ChenShuHong
 * @Date 2022-01-04 14:30
 * // 工商注册:
 */
public class AdminOfIndustry {
  public Company register(String name) {
        return  new Company(name);
  }
}
