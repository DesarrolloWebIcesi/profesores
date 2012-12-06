/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.StdWorkUnit;
import co.edu.icesi.profesores.entities.StdWorkUnitPK;
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
public class StdWorkUnitJpaController implements Serializable {

    public StdWorkUnitJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StdWorkUnit stdWorkUnit) throws PreexistingEntityException, Exception {
        if (stdWorkUnit.getStdWorkUnitPK() == null) {
            stdWorkUnit.setStdWorkUnitPK(new StdWorkUnitPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdWorkUnit);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdWorkUnit(stdWorkUnit.getStdWorkUnitPK()) != null) {
                throw new PreexistingEntityException("StdWorkUnit " + stdWorkUnit + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdWorkUnit stdWorkUnit) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdWorkUnit = em.merge(stdWorkUnit);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdWorkUnitPK id = stdWorkUnit.getStdWorkUnitPK();
                if (findStdWorkUnit(id) == null) {
                    throw new NonexistentEntityException("The stdWorkUnit with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdWorkUnitPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdWorkUnit stdWorkUnit;
            try {
                stdWorkUnit = em.getReference(StdWorkUnit.class, id);
                stdWorkUnit.getStdWorkUnitPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdWorkUnit with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdWorkUnit);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StdWorkUnit> findStdWorkUnitEntities() {
        return findStdWorkUnitEntities(true, -1, -1);
    }

    public List<StdWorkUnit> findStdWorkUnitEntities(int maxResults, int firstResult) {
        return findStdWorkUnitEntities(false, maxResults, firstResult);
    }

    private List<StdWorkUnit> findStdWorkUnitEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdWorkUnit.class));
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

    public StdWorkUnit findStdWorkUnit(StdWorkUnitPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdWorkUnit.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdWorkUnitCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdWorkUnit> rt = cq.from(StdWorkUnit.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
