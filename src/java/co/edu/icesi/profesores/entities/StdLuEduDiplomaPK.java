/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 1130619373
 */
@Embeddable
public class StdLuEduDiplomaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_DIPLOMA")
    private String stdIdDiploma;

    public StdLuEduDiplomaPK() {
    }

    public StdLuEduDiplomaPK(String idOrganization, String stdIdDiploma) {
        this.idOrganization = idOrganization;
        this.stdIdDiploma = stdIdDiploma;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getStdIdDiploma() {
        return stdIdDiploma;
    }

    public void setStdIdDiploma(String stdIdDiploma) {
        this.stdIdDiploma = stdIdDiploma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdDiploma != null ? stdIdDiploma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdLuEduDiplomaPK)) {
            return false;
        }
        StdLuEduDiplomaPK other = (StdLuEduDiplomaPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdDiploma == null && other.stdIdDiploma != null) || (this.stdIdDiploma != null && !this.stdIdDiploma.equals(other.stdIdDiploma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdLuEduDiplomaPK[ idOrganization=" + idOrganization + ", stdIdDiploma=" + stdIdDiploma + " ]";
    }
    
}
