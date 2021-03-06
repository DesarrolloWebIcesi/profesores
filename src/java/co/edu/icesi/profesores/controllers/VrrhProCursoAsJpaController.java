/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.controllers;

import co.edu.icesi.profesores.entities.VrrhProCursoAs;
import co.edu.icesi.profesores.entities.VrrhProCursoAsPK;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author 14620701
 */
public class VrrhProCursoAsJpaController implements Serializable {

    public VrrhProCursoAsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<VrrhProCursoAs> findVrrhProCursoAsEntities() {
        return findVrrhProCursoAsEntities(true, -1, -1);
    }

    public List<VrrhProCursoAs> findVrrhProCursoAsEntities(int maxResults, int firstResult) {
        return findVrrhProCursoAsEntities(false, maxResults, firstResult);
    }

    private List<VrrhProCursoAs> findVrrhProCursoAsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VrrhProCursoAs.class));
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

    public VrrhProCursoAs findVrrhProCursoAs(VrrhProCursoAsPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VrrhProCursoAs.class, id);
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
     * @param profesorCedula  The professor's identifier.
     *
     * @since 2012-09-14 by damanzano
     */
    public List<VrrhProCursoAs> findVrrhCursosProfByProfesorCedula(String profesorCedula) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<VrrhProCursoAs> q = em.createNamedQuery("VrrhProCursoAs.findByProfesorCedula", VrrhProCursoAs.class);
            q.setParameter("profesorCedula", profesorCedula);
            List<VrrhProCursoAs> courses = q.getResultList();
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
     * @param profesorCedula  The professor's identifier.
     * @param periodoAcad The academic period.
     * @param periodoConsecutivo The consecutive period.
     *
     * @since 2012-09-14 by damanzano
     */
    public List<VrrhProCursoAs> findVrrhCursosProfByProfesorPeriod(String profesorCedula, String periodoAcad, int periodoConsecutivo) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<VrrhProCursoAs> q = em.createNamedQuery("VrrhProCursoAs.findByProfesorPeriod", VrrhProCursoAs.class);
            q.setParameter("profesorCedula", profesorCedula);
            q.setParameter("periodoAcad", periodoAcad);
            q.setParameter("periodoConsecutivo", periodoConsecutivo);
            List<VrrhProCursoAs> courses = q.getResultList();
            List<VrrhProCursoAs> filteredCourses = new ArrayList<VrrhProCursoAs>();
            String nombre = null;
            
            for (int i=0;i<courses.size();i++){
                nombre = courses.get(i).getNombreMateria();
                boolean exist=false;
                for(int j=0;j<filteredCourses.size();j++){
                    if (nombre.equalsIgnoreCase(filteredCourses.get(j).getNombreMateria())){
                        exist=true;
                        break;
                    }
                }
                if(!exist){
                    filteredCourses.add(courses.get(i));
                }
            }
            
            return filteredCourses;
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
     * @param profesorCedula The professor's identifier.
     *
     * @since 2012-09-14 by damanzano
     */
    public List<VrrhProCursoAs> findVrrhCursosProfByProfesorPeriodCurrent(String profesorCedula) {
        Calendar calendar = new GregorianCalendar();
        String periodoAcad = ((Integer) (calendar.get(Calendar.YEAR))).toString().substring(2, 4);
        int periodoConsecutivo = 0;
        int month = calendar.get(Calendar.MONTH);
        if (month < 3) {
            periodoAcad += "1";

        } else if (month < 6) {
            periodoAcad += "2";

        } else if (month < 9) {
            periodoAcad += "3";

        } else {
            periodoAcad += "4";

        }

        return findVrrhCursosProfByProfesorPeriod(profesorCedula, periodoAcad, periodoConsecutivo);
    }

    /**
     * TODO: Corregir documentación Looks if there is a registry with the
     * CCB_CARGUE_ACT equals to the activityId parameter.
     *
     * @return An VrrhCursosProf object that represents the database registry.
     *          <code>null</null> otherwise.
     * @param profesorCedula The professor's identifier.
     *
     * @since 2012-09-14 by damanzano
     * @since 2013-01-29 by damanzano
     * The way courses with the same name are filtered was replaced and rewritten because the aproach used befored
     * was wrong and allowed repeated items.
     */
    public List<VrrhProCursoAs> findVrrhCursosProfByProfesorPeriodHist(String profesorCedula) {
        EntityManager em = getEntityManager();
        try {
            Calendar calendar = new GregorianCalendar();
            String periodoAcad = ((Integer) (calendar.get(Calendar.YEAR))).toString().substring(2, 4);
            int periodoConsecutivo = 0;
            int month = calendar.get(Calendar.MONTH);
            if (month < 3) {
                periodoAcad += "1";

            } else if (month < 6) {
                periodoAcad += "2";

            } else if (month < 9) {
                periodoAcad += "3";

            } else {
                periodoAcad += "4";

            }
            TypedQuery<VrrhProCursoAs> q = em.createNamedQuery("VrrhProCursoAs.findByProfesorPeriodHist", VrrhProCursoAs.class);
            q.setParameter("profesorCedula", profesorCedula);
            q.setParameter("periodoAcad", periodoAcad);
            /*q.setParameter("periodoConsecutivo", periodoConsecutivo);*/

            List<VrrhProCursoAs> courses = q.getResultList(); 
            List<VrrhProCursoAs> filteredCourses = new ArrayList<VrrhProCursoAs>();
            String nombre = null;
            
            for (int i=0;i<courses.size();i++){
                nombre = courses.get(i).getNombreMateria();
                boolean exist=false;
                for(int j=0;j<filteredCourses.size();j++){
                    if (nombre.equalsIgnoreCase(filteredCourses.get(j).getNombreMateria())){
                        exist=true;
                        break;
                    }
                }
                if(!exist){
                    filteredCourses.add(courses.get(i));
                }
            }
           
//            for (int i=0;i<courses.size();i++){
//                nombre = courses.get(i).getNombreMateria();
//                for(int c=i+1;c<courses.size();c++){
//                    if (nombre.equalsIgnoreCase(courses.get(c).getNombreMateria())){
//                        courses.remove(c);
//                    }
//                }
//            }
            
            return filteredCourses;
        } catch (NoResultException ex) {
            throw ex;
        } catch (NumberFormatException ex){
            throw ex;
        }
        finally {
            em.close();
        }
    }
}
