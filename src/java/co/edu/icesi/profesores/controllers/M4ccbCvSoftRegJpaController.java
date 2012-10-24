/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.M4ccbCvSoftReg;
import co.edu.icesi.profesores.entities.M4ccbCvSoftRegPK;
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
public class M4ccbCvSoftRegJpaController implements Serializable {

    public M4ccbCvSoftRegJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }  

    public List<M4ccbCvSoftReg> findM4ccbCvSoftRegEntities() {
        return findM4ccbCvSoftRegEntities(true, -1, -1);
    }

    public List<M4ccbCvSoftReg> findM4ccbCvSoftRegEntities(int maxResults, int firstResult) {
        return findM4ccbCvSoftRegEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvSoftReg> findM4ccbCvSoftRegEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvSoftReg.class));
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

    public M4ccbCvSoftReg findM4ccbCvSoftReg(M4ccbCvSoftRegPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvSoftReg.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvSoftRegCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvSoftReg> rt = cq.from(M4ccbCvSoftReg.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List <M4ccbCvSoftReg> findM4ccbCvSoftRegByStdIdHr(String idProfesor){
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvSoftReg> q= em.createNamedQuery("M4ccbCvSoftReg.findByStdIdHr", M4ccbCvSoftReg.class);
            q.setParameter("stdIdHr", idProfesor);
            List <M4ccbCvSoftReg> items = q.getResultList();
            return items;
        }catch(NoResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
}
