/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.M4ccbCvPrefEpil;
import co.edu.icesi.profesores.entities.M4ccbCvPrefEpilPK;
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
public class M4ccbCvPrefEpilJpaController implements Serializable {

    public M4ccbCvPrefEpilJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvPrefEpil m4ccbCvPrefEpil) throws PreexistingEntityException, Exception {
        if (m4ccbCvPrefEpil.getM4ccbCvPrefEpilPK() == null) {
            m4ccbCvPrefEpil.setM4ccbCvPrefEpilPK(new M4ccbCvPrefEpilPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvPrefEpil);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvPrefEpil(m4ccbCvPrefEpil.getM4ccbCvPrefEpilPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvPrefEpil " + m4ccbCvPrefEpil + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvPrefEpil m4ccbCvPrefEpil) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvPrefEpil = em.merge(m4ccbCvPrefEpil);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvPrefEpilPK id = m4ccbCvPrefEpil.getM4ccbCvPrefEpilPK();
                if (findM4ccbCvPrefEpil(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvPrefEpil with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvPrefEpilPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvPrefEpil m4ccbCvPrefEpil;
            try {
                m4ccbCvPrefEpil = em.getReference(M4ccbCvPrefEpil.class, id);
                m4ccbCvPrefEpil.getM4ccbCvPrefEpilPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvPrefEpil with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvPrefEpil);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvPrefEpil> findM4ccbCvPrefEpilEntities() {
        return findM4ccbCvPrefEpilEntities(true, -1, -1);
    }

    public List<M4ccbCvPrefEpil> findM4ccbCvPrefEpilEntities(int maxResults, int firstResult) {
        return findM4ccbCvPrefEpilEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvPrefEpil> findM4ccbCvPrefEpilEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvPrefEpil.class));
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

    public M4ccbCvPrefEpil findM4ccbCvPrefEpil(M4ccbCvPrefEpilPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvPrefEpil.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvPrefEpilCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvPrefEpil> rt = cq.from(M4ccbCvPrefEpil.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
