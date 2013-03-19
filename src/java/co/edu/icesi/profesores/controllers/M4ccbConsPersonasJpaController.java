/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.M4ccbConsPersonas;
import co.edu.icesi.profesores.entities.M4ccbConsPersonasPK;
import co.edu.icesi.profesores.entities.StdHrAcadBackgr;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 1130619373
 */
public class M4ccbConsPersonasJpaController implements Serializable {

    public M4ccbConsPersonasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<M4ccbConsPersonas> findM4ccbConsPersonasEntities() {
        return findM4ccbConsPersonasEntities(true, -1, -1);
    }

    public List<M4ccbConsPersonas> findM4ccbConsPersonasEntities(int maxResults, int firstResult) {
        return findM4ccbConsPersonasEntities(false, maxResults, firstResult);
    }

    private List<M4ccbConsPersonas> findM4ccbConsPersonasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4ccbConsPersonas.class));
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

    public M4ccbConsPersonas findM4ccbConsPersonas(M4ccbConsPersonasPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4ccbConsPersonas.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Find the constants registry for a given web id param
     *
     * @param professorWebId The web identifier for a professor.
     *
     * @since 2012-12-06 by damanzano Created;
     * 
     * @since 2013-03-07 by damanzano The query was changed to retrieve the
     * person with the professorWebId param that has not ended yet. Otherwise
     * the query could retrieve several records for a professorWebId.
     */
    public M4ccbConsPersonas findM4ccbConsPersonasByCcbIdWeb(String professorWebId) {
        EntityManager em = getEntityManager();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(4000, 0, 1);
            Date worldEnd = calendar.getTime();

            TypedQuery<M4ccbConsPersonas> q = em.createNamedQuery("M4ccbConsPersonas.findByCcbIdWebCcbDtEnd", M4ccbConsPersonas.class);
            q.setParameter("ccbIdWeb", professorWebId);
            q.setParameter("ccbDtEnd", worldEnd);
            M4ccbConsPersonas personConstants = q.getSingleResult();
            return personConstants;
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        } finally {
            em.close();
        }
    }

    public int getM4ccbConsPersonasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4ccbConsPersonas> rt = cq.from(M4ccbConsPersonas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    /**
     * Find the current constans registry for a person identifyed by the
     * stdIdPerson param.
     */
    public M4ccbConsPersonas findCurrentConstantsByStdId(String stdIdPerson) {
        EntityManager em = getEntityManager();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(4000, 0, 1);
            Date worldEnd = calendar.getTime();
            
            TypedQuery<M4ccbConsPersonas> q = em.createNamedQuery("M4ccbConsPersonas.findByCcbIdPersonCcbDtEnd", M4ccbConsPersonas.class);
            q.setParameter("ccbIdPerson", stdIdPerson);
            q.setParameter("ccbDtEnd", worldEnd);
            M4ccbConsPersonas personConstants = q.getSingleResult();
            return personConstants;
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        } finally {
            em.close();
        }
    }
}
