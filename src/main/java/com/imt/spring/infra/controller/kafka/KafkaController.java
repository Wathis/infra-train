package com.imt.spring.infra.controller.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RestController
public class KafkaController {

    public static Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaTemplate<String, String> template;

    private final CountDownLatch latch = new CountDownLatch(3);

    @RequestMapping("/test_kafka/{message}")
    public String testKafka(@PathVariable("message") String message) {
        System.out.println("Test Kafka");
        this.template.send("test", message);
        return "Done.";
    }

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?,?> cr) throws Exception {
        logger.info(cr.toString());
        System.out.println(cr.value());
    }
}
