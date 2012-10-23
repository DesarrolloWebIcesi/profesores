/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.StdPerson;
import co.edu.icesi.profesores.entities.StdPersonPK;
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
public class StdPersonJpaController implements Serializable {

    public StdPersonJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<StdPerson> findStdPersonEntities() {
        return findStdPersonEntities(true, -1, -1);
    }

    public List<StdPerson> findStdPersonEntities(int maxResults, int firstResult) {
        return findStdPersonEntities(false, maxResults, firstResult);
    }

    private List<StdPerson> findStdPersonEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdPerson.class));
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

    public StdPerson findStdPerson(StdPersonPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdPerson.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdPersonCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdPerson> rt = cq.from(StdPerson.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
     /**
     * TODO: Corregir documentación Looks if there is a registry with the
     * CCB_CARGUE_ACT equals to the activityId parameter.
     *
     * @return An VrrhCursosProf object that represents the database registry.
     *          <code>null</null> otherwise.
     * @param activityId The ActivityInsight is for the activity.
     *
     * @since 2012-09-14 by damanzano
     */
    
    public StdPerson findStdPersonByStdSsn(String profesorCedula) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<StdPerson> q = em.createNamedQuery("StdPerson.findByStdSsn", StdPerson.class);
            q.setParameter("stdSsn", profesorCedula);
            StdPerson person = (StdPerson)q.getSingleResult();
            return person;
        } catch (NoResultException ex) {
            throw ex;
        }catch (NonUniqueResultException ex){
            throw ex;
    }finally {
            em.close();
        }
    }
}
