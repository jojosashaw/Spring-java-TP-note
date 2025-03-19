package org.example.springjavatpnote.model;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private String number;
    @Column(name = "street")
    private String street;
    @Column(name = "zipCode")
    private String zipCode;
    @Column(name = "city")
    private String city;
    @OneToOne(mappedBy = "address")
    private PetStore petStore;
}
