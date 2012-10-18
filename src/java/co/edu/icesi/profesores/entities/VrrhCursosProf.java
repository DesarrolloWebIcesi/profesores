/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1130619373
 */
@Entity
@Table(name = "VRRH_CURSOS_PROF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VrrhCursosProf.findAll", query = "SELECT s FROM VrrhCursosProf s"),
    @NamedQuery(name = "VrrhCursosProf.findByStdIdPerson", query = "SELECT s FROM VrrhCursosProf s WHERE s.stdIdPerson = :stdIdPerson"),
    @NamedQuery(name = "VrrhCursosProf.findByProfesorCedula", query = "SELECT s FROM VrrhCursosProf s WHERE s.vrrhCursosProfPK.profesorCedula = :profesorCedula"),
    @NamedQuery(name = "VrrhCursosProf.findByProfesorPeriod", query = "SELECT DISTINCT s FROM VrrhCursosProf s WHERE s.vrrhCursosProfPK.profesorCedula = :profesorCedula AND s.vrrhCursosProfPK.periodoPeriodoAcad=:periodoAcad AND s.vrrhCursosProfPK.periodoConsecutivo=:periodoConsecutivo"),
    @NamedQuery(name = "VrrhCursosProf.findByProfesorPeriodHist", query = "SELECT DISTINCT s FROM VrrhCursosProf s WHERE s.vrrhCursosProfPK.profesorCedula = :profesorCedula AND s.vrrhCursosProfPK.periodoPeriodoAcad!=:periodoAcad AND s.vrrhCursosProfPK.periodoConsecutivo!=:periodoConsecutivo")
})
public class VrrhCursosProf implements Serializable {

    @EmbeddedId
    protected VrrhCursosProfPK vrrhCursosProfPK;
    @Column(name = "STD_ID_PERSON")
    private String stdIdPerson; 
    @Column(name = "MATERIA_NOMBRE")
    private String materiaNombre;
    

    public VrrhCursosProf() {
    }
    
    public VrrhCursosProf(VrrhCursosProfPK vrrhCursosProfPK) {
        this.vrrhCursosProfPK=vrrhCursosProfPK;
    }

    public VrrhCursosProfPK getVrrhCursosProfPK() {
        return vrrhCursosProfPK;
    }

    public void setVrrhCursosProfPK(VrrhCursosProfPK vrrhCursosProfPK) {
        this.vrrhCursosProfPK = vrrhCursosProfPK;
    }
    
    public String getMateriaNombre() {
        return materiaNombre;
    }

    public void setMateriaNombre(String materiaNombre) {
        this.materiaNombre = materiaNombre;
    }

    public String getStdIdPerson() {
        return stdIdPerson;
    }

    public void setStdIdPerson(String stdIdPerson) {
        this.stdIdPerson = stdIdPerson;
    }
}
