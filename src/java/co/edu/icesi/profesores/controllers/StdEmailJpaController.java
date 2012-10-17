/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.StdEmail;
import co.edu.icesi.profesores.entities.StdEmailPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
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

    public void create(StdEmail stdEmail) throws PreexistingEntityException, Exception {
        if (stdEmail.getStdEmailPK() == null) {
            stdEmail.setStdEmailPK(new StdEmailPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdEmail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdEmail(stdEmail.getStdEmailPK()) != null) {
                throw new PreexistingEntityException("StdEmail " + stdEmail + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdEmail stdEmail) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdEmail = em.merge(stdEmail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdEmailPK id = stdEmail.getStdEmailPK();
                if (findStdEmail(id) == null) {
                    throw new NonexistentEntityException("The stdEmail with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdEmailPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdEmail stdEmail;
            try {
                stdEmail = em.getReference(StdEmail.class, id);
                stdEmail.getStdEmailPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdEmail with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdEmail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
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
    
}
