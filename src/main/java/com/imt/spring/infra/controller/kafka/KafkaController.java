package com.imt.spring.infra.controller.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.imt.spring.infra.controller.kafka.events.AnnulationCourseReponse;
import com.imt.spring.infra.controller.kafka.events.ReservationAppel;
import com.imt.spring.infra.controller.kafka.events.ReservationReponse;
import com.imt.spring.infra.controller.kafka.events.TravauxReponse;
import com.imt.spring.infra.model.Course;
import com.imt.spring.infra.model.Reservation;
import com.imt.spring.infra.service.ReservationService;
import com.imt.spring.infra.service.TravauxReponseService;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> template;

    @Autowired
    ReservationService reservationService;
    
    @Autowired
    TravauxReponseService travauxService;

    private Gson gson = new Gson();

    @KafkaListener(topics = "creer_reservation")
    public void listen(ConsumerRecord<?,?> cr) throws Exception {
        System.out.println(cr.value());

        ReservationAppel reservationAppel = gson.fromJson(cr.value().toString(), ReservationAppel.class);

        Course course = reservationService.reservation(reservationAppel);

        ReservationReponse reservationReponse = new ReservationReponse();
        reservationReponse.idReservationInterneTransporteur = reservationAppel.idReservationInterneTransporteur;
        reservationReponse.pointDepart = reservationAppel.pointDepart;
        reservationReponse.pointArrivee = reservationAppel.pointArrivee;
        reservationReponse.tempsDepart = reservationAppel.tempsDepart;
        if (course != null) {
            reservationReponse.idCourse = course.id;
            reservationReponse.erreur = false;
            reservationReponse.message = "Succès de la réservation";
        } else {
            reservationReponse.erreur = true;
            reservationReponse.message = "Le trajet est déjà réservé";
        }
        this.template.send("reponse_reservation", gson.toJson(reservationReponse));
    }
    
    public void envoiListeTravaux() {
    	
    	List<TravauxReponse> listeTravaux = travauxService.obtenirTravauxReponse();
    	
    	System.out.println(gson.toJson(listeTravaux));
    	
    	this.template.send("reponse_travaux", gson.toJson(listeTravaux));
    }
    
    public void envoiAnnulationCourse() {
    	
    	List<AnnulationCourseReponse> annulationCourseReponses = travauxService.obtenirAnnulationCourses();
    	
    	annulationCourseReponses.forEach(annulation ->{
    		
    		System.out.println(gson.toJson(annulation));
    		
    		this.template.send("reponse_annulation_course", gson.toJson(annulation));
    	});
    	
    }
}
