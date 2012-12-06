/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.StdLuWuType;
import co.edu.icesi.profesores.entities.StdLuWuTypePK;
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
public class StdLuWuTypeJpaController implements Serializable {

    public StdLuWuTypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StdLuWuType stdLuWuType) throws PreexistingEntityException, Exception {
        if (stdLuWuType.getStdLuWuTypePK() == null) {
            stdLuWuType.setStdLuWuTypePK(new StdLuWuTypePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stdLuWuType);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStdLuWuType(stdLuWuType.getStdLuWuTypePK()) != null) {
                throw new PreexistingEntityException("StdLuWuType " + stdLuWuType + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StdLuWuType stdLuWuType) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stdLuWuType = em.merge(stdLuWuType);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StdLuWuTypePK id = stdLuWuType.getStdLuWuTypePK();
                if (findStdLuWuType(id) == null) {
                    throw new NonexistentEntityException("The stdLuWuType with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StdLuWuTypePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StdLuWuType stdLuWuType;
            try {
                stdLuWuType = em.getReference(StdLuWuType.class, id);
                stdLuWuType.getStdLuWuTypePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stdLuWuType with id " + id + " no longer exists.", enfe);
            }
            em.remove(stdLuWuType);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StdLuWuType> findStdLuWuTypeEntities() {
        return findStdLuWuTypeEntities(true, -1, -1);
    }

    public List<StdLuWuType> findStdLuWuTypeEntities(int maxResults, int firstResult) {
        return findStdLuWuTypeEntities(false, maxResults, firstResult);
    }

    private List<StdLuWuType> findStdLuWuTypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StdLuWuType.class));
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

    public StdLuWuType findStdLuWuType(StdLuWuTypePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StdLuWuType.class, id);
        } finally {
            em.close();
        }
    }

    public int getStdLuWuTypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StdLuWuType> rt = cq.from(StdLuWuType.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
