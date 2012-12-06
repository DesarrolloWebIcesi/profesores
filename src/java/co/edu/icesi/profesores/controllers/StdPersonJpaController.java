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
     * Look for a the person with the document id passed as param.
     * 
     * @return A StdPerson Object representing the person the document id passed as param.
     * @param peopleNetId The PeopleNet identifier for the person.
     * @throws NoResultException if there is any registry tha match the param
     *         NonUniqueResultException if there are more than one registry.
     * @since 2012-12-05 damanzano
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
    
    /** 
     * Look for a the person with the PeopleNet id passed as param.
     * 
     * @return A StdPerson Object representing the person with peoplenet's id passed as param.
     * @param peopleNetId The PeopleNet identifier for the person.
     * @throws NoResultException if there is any registry tha match the param
     *         NonUniqueResultException if there are more than one registry.
     * @since 2012-12-05 damanzano
     */
    public StdPerson findStdPersonByStdIdPerson(String peopleNetId) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<StdPerson> q = em.createNamedQuery("StdPerson.findByStdIdPerson", StdPerson.class);
            q.setParameter("stdIdPerson", peopleNetId);
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
