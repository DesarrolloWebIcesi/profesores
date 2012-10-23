/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.VrrhCursosProf;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author 1130619373
 */
public class VrrhCursosProfJpaController implements Serializable {

    public VrrhCursosProfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<VrrhCursosProf> findVrrhCursosProfEntities() {
        return findVrrhCursosProfEntities(true, -1, -1);
    }

    private List<VrrhCursosProf> findVrrhCursosProfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VrrhCursosProf.class));
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
    public List<VrrhCursosProf> findVrrhCursosProfByProfesorCedula(String profesorCedula) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<VrrhCursosProf> q = em.createNamedQuery("VrrhCursosProf.findByProfesorCedula", VrrhCursosProf.class);
            q.setParameter("profesorCedula", profesorCedula);
            List<VrrhCursosProf> courses = q.getResultList();
            return courses;
        } catch (NoResultException ex) {
            throw ex;
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
    public List<VrrhCursosProf> findVrrhCursosProfByProfesorPeriod(String profesorCedula, String periodoAcad, int periodoConsecutivo) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<VrrhCursosProf> q = em.createNamedQuery("VrrhCursosProf.findByProfesorPeriod", VrrhCursosProf.class);
            q.setParameter("profesorCedula", profesorCedula);
            q.setParameter("periodoAcad", periodoAcad);
            q.setParameter("periodoConsecutivo", periodoConsecutivo);
            List<VrrhCursosProf> courses = q.getResultList();
            return courses;
        } catch (NoResultException ex) {
            throw ex;
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
    public List<VrrhCursosProf> findVrrhCursosProfByProfesorPeriodCurrent(String profesorCedula) {
        Calendar calendar = new GregorianCalendar();
        String periodoAcad = ((Integer) (calendar.get(Calendar.YEAR))).toString().substring(2, 4);
        int periodoConsecutivo = 0;
        int month = calendar.get(Calendar.MONTH);
        if (month < 5) {
            periodoAcad += "1";
            periodoConsecutivo = 1;
        } else if (month < 7) {
            periodoAcad += "1";
            periodoConsecutivo = 2;
        } else {
            periodoAcad += "2";
            periodoConsecutivo = 2;
        }

        return findVrrhCursosProfByProfesorPeriod(profesorCedula, periodoAcad, periodoConsecutivo);
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
    public List<VrrhCursosProf> findVrrhCursosProfByProfesorPeriodHist(String profesorCedula) {
        EntityManager em = getEntityManager();
        try {
            Calendar calendar = new GregorianCalendar();
            String periodoAcad = ((Integer) (calendar.get(Calendar.YEAR))).toString().substring(2, 4);
            int periodoConsecutivo = 0;
            int month = calendar.get(Calendar.MONTH);
            if (month < 5) {
                periodoAcad += "1";
                periodoConsecutivo = 1;
            } else if (month < 7) {
                periodoAcad += "1";
                periodoConsecutivo = 2;
            } else {
                periodoAcad += "2";
                periodoConsecutivo = 2;
            }
            TypedQuery<VrrhCursosProf> q = em.createNamedQuery("VrrhCursosProf.findByProfesorPeriodHist", VrrhCursosProf.class);
            q.setParameter("profesorCedula", profesorCedula);
            q.setParameter("periodoAcad", periodoAcad);
            q.setParameter("periodoConsecutivo", periodoConsecutivo);
            
            System.out.println(q.toString());
            System.out.println(q.getParameters().toString());
            List<VrrhCursosProf> courses = q.getResultList();
            return courses;
        } catch (NoResultException ex) {
            throw ex;
        } finally {
            em.close();
        }
    }
}
