package fr.remi.jegard.java.bo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("Cat")
public class Cat extends Animal {
    private String chipId;

    public Cat(Date birth, String couleur, PetStore petStore, String chipId) {
        super(birth, couleur, petStore);
        this.chipId = chipId;
    }

    public Cat() {}


    // Getters et Setters
    public String getChipId() { return chipId; }
    public void setChipId(String chipId) { this.chipId = chipId; }

    @Override
    public String toString() {
        return "Cat{" +
                "chipId='" + chipId + '\'' +
                '}';
    }
}
