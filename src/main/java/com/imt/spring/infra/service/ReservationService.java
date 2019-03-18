package com.imt.spring.infra.service;

import com.imt.spring.infra.dto.ReservationDTO;
import com.imt.spring.infra.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public boolean reservation(ReservationDTO reservation) {
        return reservationRepository.reservationDisponible(reservation.deparatureTime,1200,1) > 0;
    }

}
