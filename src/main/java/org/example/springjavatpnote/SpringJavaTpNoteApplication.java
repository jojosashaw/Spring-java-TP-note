package org.example.springjavatpnote;

import org.example.springjavatpnote.model.*;
import org.example.springjavatpnote.repository.AnimalRepository;
import org.example.springjavatpnote.repository.PetStoreRepository;
import org.example.springjavatpnote.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringJavaTpNoteApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringJavaTpNoteApplication.class, args);
    }

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PetStoreRepository petStoreRepository;

    @Override
    public void run(String... args) {

        // Création des adresses
        Address address1 = new Address("10", "rue des Animaux", "75001", "Paris");
        Address address2 = new Address("25", "avenue des Bêtes", "69000", "Lyon");
        Address address3 = new Address("5", "boulevard des Fauves", "13000", "Marseille");

        // Création des PetStores
        PetStore store1 = new PetStore("PetLand", "Jean Dupont", address1);
        PetStore store2 = new PetStore("Animalia", "Marie Curie", address2);
        PetStore store3 = new PetStore("ZooShop", "Albert Einstein", address3);

        petStoreRepository.saveAll(List.of(store1, store2, store3));

        // Création des animaux
        Animal cat = new Cat(new Date(123, 4, 10), "Black", store1,"CHIP1234");
        Animal fish = new Fish(new Date(122, 7, 25), "blue", store2, FishLivEnv.SEA_WATER);
        Animal dog = new Animal(new Date(121, 2, 15), "Brun", store1);

        animalRepository.saveAll(List.of(cat, fish, dog));

        // Création des produits
        Product food = new Product("123ABC", "DogFood", ProdType.FOOD, 10.99);
        Product toy = new Product("456DEF", "Ball", ProdType.ACCESSORY, 5.49);
        Product shampoo = new Product("789GHI", "Shampoo", ProdType.CLEANING, 8.99);

        store1.setProducts(List.of(food, toy));
        store2.setProducts(List.of(shampoo));

        productRepository.saveAll(List.of(food, toy, shampoo));
        petStoreRepository.saveAll(List.of(store1, store2));

        //Requête qui permet d’extraire tous les produits en fonction d’un code produit
        String codeRecherche = "123ABC";
        Optional<Product> produitTrouve = productRepository.findByCode(codeRecherche);

        if (produitTrouve.isPresent()) {
            System.out.println("Produit trouvé : " + produitTrouve.get());
        } else {
            System.out.println("Aucun produit trouvé avec le code " + codeRecherche);
        }

        //Requête qui permet d’extraire tous les animaux d’une animalerie donnée (@Query)
        Long petStoreIdRecherche = store1.getId();
        List<Animal> animauxDeStore1 = animalRepository.findAnimalsByPetStore(petStoreIdRecherche);
        System.out.println("Animaux du magasin " + store1.getName() + " : " + animauxDeStore1);
    }
}