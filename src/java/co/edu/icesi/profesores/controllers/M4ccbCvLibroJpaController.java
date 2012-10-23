/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.M4ccbCvLibro;
import co.edu.icesi.profesores.entities.M4ccbCvLibroPK;
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
public class M4ccbCvLibroJpaController implements Serializable {

    public M4ccbCvLibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<M4ccbCvLibro> findM4ccbCvLibroEntities() {
        return findM4ccbCvLibroEntities(true, -1, -1);
    }

    public List<M4ccbCvLibro> findM4ccbCvLibroEntities(int maxResults, int firstResult) {
        return findM4ccbCvLibroEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvLibro> findM4ccbCvLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvLibro.class));
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

    public M4ccbCvLibro findM4ccbCvLibro(M4ccbCvLibroPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvLibro.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvLibro> rt = cq.from(M4ccbCvLibro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
