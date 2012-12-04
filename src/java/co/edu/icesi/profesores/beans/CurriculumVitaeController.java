/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.beans;

import co.edu.icesi.profesores.controllers.*;
import co.edu.icesi.profesores.entities.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

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
    private String professorWebId;
    private boolean photoImageExist;
 
    /**
     * Creates a new instance of CurriculumVitaeController
     */
    public CurriculumVitaeController() {
        professorWebId = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("professorWebId");
        if (professorWebId == null || professorWebId.equalsIgnoreCase("")) {
            /**
             * TODO: redirect to error page
             */
            loadProfessorData("94378897");
        } else {
            /**
             * TODO: professorWebId tendrá valores como jcalonso, rcastro,
             * damanzano estos valores debe reemplzarse por la cédula puesto que
             * ese es el id que se puede utilizar ante peoplenet
             */
            loadProfessorData(professorWebId);
            //loadProfessorData("94378897");
        }

    }

    public CurriculumVitaeController(String profesorId) {
        loadProfessorData(profesorId);
    }

    private void loadProfessorData(String profesorId) {
        /**
         * Declare and initialize the controllers
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("profesoresPU");
        StdPersonJpaController personController = new StdPersonJpaController(emf);
        M4scoHHrPosJpaController personPositionController = new M4scoHHrPosJpaController(emf);
        M4scoPositionJpaController positionController = new M4scoPositionJpaController(emf);
        StdEmailJpaController emailController = new StdEmailJpaController(emf);
        StdHrAcadBackgrJpaController acadController = new StdHrAcadBackgrJpaController(emf);
        VrrhCursosProfJpaController coursesPreController = new VrrhCursosProfJpaController(emf);
        VrrhProCursoAsJpaController coursesPosController = new VrrhProCursoAsJpaController(emf);

        /**
         * The following controllers that manage the publications issues, so
         * they are not necesary for the first iteration.
         */
//        M4ccbCvArtPubJpaController journalArticlesController = new M4ccbCvArtPubJpaController(emf);
//        M4ccbCvCapLibJpaController bookChpaterController =new M4ccbCvCapLibJpaController(emf);
//        M4ccbCvDlloMatJpaController didacticMaterialController = new M4ccbCvDlloMatJpaController(emf);
//        M4ccbCvDocTrabJpaController workingPapersController = new M4ccbCvDocTrabJpaController(emf);
//        M4ccbCvEdicionRJpaController revisionsController= new M4ccbCvEdicionRJpaController(emf);
//        M4ccbCvLibroJpaController booksController = new M4ccbCvLibroJpaController(emf);
//        M4ccbCvPrefEpilJpaController epilogesController = new M4ccbCvPrefEpilJpaController(emf);
//        M4ccbCvSoftRegJpaController registeredSoftwareController = new M4ccbCvSoftRegJpaController(emf);
//        M4ccbCvTrabTecnJpaController technicalWorksController = new M4ccbCvTrabTecnJpaController(emf);
//        StdHrLangTransJpaController translationsController = new StdHrLangTransJpaController(emf);
//        M4ccbCvPresentacJpaController presentationController = new M4ccbCvPresentacJpaController(emf);
        /*Fin declaraciones controladoras*/
        this.person = personController.findStdPersonByStdSsn(profesorId);
        String stdIdPerson = person.getStdPersonPK().getStdIdPerson();
        this.positionperson = personPositionController.findPersonPositionByStdSsn(stdIdPerson);
        this.position = positionController.findPositionById(positionperson.getScoIdPosition());
        this.personmail = emailController.findInstitutionalEmailByStdHrId(stdIdPerson);
        generateEmailImage();
        //this.stdHrAcadBackgr = acadController.findStdHrAcadBackgrByStdHrId(stdIdPerson);

        this.vrrhCursosProfCurrent = coursesPreController.findVrrhCursosProfByProfesorPeriodCurrent(profesorId);
        this.vrrhProCursoAsCurrent = coursesPosController.findVrrhCursosProfByProfesorPeriodCurrent(profesorId);
        this.coursesPreHis = coursesPreController.findVrrhCursosProfByProfesorPeriodHist(profesorId);
        this.coursesPosHis = coursesPosController.findVrrhCursosProfByProfesorPeriodHist(profesorId);

        /**
         * The following lines manage the publications issues, so they are not
         * necesary for the first iteration.
         */
//        this.bookChapters=bookChpaterController.findM4ccbCvCapLibByStdIdHr(stdIdPerson);
//        this.books=booksController.findM4ccbCvLibroByStdIdHr(stdIdPerson);
//        this.didacticMaterial=didacticMaterialController.findM4ccbCvDlloMatByStdIdHr(stdIdPerson);
//        this.epiloges=epilogesController.findM4ccbCvPrefEpilByStdIdHr(stdIdPerson);
//        this.journalArticles=journalArticlesController.findM4ccbCvArtPubfindByStdIdHr(stdIdPerson);
//        this.registeredSoftware=registeredSoftwareController.findM4ccbCvSoftRegByStdIdHr(stdIdPerson);
//        this.revisions=revisionsController.findM4ccbCvEdicionRByStdIdHr(stdIdPerson);
//        this.technicalWorks=technicalWorksController.findM4ccbCvTrabTecnByStdIdHr(stdIdPerson);
//        this.translations=translationsController.findStdHrLangTransByStdIdHr(stdIdPerson);
//        this.workingPapers=workingPapersController.findM4ccbCvDocTrabByStdIdHr(stdIdPerson);
//        this.presentations = presentationController.findM4ccbCvPresentationByStdIdHr(stdIdPerson);
    }

    public StdPerson getPerson() {
        return person;
    }

    public M4scoHHrPos getPositionperson() {
        return positionperson;
    }

    public M4scoPosition getPosition() {
        return position;
    }

    public StdEmail getPersonmail() {
        return personmail;
    }

    public List<StdHrAcadBackgr> getStdHrAcadBackgr() {
        return stdHrAcadBackgr;
    }

    public List<VrrhCursosProf> getVrrhCursosProfCurrent() {
        return vrrhCursosProfCurrent;
    }

    public List<VrrhProCursoAs> getVrrhProCursoAsCurrent() {
        return vrrhProCursoAsCurrent;
    }

    public List<VrrhCursosProf> getCoursesPreHis() {
        return coursesPreHis;
    }

    public List<VrrhProCursoAs> getCoursesPosHis() {
        return coursesPosHis;
    }

    public List<M4ccbCvArtPub> getJournalArticles() {
        return journalArticles;
    }

    public List<M4ccbCvCapLib> getBookChapters() {
        return bookChapters;
    }

    public List<M4ccbCvDlloMat> getDidacticMaterial() {
        return didacticMaterial;
    }

    public List<M4ccbCvDocTrab> getWorkingPapers() {
        return workingPapers;
    }

    public List<M4ccbCvEdicionR> getRevisions() {
        return revisions;
    }

    public List<M4ccbCvLibro> getBooks() {
        return books;
    }

    public List<M4ccbCvPrefEpil> getEpiloges() {
        return epiloges;
    }

    public List<M4ccbCvSoftReg> getRegisteredSoftware() {
        return registeredSoftware;
    }

    public List<M4ccbCvTrabTecn> getTechnicalWorks() {
        return technicalWorks;
    }

    public List<StdHrLangTrans> getTranslations() {
        return translations;
    }

    public List<M4ccbCvPresentac> getPresentations() {
        return presentations;
    }

    public String getProfessorWebId() {
        return professorWebId;
    }

    /**
     * Generates the professor's email image representatation.
     */
    public void generateEmailImage() {
        try {
            String rootDeploymentPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
            String mailImagePath = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("mailImagePath");
            File f = new File(rootDeploymentPath + mailImagePath + this.person.getStdPersonPK().getStdIdPerson() + ".png");

            /**
             * TODO: Ensure there is a fallback for people without a difened email
             */
            
            BufferedImage img = new BufferedImage(600, 20,
                    BufferedImage.TRANSLUCENT);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(new Color(255, 255, 255, 0));
            g2d.fill(new Rectangle(600, 20));
            g2d.setColor(new Color(51, 102, 153, 255));
            g2d.setFont(new Font("Verdana", Font.PLAIN, 10));
            g2d.drawString(this.personmail.getStdEmail(), 15, 15);
            g2d.dispose();
            ImageIO.write(img, "png", f);
            /*}*/
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    /**
     * This method verify wheather the user's photo file exist in PeopleNet
     * photo repository
     */
    public boolean isPhotoImageExist() {
        String URLName=FacesContext.getCurrentInstance().getExternalContext()
                .getInitParameter("photoImagePath")+"/"+this.person.getStdPersonPK().getStdIdPerson()+".jpg";
        try {
            HttpURLConnection.setFollowRedirects(false);
            // note : you may also need
            //        HttpURLConnection.setInstanceFollowRedirects(false)
            HttpURLConnection con =
                    (HttpURLConnection) new URL(URLName).openConnection();
            con.setRequestMethod("HEAD");
            this.photoImageExist=(con.getResponseCode() == HttpURLConnection.HTTP_OK);
            return this.photoImageExist;
        } catch (Exception e) {
            e.printStackTrace();
            this.photoImageExist=false;
            return this.photoImageExist;
        }
    }
}
