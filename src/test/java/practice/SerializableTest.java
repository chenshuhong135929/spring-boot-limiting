package practice;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @Auther ChenShuHong
 * @Date 2021-12-06 14:17
 *
 * 可序列化的Java对象必须实现java.io.Serializable接口，类似Serializable这样的空接口被称为“标记接口”（Marker Interface）；
 *
 * 反序列化时不调用构造方法，可设置serialVersionUID作为版本号（非必需）；
 *
 * Java的序列化机制仅适用于Java，如果需要与其它语言交换数据，必须使用通用的序列化方法，例如JSON。
 */
public class SerializableTest {
  @Test
  public void  test1(){
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
      // 写入int:
      output.writeInt(12345);
      // 写入String:
      output.writeUTF("Hello");
      // 写入Object:
      output.writeObject(Double.valueOf(123.456));
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(Arrays.toString(buffer.toByteArray()));


    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.toByteArray());
    try (ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream)){
      int i = inputStream.readInt();
      String s = inputStream.readUTF();
      Double o = (Double)inputStream.readObject();
      System.out.println(i+"   "+s+"   "+o.intValue());

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void test2() throws IOException {
    //将对象序列号
    try ( ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\p.class",false))){
      objectOutputStream.writeObject(new People("niha",1));
    }catch  (IOException e) {
      e.printStackTrace();
    }

    //将对象反序列号
    try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\p.class"))) {
      People d = (People) objectInputStream.readObject();
      System.out.println(d.getAge());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }




}
