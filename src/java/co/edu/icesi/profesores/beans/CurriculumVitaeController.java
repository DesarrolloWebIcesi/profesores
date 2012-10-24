/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.beans;

import co.edu.icesi.profesores.controllers.*;
import co.edu.icesi.profesores.entities.*;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

/**
 *
 * @author 14620701
 */
@ManagedBean(name = "curriculumvitae")
@SessionScoped
public class CurriculumVitaeController implements Serializable {

    private StdPerson person;
    private List<M4ccbCvArtPub> m4ccbCvArtPub;
    private M4scoHHrPos positionperson;
    private M4scoPosition position;
    private StdEmail personmail;
    private List<StdHrAcadBackgr> stdHrAcadBackgr;
    private List<VrrhCursosProf> vrrhCursosProfCurrent;
    private List<VrrhProCursoAs> vrrhProCursoAsCurrent;
    private List<VrrhCursosProf> coursesPreHis;
    private List<VrrhProCursoAs> coursesPosHis;
    /*private DataModel m4ccbCvCapLib;
     private DataModel m4ccbCvDlloMat;
     private DataModel m4ccbCvDocTrab;
     private DataModel m4ccbCvEdicionR;
     private DataModel m4ccbCvLibro;
     private DataModel m4ccbCvPrefEpil;*/

    /**
     * Creates a new instance of CurriculumVitaeController
     */
    public CurriculumVitaeController() {
        /* cargar ("94378897");*/
    }

    public CurriculumVitaeController(String profesorId) {
        StdPersonJpaController personController = new StdPersonJpaController(Persistence.createEntityManagerFactory("profesoresPU"));
        M4ccbCvArtPubJpaController articleController = new M4ccbCvArtPubJpaController(Persistence.createEntityManagerFactory("profesoresPU"));
        this.person = personController.findStdPersonByStdSsn(profesorId);
        m4ccbCvArtPub = articleController.findM4ccbCvArtPubfindByStdIdHr(person.getStdPersonPK().getStdIdPerson());
    }

    private void cargar(String profesorId) {
        /**
         * Declaraciones de las controladoras
         */
        EntityManagerFactory entity = Persistence.createEntityManagerFactory("profesoresPU");
        StdPersonJpaController personController = new StdPersonJpaController(entity);
        M4ccbCvArtPubJpaController articleController = new M4ccbCvArtPubJpaController(entity);
        M4scoHHrPosJpaController personPositionController = new M4scoHHrPosJpaController(entity);
        M4scoPositionJpaController positionController = new M4scoPositionJpaController(entity);
        StdEmailJpaController emailController = new StdEmailJpaController(entity);
        StdHrAcadBackgrJpaController acadController = new StdHrAcadBackgrJpaController(entity);
        VrrhCursosProfJpaController coursesPreController = new VrrhCursosProfJpaController(entity);
        VrrhProCursoAsJpaController coursesPosController = new VrrhProCursoAsJpaController(entity);
        /*Fin declaraciones controladoras*/

        this.person = personController.findStdPersonByStdSsn(profesorId);
        String stdIdPerson = person.getStdPersonPK().getStdIdPerson();
        this.positionperson = personPositionController.findPersonPositionByStdSsn(stdIdPerson);
        this.position = positionController.findPositionById(positionperson.getScoIdPosition());
        this.m4ccbCvArtPub = articleController.findM4ccbCvArtPubfindByStdIdHr(stdIdPerson);
        this.personmail = emailController.findEmailPreferidoByStdHrId(stdIdPerson);
        this.stdHrAcadBackgr = acadController.findEmailPreferidoByStdHrId(stdIdPerson);

        this.vrrhCursosProfCurrent = coursesPreController.findVrrhCursosProfByProfesorPeriodCurrent(profesorId);
        this.vrrhProCursoAsCurrent = coursesPosController.findVrrhCursosProfByProfesorPeriodCurrent(profesorId);
        this.coursesPreHis = coursesPreController.findVrrhCursosProfByProfesorPeriodHist(profesorId);
        this.coursesPosHis = coursesPosController.findVrrhCursosProfByProfesorPeriodHist(profesorId);
    }

    public StdPerson getPerson() {
        if (this.person == null) {
            cargar("94378897");
        }
        return person;
    }

    public void setPerson(StdPerson person) {
        this.person = person;
    }

    public List<M4ccbCvArtPub> getM4ccbCvArtPub() {

        return m4ccbCvArtPub;
    }

    public void setM4ccbCvArtPub(List<M4ccbCvArtPub> m4ccbCvArtPub) {
        this.m4ccbCvArtPub = m4ccbCvArtPub;
    }

    public M4scoHHrPos getPositionperson() {
        return positionperson;
    }

    public void setPositionperson(M4scoHHrPos positionperson) {
        this.positionperson = positionperson;
    }

    public M4scoPosition getPosition() {
        return position;
    }

    public void setPosition(M4scoPosition position) {
        this.position = position;
    }

    public StdEmail getPersonmail() {
        return personmail;
    }

    public void setPersonmail(StdEmail personmail) {
        this.personmail = personmail;
    }

    public List<StdHrAcadBackgr> getStdHrAcadBackgr() {
        return stdHrAcadBackgr;
    }

    public void setStdHrAcadBackgr(List<StdHrAcadBackgr> stdHrAcadBackgr) {
        this.stdHrAcadBackgr = stdHrAcadBackgr;
    }

    public List<VrrhCursosProf> getVrrhCursosProfCurrent() {
        return vrrhCursosProfCurrent;
    }

    public void setVrrhCursosProfCurrent(List<VrrhCursosProf> vrrhCursosProfCurrent) {
        this.vrrhCursosProfCurrent = vrrhCursosProfCurrent;
    }

    public List<VrrhProCursoAs> getVrrhProCursoAsCurrent() {
        return vrrhProCursoAsCurrent;
    }

    public void setVrrhProCursoAsCurrent(List<VrrhProCursoAs> vrrhProCursoAsCurrent) {
        this.vrrhProCursoAsCurrent = vrrhProCursoAsCurrent;
    }

    public List<VrrhCursosProf> getCoursesPreHis() {
        return coursesPreHis;
    }

    public void setCoursesPreHis(List<VrrhCursosProf> coursesPreHis) {
        this.coursesPreHis = coursesPreHis;
    }

    public List<VrrhProCursoAs> getCoursesPosHis() {
        return coursesPosHis;
    }

    public void setCoursesPosHis(List<VrrhProCursoAs> coursesPosHis) {
        this.coursesPosHis = coursesPosHis;
    }
    
    
}
