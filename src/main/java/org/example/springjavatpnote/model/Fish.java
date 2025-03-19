package org.example.springjavatpnote.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fish")
public class Fish extends Animal {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "livingEnv")
    private FishLivEnv livingEnv;
}
