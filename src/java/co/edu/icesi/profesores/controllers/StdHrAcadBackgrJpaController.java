/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.StdHrAcadBackgr;
import co.edu.icesi.profesores.entities.StdHrAcadBackgrPK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 1130619373
 */
public class StdHrAcadBackgrJpaController implements Serializable {

    public StdHrAcadBackgrJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<StdHrAcadBackgr> findStdHrAcadBackgrEntities() {
        return findStdHrAcadBackgrEntities(true, -1, -1);
    }

    public List<StdHrAcadBackgr> findStdHrAcadBackgrEntities(int maxResults, int firstResult) {
        return findStdHrAcadBackgrEntities(false, maxResults, firstResult);
    }

    private List<StdHrAcadBackgr> findStdHrAcadBackgrEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdHrAcadBackgr.class));
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

    public StdHrAcadBackgr findStdHrAcadBackgr(StdHrAcadBackgrPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdHrAcadBackgr.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdHrAcadBackgrCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdHrAcadBackgr> rt = cq.from(StdHrAcadBackgr.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<StdHrAcadBackgr> findEmailPreferidoByStdHrId(String idPerson) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<StdHrAcadBackgr> q = em.createNamedQuery("StdHrAcadBackgr.findByStdIdHr", StdHrAcadBackgr.class);
            q.setParameter("stdIdHr", idPerson);
            List<StdHrAcadBackgr> acadBackgr = q.getResultList();
             List<StdHrAcadBackgr> temp = new ArrayList<StdHrAcadBackgr>();
            for (int I=(acadBackgr.size()-1);I>=0;I--){
                temp.add(acadBackgr.get(I));
            }
            acadBackgr = temp;
            return acadBackgr;
        } catch (NoResultException ex) {
           return null;
        }catch (NonUniqueResultException ex){
            return null;
    }finally {
            em.close();
        }
    }
}
