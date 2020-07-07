package com.zeusedulous;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @Author : Zeusedulous
 * @Date : 2020/6/28 13:47
 * @Desc :
 */
public class Consumer {
    private static String topic = "test_topic4";

    public static void main(String[] args) {
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.81.72:9092");
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG,"test-consumer-group");
        p.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        p.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"600000");
        //关闭自动提交，否则会出现重复消费
        p.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"false");
        KafkaConsumer consumer = new KafkaConsumer(p);

        consumer.subscribe(Arrays.asList(topic));

        while (true){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String,String> record:records) {
                System.out.println("record = " + record);
            }
            consumer.commitSync();

        }
    }


}
