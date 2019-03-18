package com.imt.spring.infra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Sillon {

    @Id
    public int id;

    @Column
    public int position;

    @OneToOne
    public Ligne ligne;

}
