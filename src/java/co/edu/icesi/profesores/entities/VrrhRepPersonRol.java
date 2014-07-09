/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An instance of this class represents a registry in the VRRH_REP_PERSON_ROL view
 * 
 * @author David Andrés Manzano Herrera - damanzano
 * @since 2012-12-10 Created
 */
@Entity
@Table(name = "VRRH_REP_PERSON_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VrrhRepPersonRol.findAll", query = "SELECT s FROM VrrhCursosProf s"),
    @NamedQuery(name = "VrrhRepPersonRol.findByStdIdPerson", query = "SELECT DISTINCT s FROM VrrhRepPersonRol s WHERE s.vrrhRepPersonRolPK.stdIdPerson = :stdIdPerson")
})
public class VrrhRepPersonRol implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected VrrhRepPersonRolPK vrrhRepPersonRolPK;    
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Column(name = "CORREO_ICESI")
    private String correoIcesi;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "CORREO_LIVEEDU")
    private String correoLiveedu;
    @Column(name = "CORREO_PERSONAL")
    private String correoPersonal;
    @Column(name = "ORGANIZACION")
    private String organizacion;
    @Column(name = "NOMBRE_FAMILIA_INTERNA")
    private String nombreFamiliaInterna;
    @Column(name = "ROL")
    private String rol;
    @Column(name = "DESC_UNIDAD_ORGA")
    private String descUnidadOrga;
    @Column(name = "TIPO_UNIDAD_ORGA")
    private String tipoUnidadOrga;
    @Column(name = "PADRE_UNIDAD_ORGA")
    private String padreUnidadOrga;
    @Column(name = "DESC_PADRE_UNI_ORGA")
    private String descPadreUnidadOrga;
    @Column(name = "TIPO_PADRE_UNI_ORGA")
    private String tipoPadreUnidadOrga;
    @Column(name = "MODALIDAD")
    private String modalidad;

    public VrrhRepPersonRol() {
    }

    public VrrhRepPersonRol(VrrhRepPersonRolPK vrrhRepPersonRolPK) {
        this.vrrhRepPersonRolPK = vrrhRepPersonRolPK;
    }
    
    public VrrhRepPersonRol(String stdIdPerson, String unidadOrganizativa) {
        this.vrrhRepPersonRolPK = new VrrhRepPersonRolPK(stdIdPerson, unidadOrganizativa);
    }

    public VrrhRepPersonRolPK getVrrhRepPersonRolPK() {
        return vrrhRepPersonRolPK;
    }

    public void setVrrhRepPersonRolPK(VrrhRepPersonRolPK vrrhRepPersonRolPK) {
        this.vrrhRepPersonRolPK = vrrhRepPersonRolPK;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreoIcesi() {
        return correoIcesi;
    }

    public void setCorreoIcesi(String correoIcesi) {
        this.correoIcesi = correoIcesi;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreoLiveedu() {
        return correoLiveedu;
    }

    public void setCorreoLiveedu(String correoLiveedu) {
        this.correoLiveedu = correoLiveedu;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getNombreFamiliaInterna() {
        return nombreFamiliaInterna;
    }

    public void setNombreFamiliaInterna(String nombreFamiliaInterna) {
        this.nombreFamiliaInterna = nombreFamiliaInterna;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescUnidadOrga() {
        return descUnidadOrga;
    }

    public void setDescUnidadOrga(String descUnidadOrga) {
        this.descUnidadOrga = descUnidadOrga;
    }

    public String getTipoUnidadOrga() {
        return tipoUnidadOrga;
    }

    public void setTipoUnidadOrga(String tipoUnidadOrga) {
        this.tipoUnidadOrga = tipoUnidadOrga;
    }

    public String getPadreUnidadOrga() {
        return padreUnidadOrga;
    }

    public void setPadreUnidadOrga(String padreUnidadOrga) {
        this.padreUnidadOrga = padreUnidadOrga;
    }

    public String getDescPadreUnidadOrga() {
        return descPadreUnidadOrga;
    }

    public void setDescPadreUnidadOrga(String descPadreUnidadOrga) {
        this.descPadreUnidadOrga = descPadreUnidadOrga;
    }

    public String getTipoPadreUnidadOrga() {
        return tipoPadreUnidadOrga;
    }

    public void setTipoPadreUnidadOrga(String tipoPadreUnidadOrga) {
        this.tipoPadreUnidadOrga = tipoPadreUnidadOrga;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vrrhRepPersonRolPK != null ? vrrhRepPersonRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
       if (!(object instanceof VrrhRepPersonRol)) {
            return false;
        }
        VrrhRepPersonRol other = (VrrhRepPersonRol) object;
        if ((this.vrrhRepPersonRolPK == null && other.vrrhRepPersonRolPK != null) || (this.vrrhRepPersonRolPK != null && !this.vrrhRepPersonRolPK.equals(other.vrrhRepPersonRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.VrrhRepPersonRol[ vrrhRepPersonRolPK=" + vrrhRepPersonRolPK + " ]";
        
    }
    
}
