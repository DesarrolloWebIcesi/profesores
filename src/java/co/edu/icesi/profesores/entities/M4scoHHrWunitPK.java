/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 1130619373
 */
@Embeddable
public class M4scoHHrWunitPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "SCO_ID_HR")
    private String scoIdHr;
    @Basic(optional = false)
    @Column(name = "SCO_DT_START")
    @Temporal(TemporalType.DATE)
    private Date scoDtStart;
    @Basic(optional = false)
    @Column(name = "SCO_OR_HR_ROLE")
    private short scoOrHrRole;

    public M4scoHHrWunitPK() {
    }

    public M4scoHHrWunitPK(String idOrganization, String scoIdHr, Date scoDtStart, short scoOrHrRole) {
        this.idOrganization = idOrganization;
        this.scoIdHr = scoIdHr;
        this.scoDtStart = scoDtStart;
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

    public Date getScoDtStart() {
        return scoDtStart;
    }

    public void setScoDtStart(Date scoDtStart) {
        this.scoDtStart = scoDtStart;
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
        hash += (scoDtStart != null ? scoDtStart.hashCode() : 0);
        hash += (int) scoOrHrRole;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoHHrWunitPK)) {
            return false;
        }
        M4scoHHrWunitPK other = (M4scoHHrWunitPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.scoIdHr == null && other.scoIdHr != null) || (this.scoIdHr != null && !this.scoIdHr.equals(other.scoIdHr))) {
            return false;
        }
        if ((this.scoDtStart == null && other.scoDtStart != null) || (this.scoDtStart != null && !this.scoDtStart.equals(other.scoDtStart))) {
            return false;
        }
        if (this.scoOrHrRole != other.scoOrHrRole) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4scoHHrWunitPK[ idOrganization=" + idOrganization + ", scoIdHr=" + scoIdHr + ", scoDtStart=" + scoDtStart + ", scoOrHrRole=" + scoOrHrRole + " ]";
    }
    
}
