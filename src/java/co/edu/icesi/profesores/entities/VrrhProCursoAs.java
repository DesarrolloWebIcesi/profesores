/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Manuel Lozano - jlozano
 * 
 * @version v2 2013-05-22 by damanzano. Include the attribute matNEng that
 * represent the course's name in english.
 */
@Entity
@Table(name = "VRRH_PRO_CURSO_AS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VrrhProCursoAs.findAll", query = "SELECT s FROM VrrhProCursoAs s"),
    @NamedQuery(name = "VrrhProCursoAs.findByProfesorCedula", query = "SELECT s FROM VrrhProCursoAs s WHERE s.vrrhProCursoAsPK.profesorCedula = :profesorCedula"),
    @NamedQuery(name = "VrrhProCursoAs.findByProfesorPeriod", query = "SELECT DISTINCT s FROM VrrhProCursoAs s WHERE s.vrrhProCursoAsPK.profesorCedula = :profesorCedula AND s.vrrhProCursoAsPK.periodoAcad=:periodoAcad AND s.vrrhProCursoAsPK.periodoConsecutivo=:periodoConsecutivo"),
    @NamedQuery(name = "VrrhProCursoAs.findByProfesorPeriodHist", query = "SELECT DISTINCT s FROM VrrhProCursoAs s WHERE s.vrrhProCursoAsPK.profesorCedula = :profesorCedula AND s.vrrhProCursoAsPK.periodoAcad <> :periodoAcad order by 1")
})
public class VrrhProCursoAs implements Serializable {
    
    @EmbeddedId
    protected VrrhProCursoAsPK vrrhProCursoAsPK;
    @Column (name="NOMBRE_MATERIA")
    private String nombreMateria;
    @Column (name = "ACTIVIDAD")
    private String actividad;
    @Column(name = "MAT_N_ENG")
    private String matNEng;

    public VrrhProCursoAs() {
    }

    public VrrhProCursoAsPK getVrrhProCursoAsPK() {
        return vrrhProCursoAsPK;
    }

    public void setVrrhProCursoAsPK(VrrhProCursoAsPK vrrhProCursoAsPK) {
        this.vrrhProCursoAsPK = vrrhProCursoAsPK;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    /** 
    * Get the course's name in english 
    * @since v2
    */
    public String getMatNEng() {
        return matNEng;
    }

    /** 
     * Set the matNEng attribute
     * @param matNEng A string representing the course's name in english.
     * @since v2
     */
    public void setMatNEng(String matNEng) {
        this.matNEng = matNEng;
    }
}
