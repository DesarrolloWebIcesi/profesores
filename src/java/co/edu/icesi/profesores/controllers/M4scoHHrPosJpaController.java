/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.M4scoHHrPos;
import co.edu.icesi.profesores.entities.M4scoHHrPosPK;
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
public class M4scoHHrPosJpaController implements Serializable {

    public M4scoHHrPosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4scoHHrPos m4scoHHrPos) throws PreexistingEntityException, Exception {
        if (m4scoHHrPos.getM4scoHHrPosPK() == null) {
            m4scoHHrPos.setM4scoHHrPosPK(new M4scoHHrPosPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4scoHHrPos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4scoHHrPos(m4scoHHrPos.getM4scoHHrPosPK()) != null) {
                throw new PreexistingEntityException("M4scoHHrPos " + m4scoHHrPos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4scoHHrPos m4scoHHrPos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4scoHHrPos = em.merge(m4scoHHrPos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4scoHHrPosPK id = m4scoHHrPos.getM4scoHHrPosPK();
                if (findM4scoHHrPos(id) == null) {
                    throw new NonexistentEntityException("The m4scoHHrPos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4scoHHrPosPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4scoHHrPos m4scoHHrPos;
            try {
                m4scoHHrPos = em.getReference(M4scoHHrPos.class, id);
                m4scoHHrPos.getM4scoHHrPosPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4scoHHrPos with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4scoHHrPos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4scoHHrPos> findM4scoHHrPosEntities() {
        return findM4scoHHrPosEntities(true, -1, -1);
    }

    public List<M4scoHHrPos> findM4scoHHrPosEntities(int maxResults, int firstResult) {
        return findM4scoHHrPosEntities(false, maxResults, firstResult);
    }

    private List<M4scoHHrPos> findM4scoHHrPosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4scoHHrPos.class));
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

    public M4scoHHrPos findM4scoHHrPos(M4scoHHrPosPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4scoHHrPos.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4scoHHrPosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4scoHHrPos> rt = cq.from(M4scoHHrPos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
