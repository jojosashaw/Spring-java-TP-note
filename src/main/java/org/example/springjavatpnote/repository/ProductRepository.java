package org.example.springjavatpnote.repository;

import org.example.springjavatpnote.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Requête qui permet d’extraire tous les produits en fonction d’un code produit
    Optional<Product> findByCode(String code);
}
