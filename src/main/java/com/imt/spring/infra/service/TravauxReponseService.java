package com.imt.spring.infra.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.imt.spring.infra.repository.ITravauxReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.imt.spring.infra.controller.kafka.events.AnnulationCourseReponse;
import com.imt.spring.infra.controller.kafka.events.TravauxReponse;
import com.imt.spring.infra.repository.CourseRepository;
import com.imt.spring.infra.repository.TravauxRepository;

@Service
@Transactional
public class TravauxReponseService {
	
	final int VITESSE_TRAIN = 200;
    final int TAILLE_SILLON_KM = 10;
    final int DUREE_SILLON = TAILLE_SILLON_KM * 3600 / VITESSE_TRAIN;
	
	@Autowired
    TravauxRepository travauxRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	Gson gson = new Gson();
	
	public List<TravauxReponse> obtenirTravauxReponse() {
		List<ITravauxReponse> sqlTravauxResponse = travauxRepository.getTravauxReponse(DUREE_SILLON);
		List<TravauxReponse> travauxReponses = sqlTravauxResponse.stream()
				.map(travaux -> new TravauxReponse(
						travaux.getPointArrivee(),
						travaux.getPointArrivee(),
						travaux.getTempsDebut(),
						travaux.getTempsFin()
				))
				.collect(Collectors.toList());
		return travauxReponses;
	}

	public List<AnnulationCourseReponse> obtenirAnnulationCourses() {
		
		List<AnnulationCourseReponse> annulationCourseReponses = courseRepository.getCourseAnnulees(DUREE_SILLON).stream().map(
				annulationCourse -> new AnnulationCourseReponse(
						annulationCourse.getIdCourse(),
						annulationCourse.getIdReservationInterneTransporteur(),
						annulationCourse.getTempsDebut(),
						annulationCourse.getTempsFin()
						)
				).collect(Collectors.toList());
		
		annulationCourseReponses.forEach(annulationCourse -> {
			courseRepository.deleteById(annulationCourse.idCourse);
		});
		
		return annulationCourseReponses;
	}
}
