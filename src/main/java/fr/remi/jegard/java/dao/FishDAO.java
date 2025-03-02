package fr.remi.jegard.java.dao;

import fr.remi.jegard.java.bo.Fish;
import jakarta.persistence.EntityManager;
import java.util.List;

public class FishDAO {
    private EntityManager em;

    public FishDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Fish fish) {
        em.getTransaction().begin();
        em.persist(fish);
        em.getTransaction().commit();
    }

    public List<Fish> getAllByEnvironment(String environment) {
        return em.createQuery("SELECT f FROM Fish f WHERE f.livingEnv = :env", Fish.class)
                .setParameter("env", environment)
                .getResultList();
    }
}
