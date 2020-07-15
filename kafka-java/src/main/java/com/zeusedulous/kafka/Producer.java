package com.zeusedulous.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @Author : Zeusedulous
 * @Date : 2020/6/28 10:08
 * @Desc :
 */
public class Producer {

    private static String topic = "test_topic4";

    public static void main(String[] args){
        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.85.112:9092");
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);

        KafkaProducer<String, String> producer = new KafkaProducer<>(p);
        int i = 0;
        for (;;){
            i++;
            String msg = "msg" + i;
            System.out.println("msg = " + msg);
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, msg);
            producer.send(producerRecord);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
