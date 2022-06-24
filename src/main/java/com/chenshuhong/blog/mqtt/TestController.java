package com.chenshuhong.blog.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private MqttSender mqttSender;

    @RequestMapping("/send")
    private void send(String data){
        mqttSender.sendToMqtt(data);
    }
}
