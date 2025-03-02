package fr.remi.jegard.java.dao;

import fr.remi.jegard.java.bo.Product;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ProductDAO {
    private EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> getAllByPetStore(Long petStoreId) {
        return em.createQuery("SELECT p FROM Product p WHERE p.petStore.id = :storeId", Product.class)
                .setParameter("storeId", petStoreId)
                .getResultList();
    }
}
