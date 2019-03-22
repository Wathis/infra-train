package com.imt.spring.infra.controller;

import com.imt.spring.infra.controller.kafka.events.ReservationAppel;
import com.imt.spring.infra.model.Sillon;
import com.imt.spring.infra.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/reservation",method = RequestMethod.POST)
    public List<Sillon> reservation(@RequestBody ReservationAppel reservationDTO) {
        List<Integer> sillonIds = service.obtenirSillons(reservationDTO.pointDepart,reservationDTO.pointArrivee);
        Iterator iterator = sillonIds.iterator();
        String error = "";
        while (iterator.hasNext()) {
            Integer sillonId = (Integer) iterator.next();
            if (!service.peutEtreReserve(reservationDTO.tempsDepart,sillonId)) {
                error = "Le sillon " + sillonId + " est déjà réservé";
                break;
            }
        }
        return null;
//        if (error.isEmpty()){
//
//        } else {
//
//        }
    }
}
