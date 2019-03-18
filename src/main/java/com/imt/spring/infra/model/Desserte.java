package com.imt.spring.infra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Desserte {

    @Id
    public int id;

    @Column
    public String nom;

}
