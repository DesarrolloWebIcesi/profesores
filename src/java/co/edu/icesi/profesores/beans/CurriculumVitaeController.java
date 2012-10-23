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
import javax.persistence.Persistence;

/**
 *
 * @author 14620701
 */
@ManagedBean (name = "curriculumvitae")
@SessionScoped
public class CurriculumVitaeController implements Serializable {
    
    private StdPerson person;
    private List <M4ccbCvArtPub> m4ccbCvArtPub; 
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
    
    private void cargar(String profesorId){
        StdPersonJpaController personController = new StdPersonJpaController(Persistence.createEntityManagerFactory("profesoresPU"));
        M4ccbCvArtPubJpaController articleController = new M4ccbCvArtPubJpaController(Persistence.createEntityManagerFactory("profesoresPU"));
        this.person = personController.findStdPersonByStdSsn(profesorId);
        m4ccbCvArtPub = articleController.findM4ccbCvArtPubfindByStdIdHr(person.getStdPersonPK().getStdIdPerson());
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
    
   
}
