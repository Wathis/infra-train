package com.imt.spring.infra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Desserte {

    @Id
    @GeneratedValue
    public int id;

    @Column
    public String nom;

}
