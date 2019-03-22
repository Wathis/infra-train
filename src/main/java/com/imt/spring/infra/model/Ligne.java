package com.imt.spring.infra.model;

import javax.persistence.*;

@Entity
public class Ligne {

    @Id
    @GeneratedValue
    public int id;

    @OneToOne
    public Desserte depart;

    @OneToOne
    public Desserte arrivee;
}
