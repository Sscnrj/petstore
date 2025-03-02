package fr.remi.jegard.java.dao;

import fr.remi.jegard.java.bo.Animal;
import jakarta.persistence.EntityManager;
import java.util.List;

public class AnimalDAO {
    private EntityManager em;

    public AnimalDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Animal animal) {
        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();
    }

    public Animal findById(Long id) {
        return em.find(Animal.class, id);
    }

    public List<Animal> getAllByPetStore(Long petStoreId) {
        return em.createQuery("SELECT a FROM Animal a WHERE a.petStore.id = :storeId", Animal.class)
                .setParameter("storeId", petStoreId)
                .getResultList();
    }
}
