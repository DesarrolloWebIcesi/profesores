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
public class StdHrPeriodPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_HR")
    private String stdIdHr;
    @Basic(optional = false)
    @Column(name = "STD_OR_HR_PERIOD")
    private short stdOrHrPeriod;

    public StdHrPeriodPK() {
    }

    public StdHrPeriodPK(String idOrganization, String stdIdHr, short stdOrHrPeriod) {
        this.idOrganization = idOrganization;
        this.stdIdHr = stdIdHr;
        this.stdOrHrPeriod = stdOrHrPeriod;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getStdIdHr() {
        return stdIdHr;
    }

    public void setStdIdHr(String stdIdHr) {
        this.stdIdHr = stdIdHr;
    }

    public short getStdOrHrPeriod() {
        return stdOrHrPeriod;
    }

    public void setStdOrHrPeriod(short stdOrHrPeriod) {
        this.stdOrHrPeriod = stdOrHrPeriod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdHr != null ? stdIdHr.hashCode() : 0);
        hash += (int) stdOrHrPeriod;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdHrPeriodPK)) {
            return false;
        }
        StdHrPeriodPK other = (StdHrPeriodPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdHr == null && other.stdIdHr != null) || (this.stdIdHr != null && !this.stdIdHr.equals(other.stdIdHr))) {
            return false;
        }
        if (this.stdOrHrPeriod != other.stdOrHrPeriod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdHrPeriodPK[ idOrganization=" + idOrganization + ", stdIdHr=" + stdIdHr + ", stdOrHrPeriod=" + stdOrHrPeriod + " ]";
    }
    
}
