package fr.remi.jegard.java.dao;

import fr.remi.jegard.java.bo.Cat;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CatDAO {
    private EntityManager em;

    public CatDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Cat cat) {
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }

    public List<Cat> getAllWithChip() {
        return em.createQuery("SELECT c FROM Cat c WHERE c.chipId IS NOT NULL", Cat.class).getResultList();
    }
}
