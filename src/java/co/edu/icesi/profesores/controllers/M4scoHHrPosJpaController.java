/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.M4scoHHrPos;
import co.edu.icesi.profesores.entities.M4scoHHrPosPK;
import java.io.Serializable;
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
public class M4scoHHrPosJpaController implements Serializable {

    public M4scoHHrPosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<M4scoHHrPos> findM4scoHHrPosEntities() {
        return findM4scoHHrPosEntities(true, -1, -1);
    }

    public List<M4scoHHrPos> findM4scoHHrPosEntities(int maxResults, int firstResult) {
        return findM4scoHHrPosEntities(false, maxResults, firstResult);
    }

    private List<M4scoHHrPos> findM4scoHHrPosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4scoHHrPos.class));
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

    public M4scoHHrPos findM4scoHHrPos(M4scoHHrPosPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4scoHHrPos.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4scoHHrPosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4scoHHrPos> rt = cq.from(M4scoHHrPos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<M4scoHHrPos> findPersonPositionByScoIdHr(String idPerson) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<M4scoHHrPos> q = em.createNamedQuery("M4scoHHrPos.findByScoIdHr", M4scoHHrPos.class);
            q.setParameter("scoIdHr", idPerson);
            List<M4scoHHrPos> personPositions =  q.getResultList();
            return personPositions;
        } catch (NoResultException ex) {
            throw ex;
        } catch (NonUniqueResultException ex) {
            throw ex;
        } finally {
            em.close();
        }
    }
}
