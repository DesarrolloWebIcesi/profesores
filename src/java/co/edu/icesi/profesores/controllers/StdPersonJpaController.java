/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.StdPerson;
import co.edu.icesi.profesores.entities.StdPersonPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 1130619373
 */
public class StdPersonJpaController implements Serializable {

    public StdPersonJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StdPerson stdPerson) throws PreexistingEntityException, Exception {
        if (stdPerson.getStdPersonPK() == null) {
            stdPerson.setStdPersonPK(new StdPersonPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdPerson);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdPerson(stdPerson.getStdPersonPK()) != null) {
                throw new PreexistingEntityException("StdPerson " + stdPerson + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdPerson stdPerson) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdPerson = em.merge(stdPerson);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdPersonPK id = stdPerson.getStdPersonPK();
                if (findStdPerson(id) == null) {
                    throw new NonexistentEntityException("The stdPerson with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdPersonPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdPerson stdPerson;
            try {
                stdPerson = em.getReference(StdPerson.class, id);
                stdPerson.getStdPersonPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdPerson with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdPerson);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StdPerson> findStdPersonEntities() {
        return findStdPersonEntities(true, -1, -1);
    }

    public List<StdPerson> findStdPersonEntities(int maxResults, int firstResult) {
        return findStdPersonEntities(false, maxResults, firstResult);
    }

    private List<StdPerson> findStdPersonEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdPerson.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public StdPerson findStdPerson(StdPersonPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdPerson.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdPersonCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdPerson> rt = cq.from(StdPerson.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
