package com.imt.spring.infra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ligne {

    @Id
    public int id;

    @OneToOne
    public Desserte depart;

    @OneToOne
    public Desserte arrivee;
}
