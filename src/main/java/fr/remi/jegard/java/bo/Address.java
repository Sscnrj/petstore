package fr.remi.jegard.java.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String street;
    private String zipCode;
    private String city;


    public Address() {}

    public Address(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public String getNumber() { return number; }
    public String getStreet() { return street; }
    public String getZipCode() { return zipCode; }
    public String getCity() { return city; }

    public void setId(Long id) { this.id = id; }
    public void setNumber(String number) { this.number = number; }
    public void setStreet(String street) { this.street = street; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
