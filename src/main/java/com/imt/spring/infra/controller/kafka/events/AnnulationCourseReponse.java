package com.imt.spring.infra.controller.kafka.events;

import com.imt.spring.infra.repository.IAnnulationCourseReponse;

public class AnnulationCourseReponse implements IAnnulationCourseReponse{
	public int idCourse;
	public String idReservationInterneTransporteur;
	public long tempsDebut;
	public long tempsFin;
	
	public AnnulationCourseReponse(int idCourse, String idReservationInterneTransporteur, long tempsDebut, long tempsFin) {
		this.idCourse = idCourse;
		this.idReservationInterneTransporteur = idReservationInterneTransporteur;
		this.tempsDebut = tempsDebut;
		this.tempsFin = tempsFin;
	}
	
	public int getIdCourse() {
		return idCourse;
	}
	public String getIdReservationInterneTransporteur() {
		return idReservationInterneTransporteur;
	}
	public long getTempsDebut() {
		return tempsDebut;
	}
	public long getTempsFin() {
		return tempsFin;
	}
	
	
}
