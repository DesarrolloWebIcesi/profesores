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
@Table(name = "STD_LU_WU_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdLuWuType.findAll", query = "SELECT s FROM StdLuWuType s"),
    @NamedQuery(name = "StdLuWuType.findByIdOrganization", query = "SELECT s FROM StdLuWuType s WHERE s.stdLuWuTypePK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdLuWuType.findByStdIdWuType", query = "SELECT s FROM StdLuWuType s WHERE s.stdLuWuTypePK.stdIdWuType = :stdIdWuType"),
    @NamedQuery(name = "StdLuWuType.findByStdNWuTypeesp", query = "SELECT s FROM StdLuWuType s WHERE s.stdNWuTypeesp = :stdNWuTypeesp"),
    @NamedQuery(name = "StdLuWuType.findByStdNWuTypeeng", query = "SELECT s FROM StdLuWuType s WHERE s.stdNWuTypeeng = :stdNWuTypeeng"),
    @NamedQuery(name = "StdLuWuType.findByStdNWuTypebra", query = "SELECT s FROM StdLuWuType s WHERE s.stdNWuTypebra = :stdNWuTypebra"),
    @NamedQuery(name = "StdLuWuType.findByStdNWuTypefra", query = "SELECT s FROM StdLuWuType s WHERE s.stdNWuTypefra = :stdNWuTypefra"),
    @NamedQuery(name = "StdLuWuType.findByStdNWuTypeger", query = "SELECT s FROM StdLuWuType s WHERE s.stdNWuTypeger = :stdNWuTypeger"),
    @NamedQuery(name = "StdLuWuType.findByStdNWuTypeita", query = "SELECT s FROM StdLuWuType s WHERE s.stdNWuTypeita = :stdNWuTypeita"),
    @NamedQuery(name = "StdLuWuType.findByStdNWuTypegen", query = "SELECT s FROM StdLuWuType s WHERE s.stdNWuTypegen = :stdNWuTypegen"),
    @NamedQuery(name = "StdLuWuType.findByStdIdWuIntType", query = "SELECT s FROM StdLuWuType s WHERE s.stdIdWuIntType = :stdIdWuIntType"),
    @NamedQuery(name = "StdLuWuType.findByStdComment", query = "SELECT s FROM StdLuWuType s WHERE s.stdComment = :stdComment"),
    @NamedQuery(name = "StdLuWuType.findByDtLastUpdate", query = "SELECT s FROM StdLuWuType s WHERE s.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "StdLuWuType.findByIdSecuser", query = "SELECT s FROM StdLuWuType s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdLuWuType.findByIdApprole", query = "SELECT s FROM StdLuWuType s WHERE s.idApprole = :idApprole")})
public class StdLuWuType implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdLuWuTypePK stdLuWuTypePK;
    @Column(name = "STD_N_WU_TYPEESP")
    private String stdNWuTypeesp;
    @Column(name = "STD_N_WU_TYPEENG")
    private String stdNWuTypeeng;
    @Column(name = "STD_N_WU_TYPEBRA")
    private String stdNWuTypebra;
    @Column(name = "STD_N_WU_TYPEFRA")
    private String stdNWuTypefra;
    @Column(name = "STD_N_WU_TYPEGER")
    private String stdNWuTypeger;
    @Column(name = "STD_N_WU_TYPEITA")
    private String stdNWuTypeita;
    @Column(name = "STD_N_WU_TYPEGEN")
    private String stdNWuTypegen;
    @Column(name = "STD_ID_WU_INT_TYPE")
    private String stdIdWuIntType;
    @Column(name = "STD_COMMENT")
    private String stdComment;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "ID_APPROLE")
    private String idApprole;

    public StdLuWuType() {
    }

    public StdLuWuType(StdLuWuTypePK stdLuWuTypePK) {
        this.stdLuWuTypePK = stdLuWuTypePK;
    }

    public StdLuWuType(String idOrganization, String stdIdWuType) {
        this.stdLuWuTypePK = new StdLuWuTypePK(idOrganization, stdIdWuType);
    }

    public StdLuWuTypePK getStdLuWuTypePK() {
        return stdLuWuTypePK;
    }

    public void setStdLuWuTypePK(StdLuWuTypePK stdLuWuTypePK) {
        this.stdLuWuTypePK = stdLuWuTypePK;
    }

    public String getStdNWuTypeesp() {
        return stdNWuTypeesp;
    }

    public void setStdNWuTypeesp(String stdNWuTypeesp) {
        this.stdNWuTypeesp = stdNWuTypeesp;
    }

    public String getStdNWuTypeeng() {
        return stdNWuTypeeng;
    }

    public void setStdNWuTypeeng(String stdNWuTypeeng) {
        this.stdNWuTypeeng = stdNWuTypeeng;
    }

    public String getStdNWuTypebra() {
        return stdNWuTypebra;
    }

    public void setStdNWuTypebra(String stdNWuTypebra) {
        this.stdNWuTypebra = stdNWuTypebra;
    }

    public String getStdNWuTypefra() {
        return stdNWuTypefra;
    }

    public void setStdNWuTypefra(String stdNWuTypefra) {
        this.stdNWuTypefra = stdNWuTypefra;
    }

    public String getStdNWuTypeger() {
        return stdNWuTypeger;
    }

    public void setStdNWuTypeger(String stdNWuTypeger) {
        this.stdNWuTypeger = stdNWuTypeger;
    }

    public String getStdNWuTypeita() {
        return stdNWuTypeita;
    }

    public void setStdNWuTypeita(String stdNWuTypeita) {
        this.stdNWuTypeita = stdNWuTypeita;
    }

    public String getStdNWuTypegen() {
        return stdNWuTypegen;
    }

    public void setStdNWuTypegen(String stdNWuTypegen) {
        this.stdNWuTypegen = stdNWuTypegen;
    }

    public String getStdIdWuIntType() {
        return stdIdWuIntType;
    }

    public void setStdIdWuIntType(String stdIdWuIntType) {
        this.stdIdWuIntType = stdIdWuIntType;
    }

    public String getStdComment() {
        return stdComment;
    }

    public void setStdComment(String stdComment) {
        this.stdComment = stdComment;
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
        hash += (stdLuWuTypePK != null ? stdLuWuTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdLuWuType)) {
            return false;
        }
        StdLuWuType other = (StdLuWuType) object;
        if ((this.stdLuWuTypePK == null && other.stdLuWuTypePK != null) || (this.stdLuWuTypePK != null && !this.stdLuWuTypePK.equals(other.stdLuWuTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdLuWuType[ stdLuWuTypePK=" + stdLuWuTypePK + " ]";
    }
    
}
