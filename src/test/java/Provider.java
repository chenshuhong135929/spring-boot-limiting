import com.chenshuhong.blog.BlogApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: 陈树洪
 * @Date: 2022/06/24/10:31
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class Provider {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Hello模型的生产者
     */
    @Test
    public void TestProviderHello() {
        //    发送消息 参数：             队列名称   发送内容
        rabbitTemplate.convertAndSend("qq", "Hello模型发送信息");
        System.out.println("发送成功");
    }
}