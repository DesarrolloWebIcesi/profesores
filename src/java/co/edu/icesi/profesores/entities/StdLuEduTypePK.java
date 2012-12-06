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
public class StdLuEduTypePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_EDU_TYPE")
    private String stdIdEduType;

    public StdLuEduTypePK() {
    }

    public StdLuEduTypePK(String idOrganization, String stdIdEduType) {
        this.idOrganization = idOrganization;
        this.stdIdEduType = stdIdEduType;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getStdIdEduType() {
        return stdIdEduType;
    }

    public void setStdIdEduType(String stdIdEduType) {
        this.stdIdEduType = stdIdEduType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdEduType != null ? stdIdEduType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdLuEduTypePK)) {
            return false;
        }
        StdLuEduTypePK other = (StdLuEduTypePK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdEduType == null && other.stdIdEduType != null) || (this.stdIdEduType != null && !this.stdIdEduType.equals(other.stdIdEduType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdLuEduTypePK[ idOrganization=" + idOrganization + ", stdIdEduType=" + stdIdEduType + " ]";
    }
    
}
