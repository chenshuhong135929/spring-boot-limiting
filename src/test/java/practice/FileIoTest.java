package practice;


import com.google.common.base.Charsets;
import org.junit.Test;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-02 14:27
 *
 * IO流是一种流式的数据输入/输出模型：
 *
 *     二进制数据以byte为最小单位在InputStream/OutputStream中单向流动；
 *
 *     字符数据以char为最小单位在Reader/Writer中单向流动。
 *
 * Java标准库的java.io包提供了同步IO功能：
 *
 *     字节流接口：InputStream/OutputStream；
 *
 *     字符流接口：Reader/Writer。
 *
 * java标准库的java.io.File对象表示一个文件或者目录：
 *
 *     创建File对象本身不涉及IO操作；
 *     可以获取路径／绝对路径／规范路径：getPath()/getAbsolutePath()/getCanonicalPath()；
 *     可以获取目录的文件和子目录：list()/listFiles()；
 *     可以创建或删除文件和目录。
 *
 * Java标准库的java.io.OutputStream定义了所有输出流的超类：
 *
 *     FileOutputStream实现了文件流输出；
 *
 *     ByteArrayOutputStream在内存中模拟一个字节流输出。
 *
 *    某些情况下需要手动调用OutputStream的flush()方法来强制输出缓冲区。
 *
 *    总是使用try(resource)来保证OutputStream正确关闭。
 *
 * Java的IO标准库使用Filter模式为InputStream和OutputStream增加功能：
 *
 *     可以把一个InputStream和任意个FilterInputStream组合；
 *
 *     可以把一个OutputStream和任意个FilterOutputStream组合。
 *
 *     Filter模式可以在运行期动态增加功能（又称Decorator模式）。
 */
public class FileIoTest {


  @Test
  public void test1() throws Exception {

    FileInputStream  fileInputStream = new FileInputStream(new File("E:\\谷歌插件\\ShadowsocksR-win-4.9.23\\ShadowsocksR-win-4.9.2\\chn_ip.txt"));
    FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\chn_ip.txt"));


    byte [] buff = new byte[1024];
    while (fileInputStream.read(buff)!=-1){
           fileOutputStream.write(buff);
    }

    fileInputStream.close();
    fileOutputStream.close();

  }


  @Test
  public void test2() throws IOException {
    compreSsion("C:\\Users\\Administrator\\Desktop\\新建文件夹.zip",new File("C:\\Users\\Administrator\\Desktop\\新建文件夹"));//第一个参数是压缩的名字,第二个参数是要压缩的目录

    dounzip("C:\\Users\\Administrator\\Desktop\\新建文件夹.zip",new File("E:"+  File.separator+"谷歌插件"+File.separator));

  }

  /**
   *
   * @param zipFileName  压缩后的文件地址名字
   * @param target       要压缩的文件地址
   * @throws IOException
   */
  private static void compreSsion(String zipFileName, File target) throws IOException {//压缩
    System.out.println("压缩文件...");
    ZipOutputStream out=new ZipOutputStream(new FileOutputStream(zipFileName), Charsets.UTF_8);
    BufferedOutputStream bos=new BufferedOutputStream(out);
    zip(out,target,target.getName(),bos);
    bos.close();
    out.close();
    System.out.println("压缩完成");
  }

  private static void zip(ZipOutputStream zout, File target, String name, BufferedOutputStream bos) throws IOException {
    //判断是不是目录
    if (target.isDirectory()){
      File[] files=target.listFiles();

      if (files.length==0){//空目录
        zout.putNextEntry(new ZipEntry(name+"/"));
            /*  开始编写新的ZIP文件条目，并将流定位到条目数据的开头。
              关闭当前条目，如果仍然有效。 如果没有为条目指定压缩方法，
              将使用默认压缩方法，如果条目没有设置修改时间，将使用当前时间。*/
      }
      for (File f:files){
        //递归处理
        zip(zout,f,name+"/"+f.getName(),bos);
      }
    }else {
      zout.putNextEntry(new ZipEntry(name));
      InputStream inputStream=new FileInputStream(target);
      BufferedInputStream bis=new BufferedInputStream(inputStream);
      byte[] bytes=new byte[1024];
      int len=-1;
      while ((len=bis.read(bytes))!=-1){
        bos.write(bytes,0,len);
      }
      bis.close();

    }

  }

  /**
   *
   * @param zipName 解压的文件地址
   * @param target  解压后的地址
   */
  public void dounzip(String zipName, File target) {

    try (FileInputStream fis = new FileInputStream(zipName);
         ZipInputStream zis =
             new ZipInputStream(new BufferedInputStream(fis))) {
      ZipEntry entry;


      while ((entry = zis.getNextEntry()) != null) {
         String filePath = entry.getName();
        String dirPath = filePath.substring(0, filePath.lastIndexOf("/"));
        File fileDir = new File(target.getPath()+File.separator+dirPath);
        if (!fileDir.exists()) {
          fileDir.mkdirs();
        }

        int size;
        byte[] buffer = new byte[2048];
        try (FileOutputStream fos =
                 new FileOutputStream( new String(target.getPath()+File.separator+entry.getName()));
             BufferedOutputStream bos =
                 new BufferedOutputStream(fos, buffer.length)) {

          while ((size = zis.read(buffer, 0, buffer.length)) != -1) {
            bos.write(buffer, 0, size);
          }
          bos.flush();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
