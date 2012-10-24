/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.M4ccbCvCapLib;
import co.edu.icesi.profesores.entities.M4ccbCvCapLibPK;
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
public class M4ccbCvCapLibJpaController implements Serializable {

    public M4ccbCvCapLibJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }   

    public List<M4ccbCvCapLib> findM4ccbCvCapLibEntities() {
        return findM4ccbCvCapLibEntities(true, -1, -1);
    }

    public List<M4ccbCvCapLib> findM4ccbCvCapLibEntities(int maxResults, int firstResult) {
        return findM4ccbCvCapLibEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvCapLib> findM4ccbCvCapLibEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvCapLib.class));
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

    public M4ccbCvCapLib findM4ccbCvCapLib(M4ccbCvCapLibPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvCapLib.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvCapLibCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvCapLib> rt = cq.from(M4ccbCvCapLib.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List <M4ccbCvCapLib> findM4ccbCvCapLibByStdIdHr(String idProfesor){
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvCapLib> q= em.createNamedQuery("M4ccbCvCapLib.findByStdIdHr", M4ccbCvCapLib.class);
            q.setParameter("stdIdHr", idProfesor);
            List <M4ccbCvCapLib> chapters = q.getResultList();
            return chapters;
        }catch(NoResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
}
