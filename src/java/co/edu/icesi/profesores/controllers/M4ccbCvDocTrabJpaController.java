/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.M4ccbCvDocTrab;
import co.edu.icesi.profesores.entities.M4ccbCvDocTrabPK;
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
public class M4ccbCvDocTrabJpaController implements Serializable {

    public M4ccbCvDocTrabJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
  
    public List<M4ccbCvDocTrab> findM4ccbCvDocTrabEntities() {
        return findM4ccbCvDocTrabEntities(true, -1, -1);
    }

    public List<M4ccbCvDocTrab> findM4ccbCvDocTrabEntities(int maxResults, int firstResult) {
        return findM4ccbCvDocTrabEntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvDocTrab> findM4ccbCvDocTrabEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvDocTrab.class));
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

    public M4ccbCvDocTrab findM4ccbCvDocTrab(M4ccbCvDocTrabPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvDocTrab.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvDocTrabCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvDocTrab> rt = cq.from(M4ccbCvDocTrab.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List <M4ccbCvDocTrab> findM4ccbCvDocTrabByStdIdHr(String idProfesor){
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvDocTrab> q= em.createNamedQuery("M4ccbCvDocTrab.findByStdIdHr", M4ccbCvDocTrab.class);
            q.setParameter("stdIdHr", idProfesor);
            List <M4ccbCvDocTrab> items = q.getResultList();
            return items;
        }catch(NoResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
}
