package com.imt.spring.infra.controller.kafka.events;

import java.util.HashMap;

import com.imt.spring.infra.repository.ITravauxReponse;

public class TravauxReponse implements ITravauxReponse{
	
    public String pointDepart;
    public String pointArrivee;
	public long tempsDebut;
	public long tempsFin;
	
	public TravauxReponse(String pointDepart, String pointArrivee, long tempsDebut, long tempsFin) {
	    this.pointDepart = pointDepart;
	    this.pointArrivee = pointArrivee;
	    this.tempsDebut = tempsDebut;
	    this.tempsFin = tempsFin;
	}
	
	
	public String getPointDepart() {
		return pointDepart;
	}
	public void setPointDepart(String pointDepart) {
		this.pointDepart = pointDepart;
	}
	public String getPointArrivee() {
		return pointArrivee;
	}
	public void setPointArrivee(String pointArrivee) {
		this.pointArrivee = pointArrivee;
	}
	public long getTempsDebut() {
		return tempsDebut;
	}
	public void setTempsDebut(long tempsDebut) {
		this.tempsDebut = tempsDebut;
	}
	public long getTempsFin() {
		return tempsFin;
	}
	public void setTempsFin(long tempsFin) {
		this.tempsFin = tempsFin;
	}
	
	
}
