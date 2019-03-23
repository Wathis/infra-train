package com.imt.spring.infra.repository;

import com.imt.spring.infra.controller.kafka.events.TravauxReponse;
import com.imt.spring.infra.model.Travaux;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravauxRepository extends CrudRepository<Travaux, Integer> {
    @Query(value = "SELECT * FROM infra.travaux", nativeQuery = true)
    List<Travaux> getTravaux();
    
    @Query(value = "select \r\n" + 
    		"	desserte1.nom as pointDepart,\r\n" + 
    		"    desserte2.nom as pointArrivee,\r\n" + 
    		"    travaux.date_debut- ?1 *(sillon.position-1) as tempsDebut,\r\n" + 
    		"    travaux.date_fin- ?1 *(sillon.position-1) as tempsFin\r\n" + 
    		"from\r\n" + 
    		"	desserte as desserte1\r\n" + 
    		"    inner join ligne on ligne.depart_id = desserte1.id\r\n" + 
    		"    inner join desserte as desserte2 on ligne.arrivee_id = desserte2.id\r\n" + 
    		"    inner join sillon on ligne.id = sillon.ligne_id\r\n" + 
    		"    inner join travaux_sillons on sillon.id = travaux_sillons.sillons_id\r\n" + 
    		"    inner join travaux on travaux.id = travaux_sillons.travaux_id", nativeQuery = true)
    List<TravauxReponse> getTravauxReponse(int dureeSillon);
}
