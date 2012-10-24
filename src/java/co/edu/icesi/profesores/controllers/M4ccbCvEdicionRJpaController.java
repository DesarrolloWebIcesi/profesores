/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.M4ccbCvEdicionR;
import co.edu.icesi.profesores.entities.M4ccbCvEdicionRPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 1130619373
 */
public class M4ccbCvEdicionRJpaController implements Serializable {

    public M4ccbCvEdicionRJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<M4ccbCvEdicionR> findM4ccbCvEdicionREntities() {
        return findM4ccbCvEdicionREntities(true, -1, -1);
    }

    public List<M4ccbCvEdicionR> findM4ccbCvEdicionREntities(int maxResults, int firstResult) {
        return findM4ccbCvEdicionREntities(false, maxResults, firstResult);
    }

    private List<M4ccbCvEdicionR> findM4ccbCvEdicionREntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbCvEdicionR.class));
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

    public M4ccbCvEdicionR findM4ccbCvEdicionR(M4ccbCvEdicionRPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbCvEdicionR.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4ccbCvEdicionRCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbCvEdicionR> rt = cq.from(M4ccbCvEdicionR.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List <M4ccbCvEdicionR> findM4ccbCvEdicionRByStdIdHr(String idProfesor){
        EntityManager em=getEntityManager();
        try{
            TypedQuery<M4ccbCvEdicionR> q= em.createNamedQuery("M4ccbCvEdicionR.findByStdIdHr", M4ccbCvEdicionR.class);
            q.setParameter("stdIdHr", idProfesor);
            List <M4ccbCvEdicionR> items = q.getResultList();
            return items;
        }catch(NoResultException ex){
            throw ex;
        }finally{
            em.close();
        }
    }
    
}
