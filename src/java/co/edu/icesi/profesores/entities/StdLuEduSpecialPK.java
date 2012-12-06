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
public class StdLuEduSpecialPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_EDU_SP")
    private String stdIdEduSp;

    public StdLuEduSpecialPK() {
    }

    public StdLuEduSpecialPK(String idOrganization, String stdIdEduSp) {
        this.idOrganization = idOrganization;
        this.stdIdEduSp = stdIdEduSp;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getStdIdEduSp() {
        return stdIdEduSp;
    }

    public void setStdIdEduSp(String stdIdEduSp) {
        this.stdIdEduSp = stdIdEduSp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdEduSp != null ? stdIdEduSp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdLuEduSpecialPK)) {
            return false;
        }
        StdLuEduSpecialPK other = (StdLuEduSpecialPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdEduSp == null && other.stdIdEduSp != null) || (this.stdIdEduSp != null && !this.stdIdEduSp.equals(other.stdIdEduSp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdLuEduSpecialPK[ idOrganization=" + idOrganization + ", stdIdEduSp=" + stdIdEduSp + " ]";
    }
    
}
