package com.imt.spring.infra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imt.spring.infra.controller.kafka.events.AnnulationCourseReponse;
import com.imt.spring.infra.controller.kafka.events.TravauxReponse;
import com.imt.spring.infra.model.Course;
import com.imt.spring.infra.model.Travaux;
import com.imt.spring.infra.repository.CourseRepository;
import com.imt.spring.infra.repository.TravauxRepository;

public class TravauxService {
	
	final int VITESSE_TRAIN = 200;
    final int TAILLE_SILLON_KM = 10;
    final int DUREE_SILLON = TAILLE_SILLON_KM * 3600 / VITESSE_TRAIN;
	
	@Autowired
    TravauxRepository travauxRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<TravauxReponse> obtenirTravauxReponse() {
		
		List<TravauxReponse> travauxReponses = travauxRepository.getTravauxReponse(DUREE_SILLON);
		
		return travauxReponses;
	}

	public List<AnnulationCourseReponse> obtenirAnnulationCourses() {
		
		List<AnnulationCourseReponse> annulationCourseReponses = courseRepository.getCourseAnnulees(DUREE_SILLON);
		
		annulationCourseReponses.forEach(annulationCourse -> {
			courseRepository.deleteById(annulationCourse.idCourse);
		});
		
		return annulationCourseReponses;
	}
}
