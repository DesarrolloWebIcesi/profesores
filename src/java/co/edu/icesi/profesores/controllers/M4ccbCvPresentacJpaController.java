/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.M4ccbCvPresentac;
import co.edu.icesi.profesores.entities.M4ccbCvPresentacPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 14620701
 */
public class M4ccbCvPresentacJpaController implements Serializable {

    
    public M4ccbCvPresentacJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
   

    public List<M4ccbCvPresentac> findM4ccbCvPresentacEntities() {
        return findM4ccbCvPresentacEntities(true, -1, -1);
    }

    public List<M4ccbCvPresentac> findM4ccbCvPresentacEntities(int maxResults, int firstResult) {
        return findM4ccbCvPresentacEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvPresentac> findM4ccbCvPresentacEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvPresentac.class));
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

    public M4ccbCvPresentac findM4ccbCvPresentac(M4ccbCvPresentacPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvPresentac.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvPresentacCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvPresentac> rt = cq.from(M4ccbCvPresentac.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
     public List <M4ccbCvPresentac> findM4ccbCvPresentationByStdIdHr(String idProfesor){
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvPresentac> q= em.createNamedQuery("M4ccbCvPresentac.findByStdIdHr", M4ccbCvPresentac.class);
            q.setParameter("stdIdHr", idProfesor);
            List <M4ccbCvPresentac> items = q.getResultList();
            return items;
        }catch(NoResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
}
