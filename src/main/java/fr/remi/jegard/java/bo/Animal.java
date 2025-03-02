package fr.remi.jegard.java.bo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Ajout de l'héritage
@DiscriminatorColumn(name = "animal_type", discriminatorType = DiscriminatorType.STRING)
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date birth;

    private String color;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;

    public Animal(Date birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.color = couleur;
        this.petStore = petStore;
    }

    public Animal() {}


    // Getters et Setters
    public Long getId() { return id; }
    public Date getBirth() { return birth; }
    public String getColor() { return color; }
    public PetStore getPetStore() { return petStore; }

    public void setId(Long id) { this.id = id; }
    public void setBirth(Date birth) { this.birth = birth; }
    public void setColor(String color) { this.color = color; }
    public void setPetStore(PetStore petStore) { this.petStore = petStore; }
}
