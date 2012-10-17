/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.M4ccbCvEdicionR;
import co.edu.icesi.profesores.entities.M4ccbCvEdicionRPK;
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
public class M4ccbCvEdicionRJpaController implements Serializable {

    public M4ccbCvEdicionRJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvEdicionR m4ccbCvEdicionR) throws PreexistingEntityException, Exception {
        if (m4ccbCvEdicionR.getM4ccbCvEdicionRPK() == null) {
            m4ccbCvEdicionR.setM4ccbCvEdicionRPK(new M4ccbCvEdicionRPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvEdicionR);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvEdicionR(m4ccbCvEdicionR.getM4ccbCvEdicionRPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvEdicionR " + m4ccbCvEdicionR + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvEdicionR m4ccbCvEdicionR) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvEdicionR = em.merge(m4ccbCvEdicionR);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvEdicionRPK id = m4ccbCvEdicionR.getM4ccbCvEdicionRPK();
                if (findM4ccbCvEdicionR(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvEdicionR with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvEdicionRPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvEdicionR m4ccbCvEdicionR;
            try {
                m4ccbCvEdicionR = em.getReference(M4ccbCvEdicionR.class, id);
                m4ccbCvEdicionR.getM4ccbCvEdicionRPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvEdicionR with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvEdicionR);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvEdicionR> findM4ccbCvEdicionREntities() {
        return findM4ccbCvEdicionREntities(true, -1, -1);
    }

    public List<M4ccbCvEdicionR> findM4ccbCvEdicionREntities(int maxResults, int firstResult) {
        return findM4ccbCvEdicionREntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvEdicionR> findM4ccbCvEdicionREntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvEdicionR.class));
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

    public M4ccbCvEdicionR findM4ccbCvEdicionR(M4ccbCvEdicionRPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvEdicionR.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvEdicionRCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvEdicionR> rt = cq.from(M4ccbCvEdicionR.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
