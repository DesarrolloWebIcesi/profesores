/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.StdRelWorkUnit;
import co.edu.icesi.profesores.entities.StdRelWorkUnitPK;
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
public class StdRelWorkUnitJpaController implements Serializable {

    public StdRelWorkUnitJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StdRelWorkUnit stdRelWorkUnit) throws PreexistingEntityException, Exception {
        if (stdRelWorkUnit.getStdRelWorkUnitPK() == null) {
            stdRelWorkUnit.setStdRelWorkUnitPK(new StdRelWorkUnitPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdRelWorkUnit);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdRelWorkUnit(stdRelWorkUnit.getStdRelWorkUnitPK()) != null) {
                throw new PreexistingEntityException("StdRelWorkUnit " + stdRelWorkUnit + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdRelWorkUnit stdRelWorkUnit) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdRelWorkUnit = em.merge(stdRelWorkUnit);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdRelWorkUnitPK id = stdRelWorkUnit.getStdRelWorkUnitPK();
                if (findStdRelWorkUnit(id) == null) {
                    throw new NonexistentEntityException("The stdRelWorkUnit with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdRelWorkUnitPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdRelWorkUnit stdRelWorkUnit;
            try {
                stdRelWorkUnit = em.getReference(StdRelWorkUnit.class, id);
                stdRelWorkUnit.getStdRelWorkUnitPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdRelWorkUnit with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdRelWorkUnit);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StdRelWorkUnit> findStdRelWorkUnitEntities() {
        return findStdRelWorkUnitEntities(true, -1, -1);
    }

    public List<StdRelWorkUnit> findStdRelWorkUnitEntities(int maxResults, int firstResult) {
        return findStdRelWorkUnitEntities(false, maxResults, firstResult);
    }

    private List<StdRelWorkUnit> findStdRelWorkUnitEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdRelWorkUnit.class));
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

    public StdRelWorkUnit findStdRelWorkUnit(StdRelWorkUnitPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdRelWorkUnit.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdRelWorkUnitCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdRelWorkUnit> rt = cq.from(StdRelWorkUnit.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
