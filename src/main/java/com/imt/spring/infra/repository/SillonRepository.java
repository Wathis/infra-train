package com.imt.spring.infra.repository;

import com.imt.spring.infra.model.Reservation;
import com.imt.spring.infra.model.Sillon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SillonRepository extends CrudRepository<Sillon, Integer> {

    @Query(value = "select sil.id from sillon sil\n" +
            "join ligne lig on lig.id = sil.ligne_id\n" +
            "where depart_id = (select id from desserte where nom = ?1)\n" +
            "and arrivee_id = (select id from desserte where nom = ?2)\n" +
            "order by position;", nativeQuery = true)
    List<Integer> getSillons(String pointDepart, String pointArrivee);
}
