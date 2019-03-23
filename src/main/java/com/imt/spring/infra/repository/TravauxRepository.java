package com.imt.spring.infra.repository;

import com.imt.spring.infra.model.Travaux;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravauxRepository extends CrudRepository<Travaux, Integer> {
    @Query(value = "SELECT * FROM infra.travaux", nativeQuery = true)
    List<Travaux> getTravaux();
}
