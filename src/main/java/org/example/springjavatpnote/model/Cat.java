package org.example.springjavatpnote.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "cat")
public class Cat extends Animal {

    @Column(name = "chipId")
    private String chipId;

    public Cat() {
    }

    public Cat(Date birth, String color, PetStore petStore, String chipId) {
        super(birth, color, petStore);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "chipId='" + chipId + '\'' +
                ", " + super.toString() +
                '}';
    }
}
