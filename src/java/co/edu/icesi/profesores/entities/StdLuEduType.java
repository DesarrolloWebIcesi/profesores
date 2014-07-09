/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1130619373
 */
@Entity
@Table(name = "STD_LU_EDU_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdLuEduType.findAll", query = "SELECT s FROM StdLuEduType s"),
    @NamedQuery(name = "StdLuEduType.findByIdOrganization", query = "SELECT s FROM StdLuEduType s WHERE s.stdLuEduTypePK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdLuEduType.findByStdIdEduType", query = "SELECT s FROM StdLuEduType s WHERE s.stdLuEduTypePK.stdIdEduType = :stdIdEduType"),
    @NamedQuery(name = "StdLuEduType.findByStdNEduTypebra", query = "SELECT s FROM StdLuEduType s WHERE s.stdNEduTypebra = :stdNEduTypebra"),
    @NamedQuery(name = "StdLuEduType.findByStdNEduTypeeng", query = "SELECT s FROM StdLuEduType s WHERE s.stdNEduTypeeng = :stdNEduTypeeng"),
    @NamedQuery(name = "StdLuEduType.findByStdNEduTypefra", query = "SELECT s FROM StdLuEduType s WHERE s.stdNEduTypefra = :stdNEduTypefra"),
    @NamedQuery(name = "StdLuEduType.findByStdNEduTypeger", query = "SELECT s FROM StdLuEduType s WHERE s.stdNEduTypeger = :stdNEduTypeger"),
    @NamedQuery(name = "StdLuEduType.findByStdNEduTypeita", query = "SELECT s FROM StdLuEduType s WHERE s.stdNEduTypeita = :stdNEduTypeita"),
    @NamedQuery(name = "StdLuEduType.findByStdNEduTypegen", query = "SELECT s FROM StdLuEduType s WHERE s.stdNEduTypegen = :stdNEduTypegen"),
    @NamedQuery(name = "StdLuEduType.findByStdNEduTypeesp", query = "SELECT s FROM StdLuEduType s WHERE s.stdNEduTypeesp = :stdNEduTypeesp"),
    @NamedQuery(name = "StdLuEduType.findByDtLastUpdate", query = "SELECT s FROM StdLuEduType s WHERE s.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "StdLuEduType.findByIdSecuser", query = "SELECT s FROM StdLuEduType s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdLuEduType.findByIdApprole", query = "SELECT s FROM StdLuEduType s WHERE s.idApprole = :idApprole")})
public class StdLuEduType implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdLuEduTypePK stdLuEduTypePK;
    @Column(name = "STD_N_EDU_TYPEBRA")
    private String stdNEduTypebra;
    @Column(name = "STD_N_EDU_TYPEENG")
    private String stdNEduTypeeng;
    @Column(name = "STD_N_EDU_TYPEFRA")
    private String stdNEduTypefra;
    @Column(name = "STD_N_EDU_TYPEGER")
    private String stdNEduTypeger;
    @Column(name = "STD_N_EDU_TYPEITA")
    private String stdNEduTypeita;
    @Column(name = "STD_N_EDU_TYPEGEN")
    private String stdNEduTypegen;
    @Column(name = "STD_N_EDU_TYPEESP")
    private String stdNEduTypeesp;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "ID_APPROLE")
    private String idApprole;

    public StdLuEduType() {
    }

    public StdLuEduType(StdLuEduTypePK stdLuEduTypePK) {
        this.stdLuEduTypePK = stdLuEduTypePK;
    }

    public StdLuEduType(String idOrganization, String stdIdEduType) {
        this.stdLuEduTypePK = new StdLuEduTypePK(idOrganization, stdIdEduType);
    }

    public StdLuEduTypePK getStdLuEduTypePK() {
        return stdLuEduTypePK;
    }

    public void setStdLuEduTypePK(StdLuEduTypePK stdLuEduTypePK) {
        this.stdLuEduTypePK = stdLuEduTypePK;
    }

    public String getStdNEduTypebra() {
        return stdNEduTypebra;
    }

    public void setStdNEduTypebra(String stdNEduTypebra) {
        this.stdNEduTypebra = stdNEduTypebra;
    }

    public String getStdNEduTypeeng() {
        return stdNEduTypeeng;
    }

    public void setStdNEduTypeeng(String stdNEduTypeeng) {
        this.stdNEduTypeeng = stdNEduTypeeng;
    }

    public String getStdNEduTypefra() {
        return stdNEduTypefra;
    }

    public void setStdNEduTypefra(String stdNEduTypefra) {
        this.stdNEduTypefra = stdNEduTypefra;
    }

    public String getStdNEduTypeger() {
        return stdNEduTypeger;
    }

    public void setStdNEduTypeger(String stdNEduTypeger) {
        this.stdNEduTypeger = stdNEduTypeger;
    }

    public String getStdNEduTypeita() {
        return stdNEduTypeita;
    }

    public void setStdNEduTypeita(String stdNEduTypeita) {
        this.stdNEduTypeita = stdNEduTypeita;
    }

    public String getStdNEduTypegen() {
        return stdNEduTypegen;
    }

    public void setStdNEduTypegen(String stdNEduTypegen) {
        this.stdNEduTypegen = stdNEduTypegen;
    }

    public String getStdNEduTypeesp() {
        return stdNEduTypeesp;
    }

    public void setStdNEduTypeesp(String stdNEduTypeesp) {
        this.stdNEduTypeesp = stdNEduTypeesp;
    }

    public Date getDtLastUpdate() {
        return dtLastUpdate;
    }

    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }

    public String getIdSecuser() {
        return idSecuser;
    }

    public void setIdSecuser(String idSecuser) {
        this.idSecuser = idSecuser;
    }

    public String getIdApprole() {
        return idApprole;
    }

    public void setIdApprole(String idApprole) {
        this.idApprole = idApprole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdLuEduTypePK != null ? stdLuEduTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdLuEduType)) {
            return false;
        }
        StdLuEduType other = (StdLuEduType) object;
        if ((this.stdLuEduTypePK == null && other.stdLuEduTypePK != null) || (this.stdLuEduTypePK != null && !this.stdLuEduTypePK.equals(other.stdLuEduTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdLuEduType[ stdLuEduTypePK=" + stdLuEduTypePK + " ]";
    }
    
}
