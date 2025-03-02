package fr.remi.jegard.java.dao;

import fr.remi.jegard.java.bo.Address;
import jakarta.persistence.EntityManager;
import java.util.List;

public class AddressDAO {
    private EntityManager em;

    public AddressDAO(EntityManager em) { this.em = em; }

    public void save(Address address) {
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
    }

    public Address findById(Long id) { return em.find(Address.class, id); }

    public List<Address> getAll() {
        return em.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }
}
