package com.angel.kafkaproducer;

import com.angel.kafkaconsumer.consumer.KafkaConsumerConfigImpl;
import com.angel.kafkaproducer.producer.KafkaProducerConfigImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);


        KafkaProducerConfigImpl b = new KafkaProducerConfigImpl();


    }

}