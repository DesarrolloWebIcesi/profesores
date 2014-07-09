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
@Table(name = "STD_LU_EDU_SPECIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdLuEduSpecial.findAll", query = "SELECT s FROM StdLuEduSpecial s"),
    @NamedQuery(name = "StdLuEduSpecial.findByIdOrganization", query = "SELECT s FROM StdLuEduSpecial s WHERE s.stdLuEduSpecialPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdLuEduSpecial.findByStdIdEduSp", query = "SELECT s FROM StdLuEduSpecial s WHERE s.stdLuEduSpecialPK.stdIdEduSp = :stdIdEduSp"),
    @NamedQuery(name = "StdLuEduSpecial.findByStdNEduSpbra", query = "SELECT s FROM StdLuEduSpecial s WHERE s.stdNEduSpbra = :stdNEduSpbra"),
    @NamedQuery(name = "StdLuEduSpecial.findByStdNEduSpeng", query = "SELECT s FROM StdLuEduSpecial s WHERE s.stdNEduSpeng = :stdNEduSpeng"),
    @NamedQuery(name = "StdLuEduSpecial.findByStdNEduSpfra", query = "SELECT s FROM StdLuEduSpecial s WHERE s.stdNEduSpfra = :stdNEduSpfra"),
    @NamedQuery(name = "StdLuEduSpecial.findByStdNEduSpger", query = "SELECT s FROM StdLuEduSpecial s WHERE s.stdNEduSpger = :stdNEduSpger"),
    @NamedQuery(name = "StdLuEduSpecial.findByStdNEduSpita", query = "SELECT s FROM StdLuEduSpecial s WHERE s.stdNEduSpita = :stdNEduSpita"),
    @NamedQuery(name = "StdLuEduSpecial.findByStdNEduSpgen", query = "SELECT s FROM StdLuEduSpecial s WHERE s.stdNEduSpgen = :stdNEduSpgen"),
    @NamedQuery(name = "StdLuEduSpecial.findByStdNEduSpesp", query = "SELECT s FROM StdLuEduSpecial s WHERE s.stdNEduSpesp = :stdNEduSpesp"),
    @NamedQuery(name = "StdLuEduSpecial.findByDtLastUpdate", query = "SELECT s FROM StdLuEduSpecial s WHERE s.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "StdLuEduSpecial.findByIdSecuser", query = "SELECT s FROM StdLuEduSpecial s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdLuEduSpecial.findByIdApprole", query = "SELECT s FROM StdLuEduSpecial s WHERE s.idApprole = :idApprole")})
public class StdLuEduSpecial implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdLuEduSpecialPK stdLuEduSpecialPK;
    @Column(name = "STD_N_EDU_SPBRA")
    private String stdNEduSpbra;
    @Column(name = "STD_N_EDU_SPENG")
    private String stdNEduSpeng;
    @Column(name = "STD_N_EDU_SPFRA")
    private String stdNEduSpfra;
    @Column(name = "STD_N_EDU_SPGER")
    private String stdNEduSpger;
    @Column(name = "STD_N_EDU_SPITA")
    private String stdNEduSpita;
    @Column(name = "STD_N_EDU_SPGEN")
    private String stdNEduSpgen;
    @Column(name = "STD_N_EDU_SPESP")
    private String stdNEduSpesp;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "ID_APPROLE")
    private String idApprole;

    public StdLuEduSpecial() {
    }

    public StdLuEduSpecial(StdLuEduSpecialPK stdLuEduSpecialPK) {
        this.stdLuEduSpecialPK = stdLuEduSpecialPK;
    }

    public StdLuEduSpecial(String idOrganization, String stdIdEduSp) {
        this.stdLuEduSpecialPK = new StdLuEduSpecialPK(idOrganization, stdIdEduSp);
    }

    public StdLuEduSpecialPK getStdLuEduSpecialPK() {
        return stdLuEduSpecialPK;
    }

    public void setStdLuEduSpecialPK(StdLuEduSpecialPK stdLuEduSpecialPK) {
        this.stdLuEduSpecialPK = stdLuEduSpecialPK;
    }

    public String getStdNEduSpbra() {
        return stdNEduSpbra;
    }

    public void setStdNEduSpbra(String stdNEduSpbra) {
        this.stdNEduSpbra = stdNEduSpbra;
    }

    public String getStdNEduSpeng() {
        return stdNEduSpeng;
    }

    public void setStdNEduSpeng(String stdNEduSpeng) {
        this.stdNEduSpeng = stdNEduSpeng;
    }

    public String getStdNEduSpfra() {
        return stdNEduSpfra;
    }

    public void setStdNEduSpfra(String stdNEduSpfra) {
        this.stdNEduSpfra = stdNEduSpfra;
    }

    public String getStdNEduSpger() {
        return stdNEduSpger;
    }

    public void setStdNEduSpger(String stdNEduSpger) {
        this.stdNEduSpger = stdNEduSpger;
    }

    public String getStdNEduSpita() {
        return stdNEduSpita;
    }

    public void setStdNEduSpita(String stdNEduSpita) {
        this.stdNEduSpita = stdNEduSpita;
    }

    public String getStdNEduSpgen() {
        return stdNEduSpgen;
    }

    public void setStdNEduSpgen(String stdNEduSpgen) {
        this.stdNEduSpgen = stdNEduSpgen;
    }

    public String getStdNEduSpesp() {
        return stdNEduSpesp;
    }

    public void setStdNEduSpesp(String stdNEduSpesp) {
        this.stdNEduSpesp = stdNEduSpesp;
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
        hash += (stdLuEduSpecialPK != null ? stdLuEduSpecialPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdLuEduSpecial)) {
            return false;
        }
        StdLuEduSpecial other = (StdLuEduSpecial) object;
        if ((this.stdLuEduSpecialPK == null && other.stdLuEduSpecialPK != null) || (this.stdLuEduSpecialPK != null && !this.stdLuEduSpecialPK.equals(other.stdLuEduSpecialPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdLuEduSpecial[ stdLuEduSpecialPK=" + stdLuEduSpecialPK + " ]";
    }
    
}
