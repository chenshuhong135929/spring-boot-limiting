package base;

import com.chenshuhong.blog.BlogApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


/**
 * @Author: 陈树洪
 * @Date: 2022/06/01/11:45
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class TestResource {

    @Value("classpath:/logback-spring.xml")
    Resource resource;
    String logo;
    @Test
    public void test() throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            logo = reader.lines().collect(Collectors.joining("\n"));
        }
        System.out.println(logo);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for(int x=0 ; x<1000;x++){

                start();
            }

        });
        thread.start();
        Thread thread1 = new Thread(()->{
            for(int x=0 ; x<1000;x++){
                start();
            }

        });
        thread1.start();


        Thread thread2 = new Thread(()->{
            for(int x=0 ; x<1000;x++){

                start();
            }

        });
        thread2.start();

        Thread thread3 = new Thread(()->{
            for(int x=0 ; x<1000;x++){
                start();
            }

        });
        thread3.start();
    }

    //curl调用测试
    private static void start() {
        String[] cmds = {"curl", "-X", "POST",
                "http://www.olalabuy.com/user/mobileVerification",
                "-H","Cookie: Hm_lvt_09c0b3bb559c450cb6722f2314296283=1654163705,1654493984,1654504604; JSESSIONID=21458AF69BE5A84696853BCD8C56599C; Hm_lpvt_09c0b3bb559c450cb6722f2314296283=1654828404",
                "-H","Referer: http://www.olalabuy.com/UrlController/forgetPwd",
                "-H", "Content-Type: application/x-www-form-urlencoded;charset=UTF-8",
                "--data-raw"
                , "userPhone=13605781169&codeUrl=userLogin"};
        System.out.println(execCurl(cmds));
    }

    public static String execCurl(String[] cmds) {

        Thread t = Thread.currentThread();
        System.out.println("当前线程名字：" + t.getName() + " 当前线程的优先级别为：" + t.getPriority() + " ID:" + t.getId());
        //           System.out.println("当前线程名字：" + this.getName() + " 当前线程的优先级别为：" + this.getPriority() + " ID:"+ this.getId());
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;
    }


}
