package org.example.springjavatpnote.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Une table par classe
@Table(name = "animal")
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name ="birth")
    private Date birth;

    @Column(name = "couleur")
    private String color;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;
}

