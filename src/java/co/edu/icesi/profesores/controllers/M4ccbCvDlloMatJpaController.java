/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.M4ccbCvDlloMat;
import co.edu.icesi.profesores.entities.M4ccbCvDlloMatPK;
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
public class M4ccbCvDlloMatJpaController implements Serializable {

    public M4ccbCvDlloMatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4ccbCvDlloMat m4ccbCvDlloMat) throws PreexistingEntityException, Exception {
        if (m4ccbCvDlloMat.getM4ccbCvDlloMatPK() == null) {
            m4ccbCvDlloMat.setM4ccbCvDlloMatPK(new M4ccbCvDlloMatPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4ccbCvDlloMat);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4ccbCvDlloMat(m4ccbCvDlloMat.getM4ccbCvDlloMatPK()) != null) {
                throw new PreexistingEntityException("M4ccbCvDlloMat " + m4ccbCvDlloMat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4ccbCvDlloMat m4ccbCvDlloMat) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4ccbCvDlloMat = em.merge(m4ccbCvDlloMat);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4ccbCvDlloMatPK id = m4ccbCvDlloMat.getM4ccbCvDlloMatPK();
                if (findM4ccbCvDlloMat(id) == null) {
                    throw new NonexistentEntityException("The m4ccbCvDlloMat with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4ccbCvDlloMatPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4ccbCvDlloMat m4ccbCvDlloMat;
            try {
                m4ccbCvDlloMat = em.getReference(M4ccbCvDlloMat.class, id);
                m4ccbCvDlloMat.getM4ccbCvDlloMatPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4ccbCvDlloMat with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4ccbCvDlloMat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4ccbCvDlloMat> findM4ccbCvDlloMatEntities() {
        return findM4ccbCvDlloMatEntities(true, -1, -1);
    }

    public List<M4ccbCvDlloMat> findM4ccbCvDlloMatEntities(int maxResults, int firstResult) {
        return findM4ccbCvDlloMatEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvDlloMat> findM4ccbCvDlloMatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvDlloMat.class));
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

    public M4ccbCvDlloMat findM4ccbCvDlloMat(M4ccbCvDlloMatPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvDlloMat.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvDlloMatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvDlloMat> rt = cq.from(M4ccbCvDlloMat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
