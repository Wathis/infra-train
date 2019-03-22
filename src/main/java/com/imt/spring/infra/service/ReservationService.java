package com.imt.spring.infra.service;

import com.imt.spring.infra.model.Sillon;
import com.imt.spring.infra.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    final int DUREE_SILLON = 1200;

    public boolean peutEtreReserve(long dateDepart,int sillonId) {
        return reservationRepository.reservationDisponible(dateDepart,DUREE_SILLON,sillonId) > 0;
    }

    public List<Integer> obtenirSillons(String pointDepart, String pointArrivee) {
        return reservationRepository.getSillons(pointDepart,pointArrivee);
    }

}
