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
public class StdWorkUnitPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_WORK_UNIT")
    private String stdIdWorkUnit;

    public StdWorkUnitPK() {
    }

    public StdWorkUnitPK(String idOrganization, String stdIdWorkUnit) {
        this.idOrganization = idOrganization;
        this.stdIdWorkUnit = stdIdWorkUnit;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getStdIdWorkUnit() {
        return stdIdWorkUnit;
    }

    public void setStdIdWorkUnit(String stdIdWorkUnit) {
        this.stdIdWorkUnit = stdIdWorkUnit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdWorkUnit != null ? stdIdWorkUnit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdWorkUnitPK)) {
            return false;
        }
        StdWorkUnitPK other = (StdWorkUnitPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdWorkUnit == null && other.stdIdWorkUnit != null) || (this.stdIdWorkUnit != null && !this.stdIdWorkUnit.equals(other.stdIdWorkUnit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdWorkUnitPK[ idOrganization=" + idOrganization + ", stdIdWorkUnit=" + stdIdWorkUnit + " ]";
    }
    
}
