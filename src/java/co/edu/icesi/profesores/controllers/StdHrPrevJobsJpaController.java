/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.StdHrPrevJobs;
import co.edu.icesi.profesores.entities.StdHrPrevJobsPK;
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
public class StdHrPrevJobsJpaController implements Serializable {

    public StdHrPrevJobsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StdHrPrevJobs stdHrPrevJobs) throws PreexistingEntityException, Exception {
        if (stdHrPrevJobs.getStdHrPrevJobsPK() == null) {
            stdHrPrevJobs.setStdHrPrevJobsPK(new StdHrPrevJobsPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdHrPrevJobs);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdHrPrevJobs(stdHrPrevJobs.getStdHrPrevJobsPK()) != null) {
                throw new PreexistingEntityException("StdHrPrevJobs " + stdHrPrevJobs + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdHrPrevJobs stdHrPrevJobs) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdHrPrevJobs = em.merge(stdHrPrevJobs);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdHrPrevJobsPK id = stdHrPrevJobs.getStdHrPrevJobsPK();
                if (findStdHrPrevJobs(id) == null) {
                    throw new NonexistentEntityException("The stdHrPrevJobs with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdHrPrevJobsPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdHrPrevJobs stdHrPrevJobs;
            try {
                stdHrPrevJobs = em.getReference(StdHrPrevJobs.class, id);
                stdHrPrevJobs.getStdHrPrevJobsPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdHrPrevJobs with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdHrPrevJobs);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StdHrPrevJobs> findStdHrPrevJobsEntities() {
        return findStdHrPrevJobsEntities(true, -1, -1);
    }

    public List<StdHrPrevJobs> findStdHrPrevJobsEntities(int maxResults, int firstResult) {
        return findStdHrPrevJobsEntities(false, maxResults, firstResult);
    }

    private List<StdHrPrevJobs> findStdHrPrevJobsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdHrPrevJobs.class));
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

    public StdHrPrevJobs findStdHrPrevJobs(StdHrPrevJobsPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdHrPrevJobs.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdHrPrevJobsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdHrPrevJobs> rt = cq.from(StdHrPrevJobs.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
