/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.M4ccbCvPrefEpil;
import co.edu.icesi.profesores.entities.M4ccbCvPrefEpilPK;
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
public class M4ccbCvPrefEpilJpaController implements Serializable {

    public M4ccbCvPrefEpilJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<M4ccbCvPrefEpil> findM4ccbCvPrefEpilEntities() {
        return findM4ccbCvPrefEpilEntities(true, -1, -1);
    }

    public List<M4ccbCvPrefEpil> findM4ccbCvPrefEpilEntities(int maxResults, int firstResult) {
        return findM4ccbCvPrefEpilEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvPrefEpil> findM4ccbCvPrefEpilEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvPrefEpil.class));
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

    public M4ccbCvPrefEpil findM4ccbCvPrefEpil(M4ccbCvPrefEpilPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvPrefEpil.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvPrefEpilCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvPrefEpil> rt = cq.from(M4ccbCvPrefEpil.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List <M4ccbCvPrefEpil> findM4ccbCvPrefEpilByStdIdHr(String idProfesor){
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvPrefEpil> q= em.createNamedQuery("M4ccbCvPrefEpil.findByStdIdHr", M4ccbCvPrefEpil.class);
            q.setParameter("stdIdHr", idProfesor);
            List <M4ccbCvPrefEpil> items = q.getResultList();
            return items;
        }catch(NoResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
}
