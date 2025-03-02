package fr.remi.jegard.java.bo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("Fish")
public class Fish extends Animal {
    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    public Fish() {}

    public Fish(Date birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }


    // Getters et Setters
    public FishLivEnv getLivingEnv() { return livingEnv; }
    public void setLivingEnv(FishLivEnv livingEnv) { this.livingEnv = livingEnv; }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }
}
