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
public class StdExternalOrgPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_EXTERN_ORG")
    private String stdIdExternOrg;

    public StdExternalOrgPK() {
    }

    public StdExternalOrgPK(String idOrganization, String stdIdExternOrg) {
        this.idOrganization = idOrganization;
        this.stdIdExternOrg = stdIdExternOrg;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getStdIdExternOrg() {
        return stdIdExternOrg;
    }

    public void setStdIdExternOrg(String stdIdExternOrg) {
        this.stdIdExternOrg = stdIdExternOrg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdExternOrg != null ? stdIdExternOrg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdExternalOrgPK)) {
            return false;
        }
        StdExternalOrgPK other = (StdExternalOrgPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdExternOrg == null && other.stdIdExternOrg != null) || (this.stdIdExternOrg != null && !this.stdIdExternOrg.equals(other.stdIdExternOrg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdExternalOrgPK[ idOrganization=" + idOrganization + ", stdIdExternOrg=" + stdIdExternOrg + " ]";
    }
    
}
