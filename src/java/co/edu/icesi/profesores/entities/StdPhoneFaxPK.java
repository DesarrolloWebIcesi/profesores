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
public class StdPhoneFaxPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_PERSON")
    private String stdIdPerson;
    @Basic(optional = false)
    @Column(name = "STD_OR_PHONE")
    private int stdOrPhone;

    public StdPhoneFaxPK() {
    }

    public StdPhoneFaxPK(String idOrganization, String stdIdPerson, int stdOrPhone) {
        this.idOrganization = idOrganization;
        this.stdIdPerson = stdIdPerson;
        this.stdOrPhone = stdOrPhone;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getStdIdPerson() {
        return stdIdPerson;
    }

    public void setStdIdPerson(String stdIdPerson) {
        this.stdIdPerson = stdIdPerson;
    }

    public int getStdOrPhone() {
        return stdOrPhone;
    }

    public void setStdOrPhone(int stdOrPhone) {
        this.stdOrPhone = stdOrPhone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdPerson != null ? stdIdPerson.hashCode() : 0);
        hash += (int) stdOrPhone;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdPhoneFaxPK)) {
            return false;
        }
        StdPhoneFaxPK other = (StdPhoneFaxPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdPerson == null && other.stdIdPerson != null) || (this.stdIdPerson != null && !this.stdIdPerson.equals(other.stdIdPerson))) {
            return false;
        }
        if (this.stdOrPhone != other.stdOrPhone) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdPhoneFaxPK[ idOrganization=" + idOrganization + ", stdIdPerson=" + stdIdPerson + ", stdOrPhone=" + stdOrPhone + " ]";
    }
    
}
