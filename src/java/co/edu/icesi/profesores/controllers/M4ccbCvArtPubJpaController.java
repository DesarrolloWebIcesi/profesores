/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.M4ccbCvArtPub;
import co.edu.icesi.profesores.entities.M4ccbCvArtPubPK;
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
public class M4ccbCvArtPubJpaController implements Serializable {

    public M4ccbCvArtPubJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }  

    public List<M4ccbCvArtPub> findM4ccbCvArtPubEntities() {
        return findM4ccbCvArtPubEntities(true, -1, -1);
    }
    
    public List <M4ccbCvArtPub> findM4ccbCvArtPubfindByStdIdHr(String idProfesor){
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvArtPub> q= em.createNamedQuery("M4ccbCvArtPub.findByStdIdHr", M4ccbCvArtPub.class);
            q.setParameter("stdIdHr", idProfesor);
            List <M4ccbCvArtPub> articulos = q.getResultList();
            return articulos;
        }catch(NoResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
    public List<M4ccbCvArtPub> findM4ccbCvArtPubEntities(int maxResults, int firstResult) {
        return findM4ccbCvArtPubEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvArtPub> findM4ccbCvArtPubEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvArtPub.class));
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

    public M4ccbCvArtPub findM4ccbCvArtPub(M4ccbCvArtPubPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvArtPub.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvArtPubCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvArtPub> rt = cq.from(M4ccbCvArtPub.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
