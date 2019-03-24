package com.imt.spring.infra.model;

import javax.persistence.*;

@Entity
public class Sillon {

    @Id
    @GeneratedValue
    public int id;

    @Column
    public int position;

    @OneToOne
    public Ligne ligne;

    public Sillon(int id) {
        this.id = id;
    }
}
