package com.imt.spring.infra.controller;

import com.imt.spring.infra.dto.ReservationDTO;
import com.imt.spring.infra.model.Reservation;
import com.imt.spring.infra.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @Autowired
    ReservationService service;

    @RequestMapping(value = "/reservation",method = RequestMethod.POST)
    public boolean reservation(@RequestBody ReservationDTO reservationDTO) {
        return service.reservation(reservationDTO);
    }
}
