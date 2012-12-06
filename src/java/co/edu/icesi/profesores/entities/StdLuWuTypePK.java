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
public class StdLuWuTypePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_WU_TYPE")
    private String stdIdWuType;

    public StdLuWuTypePK() {
    }

    public StdLuWuTypePK(String idOrganization, String stdIdWuType) {
        this.idOrganization = idOrganization;
        this.stdIdWuType = stdIdWuType;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getStdIdWuType() {
        return stdIdWuType;
    }

    public void setStdIdWuType(String stdIdWuType) {
        this.stdIdWuType = stdIdWuType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdWuType != null ? stdIdWuType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdLuWuTypePK)) {
            return false;
        }
        StdLuWuTypePK other = (StdLuWuTypePK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdWuType == null && other.stdIdWuType != null) || (this.stdIdWuType != null && !this.stdIdWuType.equals(other.stdIdWuType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdLuWuTypePK[ idOrganization=" + idOrganization + ", stdIdWuType=" + stdIdWuType + " ]";
    }
    
}
