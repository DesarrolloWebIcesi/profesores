/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.M4ccbCvProdTec;
import co.edu.icesi.profesores.entities.M4ccbCvProdTecPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 14620701
 */
public class M4ccbCvProdTecJpaController implements Serializable {

    public M4ccbCvProdTecJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    

    public List<M4ccbCvProdTec> findM4ccbCvProdTecEntities() {
        return findM4ccbCvProdTecEntities(true, -1, -1);
    }

    public List<M4ccbCvProdTec> findM4ccbCvProdTecEntities(int maxResults, int firstResult) {
        return findM4ccbCvProdTecEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvProdTec> findM4ccbCvProdTecEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvProdTec.class));
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

    public M4ccbCvProdTec findM4ccbCvProdTec(M4ccbCvProdTecPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvProdTec.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvProdTecCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvProdTec> rt = cq.from(M4ccbCvProdTec.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
