package com.imt.spring.infra.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Travaux {

    @Id
    @GeneratedValue
    public int id;

    @Column
    public String raison;

    @Column
    public int date_debut;

    @Column
    public int date_fin;

    @ManyToMany
    public List<Sillon> sillons;

}
