/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.M4ccbCvDlloMat;
import co.edu.icesi.profesores.entities.M4ccbCvDlloMatPK;
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
public class M4ccbCvDlloMatJpaController implements Serializable {

    public M4ccbCvDlloMatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
  
    public List<M4ccbCvDlloMat> findM4ccbCvDlloMatEntities() {
        return findM4ccbCvDlloMatEntities(true, -1, -1);
    }

    public List<M4ccbCvDlloMat> findM4ccbCvDlloMatEntities(int maxResults, int firstResult) {
        return findM4ccbCvDlloMatEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvDlloMat> findM4ccbCvDlloMatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvDlloMat.class));
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

    public M4ccbCvDlloMat findM4ccbCvDlloMat(M4ccbCvDlloMatPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvDlloMat.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvDlloMatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvDlloMat> rt = cq.from(M4ccbCvDlloMat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List <M4ccbCvDlloMat> findM4ccbCvDlloMatByStdIdHr(String idProfesor){
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvDlloMat> q= em.createNamedQuery("M4ccbCvDlloMat.findByStdIdHr", M4ccbCvDlloMat.class);
            q.setParameter("stdIdHr", idProfesor);
            List <M4ccbCvDlloMat> items = q.getResultList();
            return items;
        }catch(NoResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
}
