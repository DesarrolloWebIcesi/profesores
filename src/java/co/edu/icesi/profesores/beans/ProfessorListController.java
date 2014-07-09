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
import java.util.ArrayList;
import java.util.List;
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
 */
@ManagedBean(name = "professorlist")
@SessionScoped
public class ProfessorListController implements Serializable {
    
    private List<StdPerson> allProfessors;
    private List<StdPerson> cathedraProfessors;
    private List<StdPerson> fulltimeProfessors;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("profesoresPU");
    private M4ccbConsPersonasJpaController constantsController = new M4ccbConsPersonasJpaController(emf);
    private StdPersonJpaController personController = new StdPersonJpaController(emf);
    private VrrhRepPersonRolJpaController rolesController= new VrrhRepPersonRolJpaController(emf);
    /**
     * Creates a new instance of CurriculumVitaeController
     */
    public ProfessorListController() {
        
        this.allProfessors = personController.findProfessors();
        this.fulltimeProfessors=new ArrayList<StdPerson>();
        this.cathedraProfessors=new ArrayList<StdPerson>();
        classifyProfessors();
    }
    
    public List<StdPerson> getAllProfessors() {
        return allProfessors;
    }
    
    public void setAllProfessors(List<StdPerson> allProfessors) {
        this.allProfessors = allProfessors;
    }

    public List<StdPerson> getCathedraProfessors() {
        return cathedraProfessors;
    }

    public void setCathedraProfessors(List<StdPerson> cathedraProfessors) {
        this.cathedraProfessors = cathedraProfessors;
    }

    public List<StdPerson> getFulltimeProfessors() {
        return fulltimeProfessors;
    }

    public void setFulltimeProfessors(List<StdPerson> fulltimeProfessors) {
        this.fulltimeProfessors = fulltimeProfessors;
    }
    

    /** 
     * Classify the list of professor
     */
    private void classifyProfessors() {        
        for (int i = 0; i < this.allProfessors.size(); i++) {
            StdPerson professor = this.allProfessors.get(i);
            getProfessorConstants(professor);
            
            List<VrrhRepPersonRol> roles=rolesController.findVrrhRepPersonRolByStdIdPerson(professor.getStdPersonPK().getStdIdPerson());
            if(!roles.isEmpty()){
                VrrhRepPersonRol rol=roles.get(0);
                if(rol.getModalidad()!=null && 
                        (rol.getModalidad().equalsIgnoreCase("TC") || 
                         rol.getModalidad().equalsIgnoreCase("EM") ||
                         rol.getModalidad().equalsIgnoreCase("TP")
                        )){
                    this.fulltimeProfessors.add(professor);
                }else if(rol.getModalidad()!=null && rol.getModalidad().equalsIgnoreCase("HC")){
                    this.cathedraProfessors.add(professor);
                }
            }
        }
    }
    
    /**
     * TODO: Fix the documentation
     *
     * @param professorWebId The web identifier for the professor.
     */
    private void getProfessorConstants(StdPerson professor){
        M4ccbConsPersonas constants=constantsController.findCurrentConstantsByStdId(professor.getStdPersonPK().getStdIdPerson());
        professor.setConstants(constants);
    }
}
