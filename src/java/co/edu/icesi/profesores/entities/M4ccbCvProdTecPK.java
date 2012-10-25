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
 * @author 14620701
 */
@Embeddable
public class M4ccbCvProdTecPK implements Serializable {
    
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "CCB_OR_PROD_TEC")
    private short ccbOrProdTec;
    @Basic(optional = false)
    @Column(name = "STD_ID_HR")
    private String stdIdHr;

    public M4ccbCvProdTecPK() {
    }

    public M4ccbCvProdTecPK(String idOrganization, short ccbOrProdTec, String stdIdHr) {
        this.idOrganization = idOrganization;
        this.ccbOrProdTec = ccbOrProdTec;
        this.stdIdHr = stdIdHr;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public short getCcbOrProdTec() {
        return ccbOrProdTec;
    }

    public void setCcbOrProdTec(short ccbOrProdTec) {
        this.ccbOrProdTec = ccbOrProdTec;
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
        hash += (int) ccbOrProdTec;
        hash += (stdIdHr != null ? stdIdHr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvProdTecPK)) {
            return false;
        }
        M4ccbCvProdTecPK other = (M4ccbCvProdTecPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if (this.ccbOrProdTec != other.ccbOrProdTec) {
            return false;
        }
        if ((this.stdIdHr == null && other.stdIdHr != null) || (this.stdIdHr != null && !this.stdIdHr.equals(other.stdIdHr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4ccbCvProdTecPK[ idOrganization=" + idOrganization + ", ccbOrProdTec=" + ccbOrProdTec + ", stdIdHr=" + stdIdHr + " ]";
    }
    
}
