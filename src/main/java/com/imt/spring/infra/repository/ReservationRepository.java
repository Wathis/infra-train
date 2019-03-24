package com.imt.spring.infra.repository;

import com.imt.spring.infra.model.Reservation;
import com.imt.spring.infra.model.Sillon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
    @Query(value = "select \r\n" + 
    		"	count(*) = 0 as sillon_disponible \r\n" + 
    		"from\r\n" + 
    		"	reservation res \r\n" + 
    		"    join sillon sil on res.sillon_id = sil.id \r\n" + 
    		"    join travaux_sillons on travaux_sillons.sillons_id = sil.id\r\n" + 
    		"    join travaux on travaux.id = travaux_sillons.travaux_id\r\n" + 
    		"where \r\n" + 
    		"	(res.timestamp < ?1 + ?2 *2 and res.timestamp > ?1 - ?2 *2 and sil.id = ?3)\r\n" + 
    		"    or (travaux.date_debut < ?1 + ?2 *2 and travaux.date_fin > ?1 - ?2 *2 and sil.id = ?3)", nativeQuery = true)
    int reservationDisponible(long timestamp, int dureeTraverseeSillon, int sillonId);
}
