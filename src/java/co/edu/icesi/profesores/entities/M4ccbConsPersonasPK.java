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
public class M4ccbConsPersonasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CCB_ID_PERSON")
    private String ccbIdPerson;
    @Basic(optional = false)
    @Column(name = "CCB_ID_WEB")
    private String ccbIdWeb;
    @Basic(optional = false)
    @Column(name = "CCB_DT_START")
    @Temporal(TemporalType.DATE)
    private Date ccbDtStart;

    public M4ccbConsPersonasPK() {
    }

    public M4ccbConsPersonasPK(String ccbIdPerson, String ccbIdWeb, Date ccbDtStart) {
        this.ccbIdPerson = ccbIdPerson;
        this.ccbIdWeb = ccbIdWeb;
        this.ccbDtStart = ccbDtStart;
    }

    public String getCcbIdPerson() {
        return ccbIdPerson;
    }

    public void setCcbIdPerson(String ccbIdPerson) {
        this.ccbIdPerson = ccbIdPerson;
    }

    public String getCcbIdWeb() {
        return ccbIdWeb;
    }

    public void setCcbIdWeb(String ccbIdWeb) {
        this.ccbIdWeb = ccbIdWeb;
    }

    public Date getCcbDtStart() {
        return ccbDtStart;
    }

    public void setCcbDtStart(Date ccbDtStart) {
        this.ccbDtStart = ccbDtStart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccbIdPerson != null ? ccbIdPerson.hashCode() : 0);
        hash += (ccbIdWeb != null ? ccbIdWeb.hashCode() : 0);
        hash += (ccbDtStart != null ? ccbDtStart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbConsPersonasPK)) {
            return false;
        }
        M4ccbConsPersonasPK other = (M4ccbConsPersonasPK) object;
        if ((this.ccbIdPerson == null && other.ccbIdPerson != null) || (this.ccbIdPerson != null && !this.ccbIdPerson.equals(other.ccbIdPerson))) {
            return false;
        }
        if ((this.ccbIdWeb == null && other.ccbIdWeb != null) || (this.ccbIdWeb != null && !this.ccbIdWeb.equals(other.ccbIdWeb))) {
            return false;
        }
        if ((this.ccbDtStart == null && other.ccbDtStart != null) || (this.ccbDtStart != null && !this.ccbDtStart.equals(other.ccbDtStart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4ccbConsPersonasPK[ ccbIdPerson=" + ccbIdPerson + ", ccbIdWeb=" + ccbIdWeb + ", ccbDtStart=" + ccbDtStart + " ]";
    }
    
}
