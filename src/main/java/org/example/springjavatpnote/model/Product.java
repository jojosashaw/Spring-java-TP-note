package org.example.springjavatpnote.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProdType type;

    @Column(nullable = false)
    private double price;

    @ManyToMany(mappedBy = "products")
    private List<PetStore> petStores;
}
