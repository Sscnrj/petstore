package fr.remi.jegard.java;

import fr.remi.jegard.java.dao.*;
import fr.remi.jegard.java.bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();

        PetStoreDAO petStoreDAO = new PetStoreDAO(em);
        AnimalDAO animalDAO = new AnimalDAO(em);
        ProductDAO productDAO = new ProductDAO(em);
        AddressDAO addressDAO = new AddressDAO(em);
        FishDAO fishDAO = new FishDAO(em);
        CatDAO catDAO = new CatDAO(em);

        // Création et insertion de 3 adresses
        Address address1 = new Address("12B", "Rue des Animaux", "75001", "Paris");
        Address address2 = new Address("34A", "Avenue des Fauves", "69002", "Lyon");
        Address address3 = new Address("56C", "Boulevard Marin", "33000", "Bordeaux");
        addressDAO.save(address1);
        addressDAO.save(address2);
        addressDAO.save(address3);

        // Création et insertion de 3 animaleries
        PetStore store1 = new PetStore("Exotic World", "Alice Dupont", address1);
        PetStore store2 = new PetStore("Wild Creatures", "Jean Martin", address2);
        PetStore store3 = new PetStore("Ocean Wonders", "Sophie Durant", address3);
        petStoreDAO.save(store1);
        petStoreDAO.save(store2);
        petStoreDAO.save(store3);

        // Création et insertion de 3 poissons
        Fish fish1 = new Fish(new java.util.Date(), "Rouge", store1, FishLivEnv.FRESH_WATER);
        Fish fish2 = new Fish(new java.util.Date(), "Bleu", store2, FishLivEnv.SEA_WATER);
        Fish fish3 = new Fish(new java.util.Date(), "Jaune", store3, FishLivEnv.FRESH_WATER);
        fishDAO.save(fish1);
        fishDAO.save(fish2);
        fishDAO.save(fish3);

        // Création et insertion de 3 chats
        Cat cat1 = new Cat(new java.util.Date(), "Blanc", store1, "CHIP12345");
        Cat cat2 = new Cat(new java.util.Date(), "Gris", store2, "CHIP67890");
        Cat cat3 = new Cat(new java.util.Date(), "Noir", store3, "CHIP11223");
        catDAO.save(cat1);
        catDAO.save(cat2);
        catDAO.save(cat3);

        // Création et insertion de 3 produits
        Product product1 = new Product("P001", "Litière premium", 25.99, ProdType.CLEANING, store1);
        Product product2 = new Product("P002", "Croquettes bio", 19.50, ProdType.FOOD, store2);
        Product product3 = new Product("P003", "Jouet en corde", 12.75, ProdType.ACCESSORY, store3);
        productDAO.save(product1);
        productDAO.save(product2);
        productDAO.save(product3);

        // Récupération des animaux d'une animalerie spécifique
        List<Animal> animalsInStore1 = animalDAO.getAllByPetStore(store1.getId());

        System.out.println("Animaux dans l'animalerie " + store1.getName() + " :");
        for (Animal animal : animalsInStore1) {
            System.out.println("- " + animal.getClass().getSimpleName() + " " + animal.getColor());
        }

        em.close();
        emf.close();
    }
}
