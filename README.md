# 🏪 PetStore - Spring Boot & Spring Data JPA Sasha Wilk

## 📌 Description  
Ce projet est une application **Spring Boot** qui utilise **Spring Data JPA** et **Hibernate** pour modéliser une animalerie.  
L'objectif est de manipuler des entités JPA avec des relations complexes (**@OneToMany, @ManyToOne, @OneToOne**) et une gestion de l'héritage avec **JOINED Table**.  

### 🚀 Fonctionnalités  
- ✅ Insertion de données dans une base de données **PetStore**.  
- ✅ Récupération des **produits** en fonction d’un code produit.  
- ✅ Récupération des **animaux** d’une animalerie donnée.  

---

## 📁 Structure du projet  
Le projet suit une architecture **multi-couches** :  

- 📌 **Model (Entities)** : Définit la structure de la base de données avec des entités JPA.  
- 📌 **Repository** : Interfaces JpaRepository pour interagir avec la base de données.  
- 📌 **Service** *(optionnel)* : Contient la logique métier.  
- 📌 **Controller** *(optionnel)* : Expose des endpoints REST si besoin.  

---

## 🗃️ Modèle de données  
Les principales entités du projet :  
- **PetStore** (gère une liste d'animaux et de produits)  
- **Animal** (héritage : `Cat`, `Fish`)  
- **Product** (produits vendus dans l’animalerie)  
- **Address** (adresse de chaque PetStore)  

### ⚡ Relations  
- `@OneToMany` entre **PetStore** et **Animal**  
- `@ManyToMany` entre **PetStore** et **Product**  
- `@OneToOne` entre **PetStore** et **Address**  

---

## 🛠️ Installation et configuration  

### 1️⃣ Cloner le projet  
```bash
git clone https://github.com/podfleur/spring-data-jpa-petstore.git
cd spring-data-jpa-petstore
```
2️⃣ **Configurer la base de données**  
Dans le fichier `src/main/resources/application.properties`, ajouter :  

```properties
spring.application.name=petstore

# Datasource
spring.datasource.url=jdbc:mariadb://localhost:3306/petstore
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

# Hibernate & JPA settings
spring.jpa.properties.hibernate.transaction.coordinator_class=jdbc
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Pour rendre les requêtes hibernate plus lisible dans le terminal
spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect
```
## Technologies utilisées
 - Java 17+
 - Spring Boot 3
 - Spring Data JPA
 - Hibernate
 - MariaDB
 - Maven


📢 Auteurs

👤 Sasha Wilk

🚀 Projet réalisé dans le cadre d’un exercice sur Spring Boot & JPA.

PS : désolé monsieur j'ais complètement oublier de push ce que j'ai fait après le jour du tp
