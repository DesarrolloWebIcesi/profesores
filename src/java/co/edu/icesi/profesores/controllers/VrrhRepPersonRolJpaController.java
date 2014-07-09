/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.controllers.exceptions.NonexistentEntityException;
import co.edu.icesi.profesores.controllers.exceptions.PreexistingEntityException;
import co.edu.icesi.profesores.entities.VrrhRepPersonRol;
import co.edu.icesi.profesores.entities.VrrhRepPersonRolPK;
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
public class VrrhRepPersonRolJpaController implements Serializable {

    public VrrhRepPersonRolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<VrrhRepPersonRol> findVrrhRepPersonRolEntities() {
        return findVrrhRepPersonRolEntities(true, -1, -1);
    }

    public List<VrrhRepPersonRol> findVrrhRepPersonRolEntities(int maxResults, int firstResult) {
        return findVrrhRepPersonRolEntities(false, maxResults, firstResult);
    }

    private List<VrrhRepPersonRol> findVrrhRepPersonRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VrrhRepPersonRol.class));
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

    public VrrhRepPersonRol findVrrhRepPersonRol(VrrhRepPersonRolPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VrrhRepPersonRol.class, id);
        } finally {
            em.close();
        }
    }

    public int getVrrhRepPersonRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VrrhRepPersonRol> rt = cq.from(VrrhRepPersonRol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /**
     * Looks for the roles of the person identified by the stdIdPerson param.
     *
     * @return A List of VrrhRepPersonRol objects that represents the database registries.
     *          
     * @param stdIdPerson The ActivityInsight is for the activity.
     *
     * @since 2012-12-10 by damanzano created
     */
    public List<VrrhRepPersonRol> findVrrhRepPersonRolByStdIdPerson(String stdIdPerson) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<VrrhRepPersonRol> q = em.createNamedQuery("VrrhRepPersonRol.findByStdIdPerson", VrrhRepPersonRol.class);
            q.setParameter("stdIdPerson", stdIdPerson);
            List<VrrhRepPersonRol> roles = q.getResultList();
            return roles;
        } catch (NoResultException ex) {
            throw ex;
        } finally {
            em.close();
        }
    }
    
}
