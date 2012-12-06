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
public class StdRelWorkUnitPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_WU_CHILD")
    private String stdIdWuChild;
    @Basic(optional = false)
    @Column(name = "STD_DT_START")
    @Temporal(TemporalType.DATE)
    private Date stdDtStart;

    public StdRelWorkUnitPK() {
    }

    public StdRelWorkUnitPK(String idOrganization, String stdIdWuChild, Date stdDtStart) {
        this.idOrganization = idOrganization;
        this.stdIdWuChild = stdIdWuChild;
        this.stdDtStart = stdDtStart;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getStdIdWuChild() {
        return stdIdWuChild;
    }

    public void setStdIdWuChild(String stdIdWuChild) {
        this.stdIdWuChild = stdIdWuChild;
    }

    public Date getStdDtStart() {
        return stdDtStart;
    }

    public void setStdDtStart(Date stdDtStart) {
        this.stdDtStart = stdDtStart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdWuChild != null ? stdIdWuChild.hashCode() : 0);
        hash += (stdDtStart != null ? stdDtStart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdRelWorkUnitPK)) {
            return false;
        }
        StdRelWorkUnitPK other = (StdRelWorkUnitPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdWuChild == null && other.stdIdWuChild != null) || (this.stdIdWuChild != null && !this.stdIdWuChild.equals(other.stdIdWuChild))) {
            return false;
        }
        if ((this.stdDtStart == null && other.stdDtStart != null) || (this.stdDtStart != null && !this.stdDtStart.equals(other.stdDtStart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdRelWorkUnitPK[ idOrganization=" + idOrganization + ", stdIdWuChild=" + stdIdWuChild + ", stdDtStart=" + stdDtStart + " ]";
    }
    
}
