package com.imt.spring.infra.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    public int id;

    @Column
    public int id_reservation_transporteur;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<Reservation> reservation;

}
