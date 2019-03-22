package com.imt.spring.infra.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue
    public int id;

    @Column
    public String id_reservation_transporteur;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<Reservation> reservation;

}
