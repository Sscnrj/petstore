package fr.remi.jegard.java.bo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "petstore")
public class PetStore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String managerName;

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private List<Animal> animals = new ArrayList<>();

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
    }


    // Getters et Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getManagerName() { return managerName; }
    public Address getAddress() { return address; }
    public List<Animal> getAnimals() { return animals; }
    public List<Product> getProducts() { return products; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
    public void setAddress(Address address) { this.address = address; }
    public void setAnimals(List<Animal> animals) { this.animals = animals; }
    public void setProducts(List<Product> products) { this.products = products; }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", address=" + address +
                '}';
    }
}
