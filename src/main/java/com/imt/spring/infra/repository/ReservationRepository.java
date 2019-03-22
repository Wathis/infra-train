package com.imt.spring.infra.repository;

import com.imt.spring.infra.model.Reservation;
import com.imt.spring.infra.model.Sillon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
    @Query(value = "select count(*) = 0 as sillon_disponible from reservation res join sillon sil on res.sillon_id = sil.id where res.timestamp < ?1 + ?2 and res.timestamp > ?1 - ?2 and sil.id = ?3", nativeQuery = true)
    int reservationDisponible(long timestamp, int dureeTraverseeSillon, int sillonId);
}
