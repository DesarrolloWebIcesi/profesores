/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 *
 * @author 14620701
 */
@Embeddable
public class VrrhProCursoAsPK implements Serializable{
    @Column(name = "PROFESOR_CEDULA")
    private String profesorCedula;  
    @Column(name = "SISTEMA")
    private String sistema; 
    @Column(name = "PERIODO_ACAD")
    private String periodoAcad; 
    @Column(name = "PERIODO_CONSECUTIVO")
    private int periodoConsecutivo; 
    @Column(name = "MATERIA_CODIGO")
    private String materiaCodigo; 

    public VrrhProCursoAsPK() {
    }

    public VrrhProCursoAsPK(String profesorCedula, String sistema, String periodoAcad, int periodoConsecutivo, String materiaCodigo) {
        this.profesorCedula = profesorCedula;
        this.sistema = sistema;
        this.periodoAcad = periodoAcad;
        this.periodoConsecutivo = periodoConsecutivo;
        this.materiaCodigo = materiaCodigo;
    }
        
    public String getProfesorCedula() {
        return profesorCedula;
    }

    public void setProfesorCedula(String profesorCedula) {
        this.profesorCedula = profesorCedula;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getPeriodoAcad() {
        return periodoAcad;
    }

    public void setPeriodoAcad(String periodoAcad) {
        this.periodoAcad = periodoAcad;
    }

    public int getPeriodoConsecutivo() {
        return periodoConsecutivo;
    }

    public void setPeriodoConsecutivo(int periodoConsecutivo) {
        this.periodoConsecutivo = periodoConsecutivo;
    }

    public String getMateriaCodigo() {
        return materiaCodigo;
    }

    public void setMateriaCodigo(String materiaCodigo) {
        this.materiaCodigo = materiaCodigo;
    }     
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profesorCedula != null ? profesorCedula.hashCode() : 0);
        hash += (periodoAcad != null ? periodoAcad.hashCode() : 0);
        hash += (periodoConsecutivo != 0 ? periodoConsecutivo : 0);
        hash += (materiaCodigo != null ? materiaCodigo.hashCode() : 0);
        hash += (sistema != null ? sistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof VrrhCursosProfPK)) {
            return false;
        }
        VrrhProCursoAsPK other = (VrrhProCursoAsPK) obj;
        if ((this.profesorCedula == null && other.profesorCedula != null) || (this.profesorCedula != null && !this.profesorCedula.equals(other.profesorCedula))) {
            return false;
        }
        if ((this.periodoAcad == null && other.periodoAcad != null) || (this.periodoAcad != null && !this.periodoAcad.equals(other.periodoAcad))) {
            return false;
        }
        if ((this.materiaCodigo == null && other.materiaCodigo != null) || (this.materiaCodigo != null && !this.materiaCodigo.equals(other.materiaCodigo))) {
            return false;
        }
        if ((this.periodoConsecutivo == 0 && other.periodoConsecutivo != 0) || (this.periodoConsecutivo != 0 && this.periodoConsecutivo==other.periodoConsecutivo)) {
            return false;
        }
        if ((this.sistema == null && other.sistema != null) || (this.sistema != null && !this.sistema.equals(other.sistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.VrrhCursosProfPK[ profesorCedula=" + profesorCedula + ", periodoPeriodoAcad=" + periodoAcad + ", materiaCodigo="+materiaCodigo+", periodoConsecutivo="+periodoConsecutivo+", sistema="+sistema+"]";
    }
}
