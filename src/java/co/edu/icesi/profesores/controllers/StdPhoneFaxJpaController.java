/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.StdPhoneFax;
import co.edu.icesi.profesores.entities.StdPhoneFaxPK;
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
public class StdPhoneFaxJpaController implements Serializable {

    public StdPhoneFaxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StdPhoneFax stdPhoneFax) throws PreexistingEntityException, Exception {
        if (stdPhoneFax.getStdPhoneFaxPK() == null) {
            stdPhoneFax.setStdPhoneFaxPK(new StdPhoneFaxPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdPhoneFax);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdPhoneFax(stdPhoneFax.getStdPhoneFaxPK()) != null) {
                throw new PreexistingEntityException("StdPhoneFax " + stdPhoneFax + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdPhoneFax stdPhoneFax) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdPhoneFax = em.merge(stdPhoneFax);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdPhoneFaxPK id = stdPhoneFax.getStdPhoneFaxPK();
                if (findStdPhoneFax(id) == null) {
                    throw new NonexistentEntityException("The stdPhoneFax with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdPhoneFaxPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdPhoneFax stdPhoneFax;
            try {
                stdPhoneFax = em.getReference(StdPhoneFax.class, id);
                stdPhoneFax.getStdPhoneFaxPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdPhoneFax with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdPhoneFax);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StdPhoneFax> findStdPhoneFaxEntities() {
        return findStdPhoneFaxEntities(true, -1, -1);
    }

    public List<StdPhoneFax> findStdPhoneFaxEntities(int maxResults, int firstResult) {
        return findStdPhoneFaxEntities(false, maxResults, firstResult);
    }

    private List<StdPhoneFax> findStdPhoneFaxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdPhoneFax.class));
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

    public StdPhoneFax findStdPhoneFax(StdPhoneFaxPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdPhoneFax.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdPhoneFaxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdPhoneFax> rt = cq.from(StdPhoneFax.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /**
     * Looks a institutional extention for the person identified by the stdIdPerson param.
     *
     * @return  The first extention found if the person has at least an extentions
     *          <code>null</code> if any extention is found for the person.
     *          
     * @param stdIdPerson The ActivityInsight is for the activity.
     *
     * @since 2012-12-11 by damanzano Created
     */
    public StdPhoneFax findInstitutionalPhoneByStdIdPerson(String stdIdPerson) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<StdPhoneFax> q = em.createNamedQuery("StdPhoneFax.findInstitutionalPhoneByStdIdPerson", StdPhoneFax.class);
            q.setParameter("stdIdPerson", stdIdPerson);
            List<StdPhoneFax> phones = q.getResultList();
            if(phones!=null && !phones.isEmpty()){
                return phones.get(0);
            }
            return null;
        } catch (NoResultException ex) {
            throw ex;
        } finally {
            em.close();
        }
    }
    
}
