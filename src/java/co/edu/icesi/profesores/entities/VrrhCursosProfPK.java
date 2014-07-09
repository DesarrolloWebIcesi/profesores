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
 * @author 1130619373
 */
@Embeddable
public class VrrhCursosProfPK implements Serializable{
    @Column(name = "PROFESOR_CEDULA")
    private String profesorCedula;       
    @Column(name = "PERIODO_PERIODO_ACAD")
    private String periodoPeriodoAcad;
    @Column(name = "PERIODO_CONSECUTIVO")
    private int periodoConsecutivo;
    @Column(name = "MATERIA_CODIGO")
    private String materiaCodigo;

    public VrrhCursosProfPK() {
    }

    public VrrhCursosProfPK(String profesorCedula, String periodoPeriodoAcad, int periodoConsecutivo, String metariaCodigo) {
        this.profesorCedula = profesorCedula;
        this.periodoPeriodoAcad = periodoPeriodoAcad;
        this.periodoConsecutivo = periodoConsecutivo;
        this.materiaCodigo = metariaCodigo;
    }
    
    public String getProfesorCedula() {
        return profesorCedula;
    }

    public void setProfesorCedula(String profesorCedula) {
        this.profesorCedula = profesorCedula;
    }

    public String getPeriodoPeriodoAcad() {
        return periodoPeriodoAcad;
    }

    public void setPeriodoPeriodoAcad(String periodoPeriodoAcad) {
        this.periodoPeriodoAcad = periodoPeriodoAcad;
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
        hash += (periodoPeriodoAcad != null ? periodoPeriodoAcad.hashCode() : 0);
        hash += (periodoConsecutivo != 0 ? periodoConsecutivo : 0);
        hash += (materiaCodigo != null ? materiaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof VrrhCursosProfPK)) {
            return false;
        }
        VrrhCursosProfPK other = (VrrhCursosProfPK) obj;
        if ((this.profesorCedula == null && other.profesorCedula != null) || (this.profesorCedula != null && !this.profesorCedula.equals(other.profesorCedula))) {
            return false;
        }
        if ((this.periodoPeriodoAcad == null && other.periodoPeriodoAcad != null) || (this.periodoPeriodoAcad != null && !this.periodoPeriodoAcad.equals(other.periodoPeriodoAcad))) {
            return false;
        }
        if ((this.materiaCodigo == null && other.materiaCodigo != null) || (this.materiaCodigo != null && !this.materiaCodigo.equals(other.materiaCodigo))) {
            return false;
        }
        if ((this.periodoConsecutivo == 0 && other.periodoConsecutivo != 0) || (this.periodoConsecutivo != 0 && this.periodoConsecutivo==other.periodoConsecutivo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.VrrhCursosProfPK[ profesorCedula=" + profesorCedula + ", periodoPeriodoAcad=" + periodoPeriodoAcad + ", materiaCodigo="+materiaCodigo+", periodoConsecutivo="+periodoConsecutivo+"]";
    }
    
    
}
