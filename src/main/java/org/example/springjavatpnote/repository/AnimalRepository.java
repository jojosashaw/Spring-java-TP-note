package org.example.springjavatpnote.repository;

import org.example.springjavatpnote.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    //Requête qui permet d’extraire tous les animaux d’une animalerie donnée (@Query)
    @Query("SELECT a FROM Animal a WHERE a.petStore.id = :storeId")
    List<Animal> findAnimalsByPetStore(@Param("storeId") Long storeId);
}
