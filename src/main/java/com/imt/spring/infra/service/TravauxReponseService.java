package com.imt.spring.infra.service;

import java.util.List;

import javax.transaction.Transactional;

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
		
		System.out.println(gson.toJson((TravauxReponse)(travauxRepository.getTravauxReponse(DUREE_SILLON).get(0))));
		
		List<TravauxReponse> travauxReponses = null;
		
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
