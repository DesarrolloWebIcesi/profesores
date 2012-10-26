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
    private M4scoHHrPos positionperson;
    private M4scoPosition position;
    private StdEmail personmail;
    private List<StdHrAcadBackgr> stdHrAcadBackgr;
    private List<VrrhCursosProf> vrrhCursosProfCurrent;
    private List<VrrhProCursoAs> vrrhProCursoAsCurrent;
    private List<VrrhCursosProf> coursesPreHis;
    private List<VrrhProCursoAs> coursesPosHis;
    private List<M4ccbCvArtPub> journalArticles;
    private List<M4ccbCvCapLib> bookChapters;
    private List<M4ccbCvDlloMat> didacticMaterial;
    private List<M4ccbCvDocTrab> workingPapers;
    private List<M4ccbCvEdicionR> revisions;
    private List<M4ccbCvLibro> books;
    private List<M4ccbCvPrefEpil> epiloges;
    private List<M4ccbCvSoftReg> registeredSoftware;
    private List<M4ccbCvTrabTecn> technicalWorks;
    private List<StdHrLangTrans> translations;
    private List<M4ccbCvPresentac> presentations;
    
    /**
     * Creates a new instance of CurriculumVitaeController
     */
    public CurriculumVitaeController() {
        loadProfessorData("94378897");
    }

    public CurriculumVitaeController(String profesorId) {
        loadProfessorData(profesorId);
    }

    private void loadProfessorData(String profesorId) {
        /**
         * Declaraciones de las controladoras
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("profesoresPU");
        StdPersonJpaController personController = new StdPersonJpaController(emf);        
        M4scoHHrPosJpaController personPositionController = new M4scoHHrPosJpaController(emf);
        M4scoPositionJpaController positionController = new M4scoPositionJpaController(emf);
        StdEmailJpaController emailController = new StdEmailJpaController(emf);
        StdHrAcadBackgrJpaController acadController = new StdHrAcadBackgrJpaController(emf);
        VrrhCursosProfJpaController coursesPreController = new VrrhCursosProfJpaController(emf);
        VrrhProCursoAsJpaController coursesPosController = new VrrhProCursoAsJpaController(emf);
        M4ccbCvArtPubJpaController journalArticlesController = new M4ccbCvArtPubJpaController(emf);
        M4ccbCvCapLibJpaController bookChpaterController =new M4ccbCvCapLibJpaController(emf);
        M4ccbCvDlloMatJpaController didacticMaterialController = new M4ccbCvDlloMatJpaController(emf);
        M4ccbCvDocTrabJpaController workingPapersController = new M4ccbCvDocTrabJpaController(emf);
        M4ccbCvEdicionRJpaController revisionsController= new M4ccbCvEdicionRJpaController(emf);
        M4ccbCvLibroJpaController booksController = new M4ccbCvLibroJpaController(emf);
        M4ccbCvPrefEpilJpaController epilogesController = new M4ccbCvPrefEpilJpaController(emf);
        M4ccbCvSoftRegJpaController registeredSoftwareController = new M4ccbCvSoftRegJpaController(emf);
        M4ccbCvTrabTecnJpaController technicalWorksController = new M4ccbCvTrabTecnJpaController(emf);
        StdHrLangTransJpaController translationsController = new StdHrLangTransJpaController(emf);
        M4ccbCvPresentacJpaController presentationController = new M4ccbCvPresentacJpaController(emf);
        /*Fin declaraciones controladoras*/

        this.person = personController.findStdPersonByStdSsn(profesorId);
        String stdIdPerson = person.getStdPersonPK().getStdIdPerson();
        this.positionperson = personPositionController.findPersonPositionByStdSsn(stdIdPerson);
        this.position = positionController.findPositionById(positionperson.getScoIdPosition());        
        this.personmail = emailController.findEmailPreferidoByStdHrId(stdIdPerson);
        this.stdHrAcadBackgr = acadController.findEmailPreferidoByStdHrId(stdIdPerson);

        this.vrrhCursosProfCurrent = coursesPreController.findVrrhCursosProfByProfesorPeriodCurrent(profesorId);
        this.vrrhProCursoAsCurrent = coursesPosController.findVrrhCursosProfByProfesorPeriodCurrent(profesorId);
        this.coursesPreHis = coursesPreController.findVrrhCursosProfByProfesorPeriodHist(profesorId);
        this.coursesPosHis = coursesPosController.findVrrhCursosProfByProfesorPeriodHist(profesorId);
        
        this.bookChapters=bookChpaterController.findM4ccbCvCapLibByStdIdHr(stdIdPerson);
        this.books=booksController.findM4ccbCvLibroByStdIdHr(stdIdPerson);
        this.didacticMaterial=didacticMaterialController.findM4ccbCvDlloMatByStdIdHr(stdIdPerson);
        this.epiloges=epilogesController.findM4ccbCvPrefEpilByStdIdHr(stdIdPerson);
        this.journalArticles=journalArticlesController.findM4ccbCvArtPubfindByStdIdHr(stdIdPerson);
        this.registeredSoftware=registeredSoftwareController.findM4ccbCvSoftRegByStdIdHr(stdIdPerson);
        this.revisions=revisionsController.findM4ccbCvEdicionRByStdIdHr(stdIdPerson);
        this.technicalWorks=technicalWorksController.findM4ccbCvTrabTecnByStdIdHr(stdIdPerson);
        this.translations=translationsController.findStdHrLangTransByStdIdHr(stdIdPerson);
        this.workingPapers=workingPapersController.findM4ccbCvDocTrabByStdIdHr(stdIdPerson);
        this.presentations = presentationController.findM4ccbCvPresentationByStdIdHr(stdIdPerson);
        System.out.println(presentations.get(1).getCcbNomPresnt()); 
   }

    public StdPerson getPerson() {
        return person;
    }

    public void setPerson(StdPerson person) {
        this.person = person;
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

    public List<M4ccbCvArtPub> getJournalArticles() {
        return journalArticles;
    }

    public void setJournalArticles(List<M4ccbCvArtPub> journalArticles) {
        this.journalArticles = journalArticles;
    }

    public List<M4ccbCvCapLib> getBookChapters() {
        return bookChapters;
    }

    public void setBookChapters(List<M4ccbCvCapLib> bookChapters) {
        this.bookChapters = bookChapters;
    }

    public List<M4ccbCvDlloMat> getDidacticMaterial() {
        return didacticMaterial;
    }

    public void setDidacticMaterial(List<M4ccbCvDlloMat> didacticMaterial) {
        this.didacticMaterial = didacticMaterial;
    }

    public List<M4ccbCvDocTrab> getWorkingPapers() {
        return workingPapers;
    }

    public void setWorkingPapers(List<M4ccbCvDocTrab> workingPapers) {
        this.workingPapers = workingPapers;
    }

    public List<M4ccbCvEdicionR> getRevisions() {
        return revisions;
    }

    public void setRevisions(List<M4ccbCvEdicionR> revisions) {
        this.revisions = revisions;
    }

    public List<M4ccbCvLibro> getBooks() {
        return books;
    }

    public void setBooks(List<M4ccbCvLibro> books) {
        this.books = books;
    }

    public List<M4ccbCvPrefEpil> getEpiloges() {
        return epiloges;
    }

    public void setEpiloges(List<M4ccbCvPrefEpil> epiloges) {
        this.epiloges = epiloges;
    }

    public List<M4ccbCvSoftReg> getRegisteredSoftware() {
        return registeredSoftware;
    }

    public void setRegisteredSoftware(List<M4ccbCvSoftReg> registeredSoftware) {
        this.registeredSoftware = registeredSoftware;
    }

    public List<M4ccbCvTrabTecn> getTechnicalWorks() {
        return technicalWorks;
    }

    public void setTechnicalWorks(List<M4ccbCvTrabTecn> technicalWorks) {
        this.technicalWorks = technicalWorks;
    }

    public List<StdHrLangTrans> getTranslations() {
        return translations;
    }

    public void setTranslations(List<StdHrLangTrans> translations) {
        this.translations = translations;
    }

    public List<M4ccbCvPresentac> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<M4ccbCvPresentac> presentations) {
        this.presentations = presentations;
    }
    
}
