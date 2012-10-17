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
public class M4scoHHrPosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "SCO_ID_HR")
    private String scoIdHr;
    @Basic(optional = false)
    @Column(name = "SCO_OR_HR_ROLE")
    private short scoOrHrRole;

    public M4scoHHrPosPK() {
    }

    public M4scoHHrPosPK(String idOrganization, String scoIdHr, short scoOrHrRole) {
        this.idOrganization = idOrganization;
        this.scoIdHr = scoIdHr;
        this.scoOrHrRole = scoOrHrRole;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getScoIdHr() {
        return scoIdHr;
    }

    public void setScoIdHr(String scoIdHr) {
        this.scoIdHr = scoIdHr;
    }

    public short getScoOrHrRole() {
        return scoOrHrRole;
    }

    public void setScoOrHrRole(short scoOrHrRole) {
        this.scoOrHrRole = scoOrHrRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (scoIdHr != null ? scoIdHr.hashCode() : 0);
        hash += (int) scoOrHrRole;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoHHrPosPK)) {
            return false;
        }
        M4scoHHrPosPK other = (M4scoHHrPosPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.scoIdHr == null && other.scoIdHr != null) || (this.scoIdHr != null && !this.scoIdHr.equals(other.scoIdHr))) {
            return false;
        }
        if (this.scoOrHrRole != other.scoOrHrRole) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4scoHHrPosPK[ idOrganization=" + idOrganization + ", scoIdHr=" + scoIdHr + ", scoOrHrRole=" + scoOrHrRole + " ]";
    }
    
}
