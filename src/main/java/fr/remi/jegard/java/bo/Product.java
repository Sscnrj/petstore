package fr.remi.jegard.java.bo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String label;
    private double price;

    @Enumerated(EnumType.STRING)
    private ProdType type;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;

    public Product(String code, String label, double price, ProdType type, PetStore petStore) {
        this.code = code;
        this.label = label;
        this.price = price;
        this.type = type;
        this.petStore = petStore;
    }

    public Product() {}


    // Getters et Setters
    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getLabel() { return label; }
    public double getPrice() { return price; }
    public ProdType getType() { return type; }
    public PetStore getPetStore() { return petStore; }

    public void setId(Long id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setLabel(String label) { this.label = label; }
    public void setPrice(double price) { this.price = price; }
    public void setType(ProdType type) { this.type = type; }
    public void setPetStore(PetStore petStore) { this.petStore = petStore; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
