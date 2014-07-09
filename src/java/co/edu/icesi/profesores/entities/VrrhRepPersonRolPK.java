/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Identifier of VrrhRepPersonRol Objects
 *
 * @author David Andrés Manzano Herrera - damanzano
 */
@Embeddable
public class VrrhRepPersonRolPK implements Serializable {

    @Column(name = "STD_ID_PERSON")
    private String stdIdPerson;
    @Column(name = "UNIDAD_ORGANIZATIVA")
    private String unidadOrganizativa;
    @Column(name = "FAMILIA_INTERNA")
    private String familiaInterna;

    public VrrhRepPersonRolPK() {
    }

    public VrrhRepPersonRolPK(String stdIdPerson, String unidadOrganizativa) {
        this.stdIdPerson = stdIdPerson;
        this.unidadOrganizativa = unidadOrganizativa;
    }

    public String getStdIdPerson() {
        return stdIdPerson;
    }

    public void setStdIdPerson(String stdIdPerson) {
        this.stdIdPerson = stdIdPerson;
    }

    public String getUnidadOrganizativa() {
        return unidadOrganizativa;
    }

    public void setUnidadOrganizativa(String unidadOrganizativa) {
        this.unidadOrganizativa = unidadOrganizativa;
    }

    public String getFamiliaInterna() {
        return familiaInterna;
    }

    public void setFamiliaInterna(String familiaInterna) {
        this.familiaInterna = familiaInterna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdIdPerson != null ? stdIdPerson.hashCode() : 0);
        hash += (unidadOrganizativa != null ? unidadOrganizativa.hashCode() : 0);
        hash += (familiaInterna != null ? familiaInterna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VrrhRepPersonRolPK)) {
            return false;
        }
        VrrhRepPersonRolPK other = (VrrhRepPersonRolPK) object;
        if ((this.unidadOrganizativa == null && other.unidadOrganizativa != null) || (this.unidadOrganizativa != null && !this.unidadOrganizativa.equals(other.unidadOrganizativa))) {
            return false;
        }
        if ((this.stdIdPerson == null && other.stdIdPerson != null) || (this.stdIdPerson != null && !this.stdIdPerson.equals(other.stdIdPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "co.edu.icesi.profesores.entities.VrrhRepPersonRol[ id=" + id + " ]";
        return "string";
    }
}
