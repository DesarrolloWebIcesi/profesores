/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.M4scoPosition;
import co.edu.icesi.profesores.entities.M4scoPositionPK;
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
public class M4scoPositionJpaController implements Serializable {

    public M4scoPositionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4scoPosition m4scoPosition) throws PreexistingEntityException, Exception {
        if (m4scoPosition.getM4scoPositionPK() == null) {
            m4scoPosition.setM4scoPositionPK(new M4scoPositionPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4scoPosition);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4scoPosition(m4scoPosition.getM4scoPositionPK()) != null) {
                throw new PreexistingEntityException("M4scoPosition " + m4scoPosition + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4scoPosition m4scoPosition) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4scoPosition = em.merge(m4scoPosition);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4scoPositionPK id = m4scoPosition.getM4scoPositionPK();
                if (findM4scoPosition(id) == null) {
                    throw new NonexistentEntityException("The m4scoPosition with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4scoPositionPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4scoPosition m4scoPosition;
            try {
                m4scoPosition = em.getReference(M4scoPosition.class, id);
                m4scoPosition.getM4scoPositionPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4scoPosition with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4scoPosition);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4scoPosition> findM4scoPositionEntities() {
        return findM4scoPositionEntities(true, -1, -1);
    }

    public List<M4scoPosition> findM4scoPositionEntities(int maxResults, int firstResult) {
        return findM4scoPositionEntities(false, maxResults, firstResult);
    }

    private List<M4scoPosition> findM4scoPositionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4scoPosition.class));
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

    public M4scoPosition findM4scoPosition(M4scoPositionPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4scoPosition.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4scoPositionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4scoPosition> rt = cq.from(M4scoPosition.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
