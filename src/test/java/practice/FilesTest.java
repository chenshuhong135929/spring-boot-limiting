package practice;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-06 16:39
 * 对于简单的小文件读写操作，可以使用Files工具类简化代码。
 */
public class FilesTest {

  @Test
  public void test1() throws IOException {

    //将文件用行的现实输出
    List<String> list = Files.readAllLines(Paths.get("E:\\dome\\spring-boot-limiting\\src\\main\\resources\\logback-spring.xml"));
    list.stream().forEach(x-> System.out.println(x));


    //将文件转换为byte数组，（适用于小文件）
    byte[] bytes = Files.readAllBytes(Paths.get("E:\\dome\\spring-boot-limiting\\src\\main\\resources\\logback-spring.xml"));

    //将文件直接拷贝到那个outputStream进行操作
    Files.copy(Paths.get("E:\\dome\\spring-boot-limiting\\src\\main\\resources\\logback-spring.xml"),new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\logback-spring.xml")) );


  }


}
