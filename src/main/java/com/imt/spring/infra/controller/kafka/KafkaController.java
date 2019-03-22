package com.imt.spring.infra.controller.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.imt.spring.infra.controller.kafka.events.ReservationAppel;
import com.imt.spring.infra.model.Reservation;
import com.imt.spring.infra.service.ReservationService;
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

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> template;

    @Autowired
    ReservationService reservationService;

    private Gson gson = new Gson();

    @RequestMapping("/test_kafka")
    public String testKafka() throws IOException, ParseException {
        System.out.println("Test Kafka");
        Reservation reservation = new Reservation();
        reservation.id = 1;
        reservation.timestamp = (int) System.currentTimeMillis() / 1000;
        String objJSON = gson.toJson(reservation);
        this.template.send("reservations", objJSON);
        return objJSON;
    }

    @KafkaListener(topics = "reservations")
    public void listen(ConsumerRecord<?,?> cr) throws Exception {
        System.out.println(cr.value());
        ReservationAppel reservationAppel = gson.fromJson(cr.value().toString(), ReservationAppel.class);
    }
}
