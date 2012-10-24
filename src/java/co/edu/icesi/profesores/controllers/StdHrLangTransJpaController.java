/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.StdHrLangTrans;
import co.edu.icesi.profesores.entities.StdHrLangTransPK;
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
 * @author 1130619373
 */
public class StdHrLangTransJpaController implements Serializable {

    public StdHrLangTransJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<StdHrLangTrans> findStdHrLangTransEntities() {
        return findStdHrLangTransEntities(true, -1, -1);
    }

    public List<StdHrLangTrans> findStdHrLangTransEntities(int maxResults, int firstResult) {
        return findStdHrLangTransEntities(false, maxResults, firstResult);
    }

    private List<StdHrLangTrans> findStdHrLangTransEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdHrLangTrans.class));
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

    public StdHrLangTrans findStdHrLangTrans(StdHrLangTransPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdHrLangTrans.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdHrLangTransCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdHrLangTrans> rt = cq.from(StdHrLangTrans.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List <StdHrLangTrans> findStdHrLangTransByStdIdHr(String idProfesor){
        EntityManager em=getEntityManager();
        try{
            TypedQuery<StdHrLangTrans> q= em.createNamedQuery("StdHrLangTrans.findByStdIdHr", StdHrLangTrans.class);
            q.setParameter("stdIdHr", idProfesor);
            List <StdHrLangTrans> items = q.getResultList();
            return items;
        }catch(NoResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
}
