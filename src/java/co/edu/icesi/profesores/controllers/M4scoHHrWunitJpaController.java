/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.M4scoHHrWunit;
import co.edu.icesi.profesores.entities.M4scoHHrWunitPK;
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
public class M4scoHHrWunitJpaController implements Serializable {

    public M4scoHHrWunitJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(M4scoHHrWunit m4scoHHrWunit) throws PreexistingEntityException, Exception {
        if (m4scoHHrWunit.getM4scoHHrWunitPK() == null) {
            m4scoHHrWunit.setM4scoHHrWunitPK(new M4scoHHrWunitPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(m4scoHHrWunit);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findM4scoHHrWunit(m4scoHHrWunit.getM4scoHHrWunitPK()) != null) {
                throw new PreexistingEntityException("M4scoHHrWunit " + m4scoHHrWunit + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(M4scoHHrWunit m4scoHHrWunit) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            m4scoHHrWunit = em.merge(m4scoHHrWunit);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                M4scoHHrWunitPK id = m4scoHHrWunit.getM4scoHHrWunitPK();
                if (findM4scoHHrWunit(id) == null) {
                    throw new NonexistentEntityException("The m4scoHHrWunit with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(M4scoHHrWunitPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            M4scoHHrWunit m4scoHHrWunit;
            try {
                m4scoHHrWunit = em.getReference(M4scoHHrWunit.class, id);
                m4scoHHrWunit.getM4scoHHrWunitPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The m4scoHHrWunit with id " + id + " no longer exists.", enfe);
            }
            em.remove(m4scoHHrWunit);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<M4scoHHrWunit> findM4scoHHrWunitEntities() {
        return findM4scoHHrWunitEntities(true, -1, -1);
    }

    public List<M4scoHHrWunit> findM4scoHHrWunitEntities(int maxResults, int firstResult) {
        return findM4scoHHrWunitEntities(false, maxResults, firstResult);
    }

    private List<M4scoHHrWunit> findM4scoHHrWunitEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(M4scoHHrWunit.class));
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

    public M4scoHHrWunit findM4scoHHrWunit(M4scoHHrWunitPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(M4scoHHrWunit.class, id);
        } finally {
            em.close();
        }
    }

    public int getM4scoHHrWunitCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<M4scoHHrWunit> rt = cq.from(M4scoHHrWunit.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
