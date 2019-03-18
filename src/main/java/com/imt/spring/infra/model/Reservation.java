package com.imt.spring.infra.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Reservation {
    @Id
    public int id;

    @Column
    public int timestamp;

    @ManyToOne
    public Sillon sillon;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
}
