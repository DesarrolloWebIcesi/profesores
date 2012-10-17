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
public class M4scoPositionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "SCO_ID_POSITION")
    private String scoIdPosition;

    public M4scoPositionPK() {
    }

    public M4scoPositionPK(String idOrganization, String scoIdPosition) {
        this.idOrganization = idOrganization;
        this.scoIdPosition = scoIdPosition;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getScoIdPosition() {
        return scoIdPosition;
    }

    public void setScoIdPosition(String scoIdPosition) {
        this.scoIdPosition = scoIdPosition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (scoIdPosition != null ? scoIdPosition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoPositionPK)) {
            return false;
        }
        M4scoPositionPK other = (M4scoPositionPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.scoIdPosition == null && other.scoIdPosition != null) || (this.scoIdPosition != null && !this.scoIdPosition.equals(other.scoIdPosition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4scoPositionPK[ idOrganization=" + idOrganization + ", scoIdPosition=" + scoIdPosition + " ]";
    }
    
}
