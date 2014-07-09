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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Juan Manuel Lozano Sardi - jlozano
 *
 * @since 2012-12-04 damanzano All the funcionalities not related to the
 * iteration 1 of Hoja de vida Profesores web's project were commented in
 * loadProfessorData() method.
 * @since 2013-04-01 Funcionalities related to iteration 2 of Hoja de vida
 * Profesores web's prject were uncommented.
 */
@ManagedBean(name = "curriculumvitae")
@SessionScoped
public class CurriculumVitaeController implements Serializable {

    private StdPerson person;
    private List<M4scoHHrPos> personPositions;
    private List<M4scoPosition> positionDescriptions;
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
    private List<VrrhRepPersonRol> roles;
    private StdPhoneFax phoneExtention;
    private String professorWebId;
    private boolean photoImageExist;
    private boolean intellContExist;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("profesoresPU");
    private LanguageBean languageBean;

    /**
     * Creates a new instance of CurriculumVitaeController
     */
    public CurriculumVitaeController() {
        professorWebId = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("professorWebId");
        if (professorWebId == null || professorWebId.equalsIgnoreCase("")) {
            try {
                /**
                 * TODO: redirect to error page
                 */
                FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/errors/webid-error");
            } catch (IOException ex) {
                Logger.getLogger(CurriculumVitaeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            String professorId = getPeopleNetId(professorWebId);
            if (professorId == null || professorId.equalsIgnoreCase("")) {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/errors/webid-error");
                } catch (IOException ex) {
                    Logger.getLogger(CurriculumVitaeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                loadProfessorData(professorId);
            }
        }

    }

    public CurriculumVitaeController(String profesorId) {
        loadProfessorData(profesorId);
    }

    private void loadProfessorData(String profesorId) {
        //verify if the person is a professor;
        StdPersonJpaController personController = new StdPersonJpaController(emf);
        this.person = personController.findStdPersonByStdIdPerson(profesorId);
        if (!this.person.getCcbProfesor().equalsIgnoreCase("1")) {
            /**
             * TODO: redirect to error page
             */
        } else {
            /**
             * Declare and initialize the controllers
             */
            M4scoHHrPosJpaController personPositionController = new M4scoHHrPosJpaController(emf);
            M4scoPositionJpaController positionDescriptionsController = new M4scoPositionJpaController(emf);
            VrrhRepPersonRolJpaController rolesController = new VrrhRepPersonRolJpaController(emf);
            StdEmailJpaController emailController = new StdEmailJpaController(emf);
            StdPhoneFaxJpaController phonesController = new StdPhoneFaxJpaController(emf);
            StdHrAcadBackgrJpaController acadController = new StdHrAcadBackgrJpaController(emf);

            /**
             * The following controllers that manage the publications issues, so
             * they are not necesary for the first iteration.
             */
            VrrhCursosProfJpaController coursesPreController = new VrrhCursosProfJpaController(emf);
            VrrhProCursoAsJpaController coursesPosController = new VrrhProCursoAsJpaController(emf);
//            M4ccbCvArtPubJpaController journalArticlesController = new M4ccbCvArtPubJpaController(emf);
//            M4ccbCvCapLibJpaController bookChpaterController = new M4ccbCvCapLibJpaController(emf);
//            M4ccbCvDlloMatJpaController didacticMaterialController = new M4ccbCvDlloMatJpaController(emf);
//            M4ccbCvDocTrabJpaController workingPapersController = new M4ccbCvDocTrabJpaController(emf);
//            M4ccbCvEdicionRJpaController revisionsController = new M4ccbCvEdicionRJpaController(emf);
//            M4ccbCvLibroJpaController booksController = new M4ccbCvLibroJpaController(emf);
//            M4ccbCvPrefEpilJpaController epilogesController = new M4ccbCvPrefEpilJpaController(emf);
//            M4ccbCvSoftRegJpaController registeredSoftwareController = new M4ccbCvSoftRegJpaController(emf);
//            M4ccbCvTrabTecnJpaController technicalWorksController = new M4ccbCvTrabTecnJpaController(emf);
//            StdHrLangTransJpaController translationsController = new StdHrLangTransJpaController(emf);
//            M4ccbCvPresentacJpaController presentationController = new M4ccbCvPresentacJpaController(emf);
        /*Fin declaraciones controladoras*/
            /**
             * The person must be obtained by STD_ID_PERSON field
             */
            //this.person = personController.findStdPersonByStdSsn(profesorId);
            String stdIdPerson = person.getStdPersonPK().getStdIdPerson();
            String stdSsnPerson = person.getStdSsn();
            this.personPositions = personPositionController.findPersonPositionByScoIdHr(stdIdPerson);
            this.positionDescriptions = positionDescriptionsController.findPositionByM4scoHHrPos(personPositions);
            this.roles = rolesController.findVrrhRepPersonRolByStdIdPerson(stdIdPerson);
            this.personmail = emailController.findInstitutionalEmailByStdHrId(stdIdPerson);
            generateEmailImage();
            this.phoneExtention = phonesController.findInstitutionalPhoneByStdIdPerson(stdIdPerson);
            this.stdHrAcadBackgr = acadController.findStdHrAcadBackgrByStdHrId(stdIdPerson);
            Collections.sort(this.stdHrAcadBackgr);
            Collections.reverse(this.stdHrAcadBackgr);

            // Getting current courses and record courses
            this.vrrhCursosProfCurrent = coursesPreController.findVrrhCursosProfByProfesorPeriodCurrent(stdSsnPerson);
            this.vrrhProCursoAsCurrent = coursesPosController.findVrrhCursosProfByProfesorPeriodCurrent(stdSsnPerson);
            this.coursesPreHis = coursesPreController.findVrrhCursosProfByProfesorPeriodHist(stdSsnPerson);
            this.coursesPosHis = coursesPosController.findVrrhCursosProfByProfesorPeriodHist(stdSsnPerson);

            /**
             * The following lines manage the publications issues, so they are
             * not necesary for the first iteration.
             */
//            this.bookChapters = bookChpaterController.findM4ccbCvCapLibByStdIdHr(stdIdPerson);
//            this.books = booksController.findM4ccbCvLibroByStdIdHr(stdIdPerson);
//            this.didacticMaterial = didacticMaterialController.findM4ccbCvDlloMatByStdIdHr(stdIdPerson);
//            this.epiloges = epilogesController.findM4ccbCvPrefEpilByStdIdHr(stdIdPerson);
//            this.journalArticles = journalArticlesController.findM4ccbCvArtPubfindByStdIdHr(stdIdPerson);
//            this.registeredSoftware = registeredSoftwareController.findM4ccbCvSoftRegByStdIdHr(stdIdPerson);
//            this.revisions = revisionsController.findM4ccbCvEdicionRByStdIdHr(stdIdPerson);
//            this.technicalWorks = technicalWorksController.findM4ccbCvTrabTecnByStdIdHr(stdIdPerson);
//            this.translations = translationsController.findStdHrLangTransByStdIdHr(stdIdPerson);
//            this.workingPapers = workingPapersController.findM4ccbCvDocTrabByStdIdHr(stdIdPerson);
//            this.presentations = presentationController.findM4ccbCvPresentationByStdIdHr(stdIdPerson);
        }
    }

    public StdPerson getPerson() {
        return person;
    }

    public List<M4scoHHrPos> getPersonPositions() {
        return personPositions;
    }

    public List<M4scoPosition> getPositionDescriptions() {
        return positionDescriptions;
    }

    public StdEmail getPersonmail() {
        return personmail;
    }

    public List<StdHrAcadBackgr> getStdHrAcadBackgr() {
        return stdHrAcadBackgr;
    }

    public List<VrrhCursosProf> getVrrhCursosProfCurrent() {
        sortList(vrrhCursosProfCurrent, "VrrhCursosProf");
        return vrrhCursosProfCurrent;
    }

    public List<VrrhProCursoAs> getVrrhProCursoAsCurrent() {
        sortList(vrrhProCursoAsCurrent, "VrrhProCursoAs");
        return vrrhProCursoAsCurrent;
    }

    public List<VrrhCursosProf> getCoursesPreHis() {
        sortList(coursesPreHis, "VrrhCursosProf");
        return coursesPreHis;
    }

    public List<VrrhProCursoAs> getCoursesPosHis() {
        sortList(coursesPosHis, "VrrhProCursoAs");
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

    public List<VrrhRepPersonRol> getRoles() {
        return roles;
    }

    public StdPhoneFax getPhoneExtention() {
        return phoneExtention;
    }

    public void setPhoneExtention(StdPhoneFax phoneExtention) {
        this.phoneExtention = phoneExtention;
    }

    /**
     * This method verify wheather the user's photo file exist in PeopleNet
     * photo repository
     */
    public boolean isPhotoImageExist() {
        String URLName = FacesContext.getCurrentInstance().getExternalContext()
                .getInitParameter("photoImagePath") + this.person.getStdPersonPK().getStdIdPerson() + ".jpg";
        try {
            HttpURLConnection.setFollowRedirects(false);
            // note : you may also need
            //        HttpURLConnection.setInstanceFollowRedirects(false)
            HttpURLConnection con =
                    (HttpURLConnection) new URL(URLName).openConnection();
            con.setRequestMethod("HEAD");
            this.photoImageExist = (con.getResponseCode() == HttpURLConnection.HTTP_OK);
            return this.photoImageExist;
        } catch (Exception e) {
            e.printStackTrace();
            this.photoImageExist = false;
            return this.photoImageExist;
        }
    }

    /**
     * Verify if exist a least 1 registry in the intelleactual contribution
     * tables.
     */
    public boolean isIntellContExist() {
        intellContExist = false;

        if (this.bookChapters != null && !this.bookChapters.isEmpty()) {
            intellContExist = true;
            return intellContExist;
        }
        if (this.books != null && !this.books.isEmpty()) {
            intellContExist = true;
            return intellContExist;
        }
        if (this.didacticMaterial != null && !this.didacticMaterial.isEmpty()) {
            intellContExist = true;
            return intellContExist;
        }
        if (this.epiloges != null && !this.epiloges.isEmpty()) {
            intellContExist = true;
            return intellContExist;
        }
        if (this.journalArticles != null && !this.journalArticles.isEmpty()) {
            intellContExist = true;
            return intellContExist;
        }
        if (this.presentations != null && !this.presentations.isEmpty()) {
            intellContExist = true;
            return intellContExist;
        }
        if (this.registeredSoftware != null && !this.registeredSoftware.isEmpty()) {
            intellContExist = true;
            return intellContExist;
        }
        if (this.revisions != null && !this.revisions.isEmpty()) {
            intellContExist = true;
            return intellContExist;
        }
        if (this.technicalWorks != null && !this.technicalWorks.isEmpty()) {
            intellContExist = true;
            return intellContExist;
        }
        if (this.translations != null && !this.translations.isEmpty()) {
            intellContExist = true;
            return intellContExist;
        }
        if (this.workingPapers != null && !this.workingPapers.isEmpty()) {
            intellContExist = true;
            return intellContExist;
        }

        return intellContExist;
    }

    /**
     * Generates the professor's email image representatation.
     */
    public void generateEmailImage() {
        if (this.personmail != null && this.personmail.getStdEmail() != null) {
            try {
                String rootDeploymentPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
                String mailImagePath = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("mailImagePath");
                File f = new File(rootDeploymentPath + mailImagePath + this.person.getStdPersonPK().getStdIdPerson() + ".png");

                BufferedImage img = new BufferedImage(600, 20,
                        BufferedImage.TRANSLUCENT);
                Graphics2D g2d = img.createGraphics();
                g2d.setColor(new Color(255, 255, 255, 0));
                g2d.fill(new Rectangle(600, 20));
                g2d.setColor(new Color(51, 102, 153, 255));
                g2d.setFont(new Font("Arial", Font.PLAIN, 13));
                g2d.drawString(this.personmail.getStdEmail(), 1, 15);
                g2d.dispose();
                ImageIO.write(img, "png", f);
                /*}*/
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }

    /**
     * Get the professor's PeopleNet id from the professor's web id
     *
     * @param professorWebId The web identifier for the professor.
     * @return The PeopleNet Id for the professor <code>null</code> if there is
     * any professor with the web id passed as param.
     */
    public String getPeopleNetId(String professorWebId) {
        M4ccbConsPersonasJpaController constantsController = new M4ccbConsPersonasJpaController(emf);
        M4ccbConsPersonas professorConstants = constantsController.findM4ccbConsPersonasByCcbIdWeb(professorWebId);
        if (professorConstants != null) {
            return professorConstants.getM4ccbConsPersonasPK().getCcbIdPerson();
        }
        return null;
    }

    
    /**
     * Sorts a list, depending on the language defined in session. An
     * appropriate comparator for the objectType class must exist in the
     * co.edu.icesi.profesores.entities.comparators package. The convention for
     * comparators is ClassNameComparator.
     *
     * @param list the list to sort
     * @param objectType The class of objects saved in the list.
     */
    private void sortList(List list, String objectType) {
        Locale currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        String comparatorName = "co.edu.icesi.profesores.entities.comparators." + objectType + "Comparator";

        try {
            //Get the comparator for objectType
            Class<?> comparatorClass = Class.forName(comparatorName);
            Constructor<?> comparatorConstructor = comparatorClass.getConstructor(Locale.class);
            Object comparatorObject = comparatorConstructor.newInstance(currentLocale);

            Collections.sort(list, (Comparator) comparatorObject);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurriculumVitaeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CurriculumVitaeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(CurriculumVitaeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CurriculumVitaeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CurriculumVitaeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CurriculumVitaeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CurriculumVitaeController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
