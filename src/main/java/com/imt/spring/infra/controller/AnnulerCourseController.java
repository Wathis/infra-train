package com.imt.spring.infra.controller;

import com.imt.spring.infra.controller.kafka.KafkaController;

import com.imt.spring.infra.service.TravauxReponseService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnulerCourseController {

    @Autowired
    TravauxReponseService service;
    
    @Autowired
    KafkaController kafkaController;

    @RequestMapping(value = "/annuler_courses",method = RequestMethod.GET)
    public String travaux() {
        kafkaController.envoiAnnulationCourse();
        return "200 OK";
    }
}
