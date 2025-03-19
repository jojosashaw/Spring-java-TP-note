package org.example.springjavatpnote;

import org.example.springjavatpnote.model.*;
import org.example.springjavatpnote.repository.AnimalRepository;
import org.example.springjavatpnote.repository.PetStoreRepository;
import org.example.springjavatpnote.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DataInitializer implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BestiolesApplication.class, args);
    }

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PetStoreRepository petStoreRepository;

    @Override
    public void run(String... args) throws Exception {
        PetStore store1 = new PetStore("PetLand", "Paris");
        PetStore store2 = new PetStore("Animalia", "Lyon");
        PetStore store3 = new PetStore("ZooShop", "Marseille");

        petStoreRepository.saveAll(List.of(store1, store2, store3));

        Animal cat = new Cat("Felix", 2, "black");
        Animal fish = new Fish("Nemo", 1, FishLivEnv.SEA_WATER);
        Animal dog = new Animal("Rex", 3);

        animalRepository.saveAll(List.of(cat, fish, dog));

        Product food = new Product("DogFood", "123ABC", ProdType.FOOD);
        Product toy = new Product("Ball", "456DEF", ProdType.ACCESSORY);
        Product shampoo = new Product("Shampoo", "789GHI", ProdType.CLEANING);

        productRepository.saveAll(List.of(food, toy, shampoo));

    }

}
