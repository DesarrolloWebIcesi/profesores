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
public class M4ccbCvDocTrabPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "CCB_OR_DOC_TRAB")
    private short ccbOrDocTrab;
    @Basic(optional = false)
    @Column(name = "STD_ID_HR")
    private String stdIdHr;

    public M4ccbCvDocTrabPK() {
    }

    public M4ccbCvDocTrabPK(String idOrganization, short ccbOrDocTrab, String stdIdHr) {
        this.idOrganization = idOrganization;
        this.ccbOrDocTrab = ccbOrDocTrab;
        this.stdIdHr = stdIdHr;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public short getCcbOrDocTrab() {
        return ccbOrDocTrab;
    }

    public void setCcbOrDocTrab(short ccbOrDocTrab) {
        this.ccbOrDocTrab = ccbOrDocTrab;
    }

    public String getStdIdHr() {
        return stdIdHr;
    }

    public void setStdIdHr(String stdIdHr) {
        this.stdIdHr = stdIdHr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (int) ccbOrDocTrab;
        hash += (stdIdHr != null ? stdIdHr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvDocTrabPK)) {
            return false;
        }
        M4ccbCvDocTrabPK other = (M4ccbCvDocTrabPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if (this.ccbOrDocTrab != other.ccbOrDocTrab) {
            return false;
        }
        if ((this.stdIdHr == null && other.stdIdHr != null) || (this.stdIdHr != null && !this.stdIdHr.equals(other.stdIdHr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4ccbCvDocTrabPK[ idOrganization=" + idOrganization + ", ccbOrDocTrab=" + ccbOrDocTrab + ", stdIdHr=" + stdIdHr + " ]";
    }
    
}
