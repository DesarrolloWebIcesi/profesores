/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.M4ccbCvTrabTecn;
import co.edu.icesi.profesores.entities.M4ccbCvTrabTecnPK;
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
public class M4ccbCvTrabTecnJpaController implements Serializable {

    public M4ccbCvTrabTecnJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<M4ccbCvTrabTecn> findM4ccbCvTrabTecnEntities() {
        return findM4ccbCvTrabTecnEntities(true, -1, -1);
    }

    public List<M4ccbCvTrabTecn> findM4ccbCvTrabTecnEntities(int maxResults, int firstResult) {
        return findM4ccbCvTrabTecnEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvTrabTecn> findM4ccbCvTrabTecnEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvTrabTecn.class));
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

    public M4ccbCvTrabTecn findM4ccbCvTrabTecn(M4ccbCvTrabTecnPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvTrabTecn.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvTrabTecnCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvTrabTecn> rt = cq.from(M4ccbCvTrabTecn.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
