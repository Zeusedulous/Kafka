package com.zeusedulous.springboot.kafka.producer;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.zeusedulous.springboot.kafka.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.SendResult;
import java.util.concurrent.ExecutionException;

/**
 * @Author : Zeusedulous
 * @Date : 2020/7/8 14:24
 * @Desc :
 */
@RestController
public class Producer {

    private String topic = "springboot-kafka";
    private int count = 30;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping("/send")
    public String producerMsg() throws ExecutionException, InterruptedException {
        for (int i=1;i<=count;i++){
            User user = new User();
            user.setId(i);
            user.setName("userName_" + i);
            String msg = JSON.toJSONString(user);
            ListenableFuture<SendResult> result = kafkaTemplate.send(topic,msg);
            System.out.println("发送消息 = " + result.get());
            result.addCallback(
                success-> System.out.println("成功：" + success.toString()),
                fail-> System.out.println("失败：" + fail.getMessage())
            );
        }
        return "发送成功";
    }
}
