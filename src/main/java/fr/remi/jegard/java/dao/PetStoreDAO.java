package fr.remi.jegard.java.dao;

import fr.remi.jegard.java.bo.PetStore;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PetStoreDAO {
    private EntityManager em;

    public PetStoreDAO(EntityManager em) {
        this.em = em;
    }

    public void save(PetStore petStore) {
        em.getTransaction().begin();
        em.persist(petStore);
        em.getTransaction().commit();
    }

    public PetStore findById(Long id) {
        return em.find(PetStore.class, id);
    }

    public List<PetStore> getAll() {
        return em.createQuery("SELECT p FROM PetStore p", PetStore.class).getResultList();
    }
}
