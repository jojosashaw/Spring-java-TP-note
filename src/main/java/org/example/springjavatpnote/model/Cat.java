package org.example.springjavatpnote.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cat")
public class Cat extends Animal {

    @Column(name = "chipId")
    private String chipId;
}
