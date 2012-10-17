/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.StdHrAcadBackgr;
import co.edu.icesi.profesores.entities.StdHrAcadBackgrPK;
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
public class StdHrAcadBackgrJpaController implements Serializable {

    public StdHrAcadBackgrJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StdHrAcadBackgr stdHrAcadBackgr) throws PreexistingEntityException, Exception {
        if (stdHrAcadBackgr.getStdHrAcadBackgrPK() == null) {
            stdHrAcadBackgr.setStdHrAcadBackgrPK(new StdHrAcadBackgrPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdHrAcadBackgr);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdHrAcadBackgr(stdHrAcadBackgr.getStdHrAcadBackgrPK()) != null) {
                throw new PreexistingEntityException("StdHrAcadBackgr " + stdHrAcadBackgr + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdHrAcadBackgr stdHrAcadBackgr) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdHrAcadBackgr = em.merge(stdHrAcadBackgr);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdHrAcadBackgrPK id = stdHrAcadBackgr.getStdHrAcadBackgrPK();
                if (findStdHrAcadBackgr(id) == null) {
                    throw new NonexistentEntityException("The stdHrAcadBackgr with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdHrAcadBackgrPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdHrAcadBackgr stdHrAcadBackgr;
            try {
                stdHrAcadBackgr = em.getReference(StdHrAcadBackgr.class, id);
                stdHrAcadBackgr.getStdHrAcadBackgrPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdHrAcadBackgr with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdHrAcadBackgr);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StdHrAcadBackgr> findStdHrAcadBackgrEntities() {
        return findStdHrAcadBackgrEntities(true, -1, -1);
    }

    public List<StdHrAcadBackgr> findStdHrAcadBackgrEntities(int maxResults, int firstResult) {
        return findStdHrAcadBackgrEntities(false, maxResults, firstResult);
    }

    private List<StdHrAcadBackgr> findStdHrAcadBackgrEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdHrAcadBackgr.class));
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

    public StdHrAcadBackgr findStdHrAcadBackgr(StdHrAcadBackgrPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdHrAcadBackgr.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdHrAcadBackgrCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdHrAcadBackgr> rt = cq.from(StdHrAcadBackgr.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
