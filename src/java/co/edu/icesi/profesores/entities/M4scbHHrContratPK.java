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
public class M4scbHHrContratPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_HR")
    private String stdIdHr;
    @Basic(optional = false)
    @Column(name = "STD_OR_HR_PERIOD")
    private short stdOrHrPeriod;
    @Basic(optional = false)
    @Column(name = "SCB_DT_START")
    @Temporal(TemporalType.DATE)
    private Date scbDtStart;

    public M4scbHHrContratPK() {
    }

    public M4scbHHrContratPK(String idOrganization, String stdIdHr, short stdOrHrPeriod, Date scbDtStart) {
        this.idOrganization = idOrganization;
        this.stdIdHr = stdIdHr;
        this.stdOrHrPeriod = stdOrHrPeriod;
        this.scbDtStart = scbDtStart;
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

    public Date getScbDtStart() {
        return scbDtStart;
    }

    public void setScbDtStart(Date scbDtStart) {
        this.scbDtStart = scbDtStart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdHr != null ? stdIdHr.hashCode() : 0);
        hash += (int) stdOrHrPeriod;
        hash += (scbDtStart != null ? scbDtStart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scbHHrContratPK)) {
            return false;
        }
        M4scbHHrContratPK other = (M4scbHHrContratPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdHr == null && other.stdIdHr != null) || (this.stdIdHr != null && !this.stdIdHr.equals(other.stdIdHr))) {
            return false;
        }
        if (this.stdOrHrPeriod != other.stdOrHrPeriod) {
            return false;
        }
        if ((this.scbDtStart == null && other.scbDtStart != null) || (this.scbDtStart != null && !this.scbDtStart.equals(other.scbDtStart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4scbHHrContratPK[ idOrganization=" + idOrganization + ", stdIdHr=" + stdIdHr + ", stdOrHrPeriod=" + stdOrHrPeriod + ", scbDtStart=" + scbDtStart + " ]";
    }
    
}
