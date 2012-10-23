/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.StdHrPrevJobs;
import co.edu.icesi.profesores.entities.StdHrPrevJobsPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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
