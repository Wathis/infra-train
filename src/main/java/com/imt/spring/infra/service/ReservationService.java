package com.imt.spring.infra.service;

import com.imt.spring.infra.controller.kafka.events.ReservationAppel;
import com.imt.spring.infra.model.Course;
import com.imt.spring.infra.model.Reservation;
import com.imt.spring.infra.model.Sillon;
import com.imt.spring.infra.repository.CourseRepository;
import com.imt.spring.infra.repository.ReservationRepository;
import com.imt.spring.infra.repository.SillonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    SillonRepository sillonRepository;

    @Autowired
    CourseRepository courseRepository;

    final int VITESSE_TRAIN = 200;
    final int TAILLE_SILLON_KM = 10;
    final int DUREE_SILLON = TAILLE_SILLON_KM * 3600 / VITESSE_TRAIN;

    public boolean peutEtreReserve(long dateDepart,int sillonId) {
        return reservationRepository.reservationDisponible(dateDepart,DUREE_SILLON,sillonId) > 0;
    }

    public List<Integer> obtenirSillons(String pointDepart, String pointArrivee) {
        return sillonRepository.getSillons(pointDepart,pointArrivee);
    }

    public Course reserverSillons(List<Integer> sillonIds, long dateDebut,ReservationAppel reservationAppel) {
        Course course = new Course();
        course.id_reservation_transporteur = reservationAppel.idReservationInterneTransporteur;
        LinkedList<Reservation> reservations = new LinkedList<>();
        Iterator iterator = sillonIds.iterator();
        long decalageTemps = 0;
        while (iterator.hasNext()) {
            Reservation reservation = new Reservation();
            Integer sillonId = (Integer) iterator.next();
            reservation.sillon = sillonRepository.findById(sillonId).get();
            reservation.timestamp = dateDebut + decalageTemps;
            reservation.course = course;
            reservations.add(reservation);
            decalageTemps += DUREE_SILLON;
        }
        course.reservation = reservations;
        courseRepository.save(course);
        return course;
    }

    public Course reservation(ReservationAppel reservationAppel)  {
        List<Integer> sillonIds = obtenirSillons(reservationAppel.pointDepart,reservationAppel.pointArrivee);
        Iterator iterator = sillonIds.iterator();
        String errorMessage = "";
        int decalageTemps = 0;
        while (iterator.hasNext()) {
            Integer sillonId = (Integer) iterator.next();
            if (!peutEtreReserve(reservationAppel.tempsDepart + decalageTemps,sillonId)) {
                errorMessage = "Le sillon " + sillonId + " est déjà réservé";
                break;
            }
            decalageTemps += DUREE_SILLON;
        }
        if (!errorMessage.isEmpty()){
            System.out.println(errorMessage);
            return null;
        }
        return reserverSillons(sillonIds,reservationAppel.tempsDepart,reservationAppel);
    }
    
    public Course annulerReservation(ReservationAppel reservationAppel) {
    	Iterable<Course> courses = courseRepository.findAll();
    	
    	Course courseRetournee = null;
    	
    	for(Course course : courses) {
    		if(course.id_reservation_transporteur.equals(reservationAppel.idReservationInterneTransporteur)) {
    			courseRetournee = course;
    			courseRepository.delete(course);
    		}
    	}
    	
    	return courseRetournee;
    }

}
