package org.example.dao;

import org.example.entity.Customer;

import javax.persistence.*;
import java.util.List;

public class GenericDao {
    private EntityManagerFactory emf;

    public GenericDao(String persistenceName) {
        emf = Persistence.createEntityManagerFactory(persistenceName); // this is more than just a driver manager
    }

    public <T> boolean save (T entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        txn.begin();
        try {
            em.persist(entity);
            txn.commit();
            return true;
        } catch (Exception e) {
            txn.rollback();
            e.printStackTrace();
            return false;
        }
        finally {
            em.close();
        }
    }

    public <T> T findById(Class<T> entity, int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(entity, id);
        } finally {
            em.close();
        }
    }

    public <T> List<T> findAll (String inputQuery) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery(inputQuery);
        return query.getResultList();
    }

    public <T> boolean delete (Class<T> tClass, int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();

        try {
            txn.begin();
            T entity = em.find(tClass, id);
            em.remove(entity);
            txn.commit();
            return true;
        }
        catch (Exception e) {
            txn.rollback();
            return false;
        }
        finally {
            em.close();
        }
    }

}
