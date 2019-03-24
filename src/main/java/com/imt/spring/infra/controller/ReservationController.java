package com.imt.spring.infra.controller;

import com.google.gson.Gson;
import com.imt.spring.infra.controller.kafka.events.ReservationAppel;
import com.imt.spring.infra.model.Course;
import com.imt.spring.infra.model.Sillon;
import com.imt.spring.infra.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    ReservationService service;

    @Autowired
    private KafkaTemplate<String, String> template;

    Gson gson = new Gson();

    @RequestMapping(value = "/reservation",method = RequestMethod.POST)
    public String reservation(@RequestBody ReservationAppel reservationDTO) {
        String objJSON = gson.toJson(reservationDTO);
        this.template.send("creer_reservation", objJSON);
        return "200 OK";
    }
    
    @RequestMapping(value = "/annuler_reservation",method = RequestMethod.POST)
    public String annulerReservation(@RequestBody ReservationAppel reservationDTO) {
        String objJSON = gson.toJson(reservationDTO);
        this.template.send("annuler_reservation", objJSON);
        return "200 OK";
    }
}
