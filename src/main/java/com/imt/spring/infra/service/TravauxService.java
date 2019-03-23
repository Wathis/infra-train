package com.imt.spring.infra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imt.spring.infra.controller.kafka.events.TravauxReponse;
import com.imt.spring.infra.model.Course;
import com.imt.spring.infra.model.Travaux;
import com.imt.spring.infra.repository.CourseRepository;
import com.imt.spring.infra.repository.TravauxRepository;

public class TravauxService {
	
	@Autowired
    TravauxRepository travauxRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<TravauxReponse> obtenirTravauxReponse() {
		
		List<Course> courses = courseRepository.getCourses();
		
		List<TravauxReponse> travauxReponses = new ArrayList<TravauxReponse>();
		
		
		return travauxReponses;
	}
}
