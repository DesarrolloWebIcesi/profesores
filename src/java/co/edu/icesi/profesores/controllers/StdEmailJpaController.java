/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.StdEmail;
import co.edu.icesi.profesores.entities.StdEmailPK;
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
public class StdEmailJpaController implements Serializable {

    public StdEmailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<StdEmail> findStdEmailEntities() {
        return findStdEmailEntities(true, -1, -1);
    }

    public List<StdEmail> findStdEmailEntities(int maxResults, int firstResult) {
        return findStdEmailEntities(false, maxResults, firstResult);
    }

    private List<StdEmail> findStdEmailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdEmail.class));
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

    public StdEmail findStdEmail(StdEmailPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdEmail.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdEmailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdEmail> rt = cq.from(StdEmail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public StdEmail findEmailPreferidoByStdHrId(String idPerson) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<StdEmail> q = em.createNamedQuery("StdEmail.findByStdIdPersonCcbPreferido", StdEmail.class);
            q.setParameter("stdIdPerson", idPerson);
            q.setParameter("ccbPreferido", "1");
            StdEmail person = (StdEmail) q.getSingleResult();
            return person;
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public StdEmail findInstitutionalEmailByStdHrId(String idPerson) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<StdEmail> q = em.createNamedQuery("StdEmail.findByStdIdPersonStdIdLocatType", StdEmail.class);
            q.setParameter("stdIdPerson", idPerson);
            q.setParameter("stdIdLocatType", "I");
            StdEmail person = (StdEmail) q.getSingleResult();
            return person;
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        } finally {
            em.close();
        }
    }
}
