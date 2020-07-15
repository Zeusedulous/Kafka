package com.zeusedulous.springboot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Zeusedulous
 * @Date : 2020/7/7 17:28
 * @Desc :
 */
@SpringBootApplication
@RestController
public class KafkaSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaSpringBootApplication.class,args);
    }


    @RequestMapping("/test")
    public String test(){
        return "test";
    }


}
