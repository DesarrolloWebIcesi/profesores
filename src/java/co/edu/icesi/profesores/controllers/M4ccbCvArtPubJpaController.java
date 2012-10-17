/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.M4ccbCvArtPub;
import co.edu.icesi.profesores.entities.M4ccbCvArtPubPK;
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
public class M4ccbCvArtPubJpaController implements Serializable {

    public M4ccbCvArtPubJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvArtPub m4ccbCvArtPub) throws PreexistingEntityException, Exception {
        if (m4ccbCvArtPub.getM4ccbCvArtPubPK() == null) {
            m4ccbCvArtPub.setM4ccbCvArtPubPK(new M4ccbCvArtPubPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvArtPub);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvArtPub(m4ccbCvArtPub.getM4ccbCvArtPubPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvArtPub " + m4ccbCvArtPub + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvArtPub m4ccbCvArtPub) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvArtPub = em.merge(m4ccbCvArtPub);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvArtPubPK id = m4ccbCvArtPub.getM4ccbCvArtPubPK();
                if (findM4ccbCvArtPub(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvArtPub with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvArtPubPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvArtPub m4ccbCvArtPub;
            try {
                m4ccbCvArtPub = em.getReference(M4ccbCvArtPub.class, id);
                m4ccbCvArtPub.getM4ccbCvArtPubPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvArtPub with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvArtPub);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvArtPub> findM4ccbCvArtPubEntities() {
        return findM4ccbCvArtPubEntities(true, -1, -1);
    }

    public List<M4ccbCvArtPub> findM4ccbCvArtPubEntities(int maxResults, int firstResult) {
        return findM4ccbCvArtPubEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvArtPub> findM4ccbCvArtPubEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvArtPub.class));
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

    public M4ccbCvArtPub findM4ccbCvArtPub(M4ccbCvArtPubPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvArtPub.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvArtPubCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvArtPub> rt = cq.from(M4ccbCvArtPub.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
