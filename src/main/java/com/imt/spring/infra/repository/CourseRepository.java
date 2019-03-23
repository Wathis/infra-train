package com.imt.spring.infra.repository;

import com.imt.spring.infra.controller.kafka.events.AnnulationCourseReponse;
import com.imt.spring.infra.model.Course;
import com.imt.spring.infra.model.Sillon;
import com.imt.spring.infra.model.Travaux;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	@Query(value = "SELECT * FROM infra.course", nativeQuery = true)
    List<Course> getCourses();
	
	@Query(value = "select \r\n" + 
			"	course.id as idCourse,\r\n" + 
			"    course.id_reservation_transporteur as idReservationInterneTransporteur,\r\n" + 
			"    travaux.date_debut- ?1 *(sillon.position-1) as tempsDebut,\r\n" + 
			"    travaux.date_fin- ?1 *(sillon.position-1) as tempsFin\r\n" + 
			"from\r\n" + 
			"	ligne\r\n" + 
			"    inner join sillon on ligne.id = sillon.ligne_id\r\n" + 
			"    inner join travaux_sillons on sillon.id = travaux_sillons.sillons_id\r\n" + 
			"    inner join travaux on travaux.id = travaux_sillons.travaux_id\r\n" + 
			"    inner join reservation on reservation.sillon_id = sillon.id\r\n" + 
			"    inner join course on course.id = reservation.course_id\r\n" + 
			"where\r\n" + 
			"	reservation.timestamp > travaux.date_debut- ?1 *2\r\n" + 
			"    and reservation.timestamp < travaux.date_fin+ ?1 *2", nativeQuery = true)
	List<AnnulationCourseReponse> getCourseAnnulees(int dureeSillon);
}
