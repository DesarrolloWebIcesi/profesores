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
public class M4scoEducCenterPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "SCO_ID_EDUC_CENTER")
    private String scoIdEducCenter;

    public M4scoEducCenterPK() {
    }

    public M4scoEducCenterPK(String idOrganization, String scoIdEducCenter) {
        this.idOrganization = idOrganization;
        this.scoIdEducCenter = scoIdEducCenter;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getScoIdEducCenter() {
        return scoIdEducCenter;
    }

    public void setScoIdEducCenter(String scoIdEducCenter) {
        this.scoIdEducCenter = scoIdEducCenter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (scoIdEducCenter != null ? scoIdEducCenter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoEducCenterPK)) {
            return false;
        }
        M4scoEducCenterPK other = (M4scoEducCenterPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.scoIdEducCenter == null && other.scoIdEducCenter != null) || (this.scoIdEducCenter != null && !this.scoIdEducCenter.equals(other.scoIdEducCenter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4scoEducCenterPK[ idOrganization=" + idOrganization + ", scoIdEducCenter=" + scoIdEducCenter + " ]";
    }
    
}
