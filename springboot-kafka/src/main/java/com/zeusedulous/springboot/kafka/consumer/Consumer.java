package com.zeusedulous.springboot.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author : Zeusedulous
 * @Date : 2020/7/8 14:24
 * @Desc :
 */
@Component
public class Consumer {

    @KafkaListener(topics = "springboot-kafka")
    public void getMsg(String msg) throws InterruptedException {
        System.out.println("获取消息：" + msg);
    }
}
