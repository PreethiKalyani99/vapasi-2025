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

    public <T, U> T findById(Class<T> entity, U id) {
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

    public <T, U> boolean delete (Class<T> T,  U id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();

        try {
            txn.begin();
            T entity = em.find(T, id);
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

    public <T> boolean update (T T) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();

        try {
            txn.begin();
            em.merge(T);
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
