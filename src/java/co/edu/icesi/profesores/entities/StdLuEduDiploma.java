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
@Table(name = "STD_LU_EDU_DIPLOMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdLuEduDiploma.findAll", query = "SELECT s FROM StdLuEduDiploma s"),
    @NamedQuery(name = "StdLuEduDiploma.findByIdOrganization", query = "SELECT s FROM StdLuEduDiploma s WHERE s.stdLuEduDiplomaPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdLuEduDiploma.findByStdIdDiploma", query = "SELECT s FROM StdLuEduDiploma s WHERE s.stdLuEduDiplomaPK.stdIdDiploma = :stdIdDiploma"),
    @NamedQuery(name = "StdLuEduDiploma.findByStdNDiplomaeng", query = "SELECT s FROM StdLuEduDiploma s WHERE s.stdNDiplomaeng = :stdNDiplomaeng"),
    @NamedQuery(name = "StdLuEduDiploma.findByStdNDiplomabra", query = "SELECT s FROM StdLuEduDiploma s WHERE s.stdNDiplomabra = :stdNDiplomabra"),
    @NamedQuery(name = "StdLuEduDiploma.findByStdNDiplomaesp", query = "SELECT s FROM StdLuEduDiploma s WHERE s.stdNDiplomaesp = :stdNDiplomaesp"),
    @NamedQuery(name = "StdLuEduDiploma.findByStdNDiplomagen", query = "SELECT s FROM StdLuEduDiploma s WHERE s.stdNDiplomagen = :stdNDiplomagen"),
    @NamedQuery(name = "StdLuEduDiploma.findByStdNDiplomaita", query = "SELECT s FROM StdLuEduDiploma s WHERE s.stdNDiplomaita = :stdNDiplomaita"),
    @NamedQuery(name = "StdLuEduDiploma.findByStdNDiplomager", query = "SELECT s FROM StdLuEduDiploma s WHERE s.stdNDiplomager = :stdNDiplomager"),
    @NamedQuery(name = "StdLuEduDiploma.findByStdNDiplomafra", query = "SELECT s FROM StdLuEduDiploma s WHERE s.stdNDiplomafra = :stdNDiplomafra"),
    @NamedQuery(name = "StdLuEduDiploma.findByStdIdDipLevel", query = "SELECT s FROM StdLuEduDiploma s WHERE s.stdIdDipLevel = :stdIdDipLevel"),
    @NamedQuery(name = "StdLuEduDiploma.findByDtLastUpdate", query = "SELECT s FROM StdLuEduDiploma s WHERE s.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "StdLuEduDiploma.findByIdSecuser", query = "SELECT s FROM StdLuEduDiploma s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdLuEduDiploma.findByIdApprole", query = "SELECT s FROM StdLuEduDiploma s WHERE s.idApprole = :idApprole")})
public class StdLuEduDiploma implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdLuEduDiplomaPK stdLuEduDiplomaPK;
    @Column(name = "STD_N_DIPLOMAENG")
    private String stdNDiplomaeng;
    @Column(name = "STD_N_DIPLOMABRA")
    private String stdNDiplomabra;
    @Column(name = "STD_N_DIPLOMAESP")
    private String stdNDiplomaesp;
    @Column(name = "STD_N_DIPLOMAGEN")
    private String stdNDiplomagen;
    @Column(name = "STD_N_DIPLOMAITA")
    private String stdNDiplomaita;
    @Column(name = "STD_N_DIPLOMAGER")
    private String stdNDiplomager;
    @Column(name = "STD_N_DIPLOMAFRA")
    private String stdNDiplomafra;
    @Column(name = "STD_ID_DIP_LEVEL")
    private String stdIdDipLevel;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "ID_APPROLE")
    private String idApprole;

    public StdLuEduDiploma() {
    }

    public StdLuEduDiploma(StdLuEduDiplomaPK stdLuEduDiplomaPK) {
        this.stdLuEduDiplomaPK = stdLuEduDiplomaPK;
    }

    public StdLuEduDiploma(String idOrganization, String stdIdDiploma) {
        this.stdLuEduDiplomaPK = new StdLuEduDiplomaPK(idOrganization, stdIdDiploma);
    }

    public StdLuEduDiplomaPK getStdLuEduDiplomaPK() {
        return stdLuEduDiplomaPK;
    }

    public void setStdLuEduDiplomaPK(StdLuEduDiplomaPK stdLuEduDiplomaPK) {
        this.stdLuEduDiplomaPK = stdLuEduDiplomaPK;
    }

    public String getStdNDiplomaeng() {
        return stdNDiplomaeng;
    }

    public void setStdNDiplomaeng(String stdNDiplomaeng) {
        this.stdNDiplomaeng = stdNDiplomaeng;
    }

    public String getStdNDiplomabra() {
        return stdNDiplomabra;
    }

    public void setStdNDiplomabra(String stdNDiplomabra) {
        this.stdNDiplomabra = stdNDiplomabra;
    }

    public String getStdNDiplomaesp() {
        return stdNDiplomaesp;
    }

    public void setStdNDiplomaesp(String stdNDiplomaesp) {
        this.stdNDiplomaesp = stdNDiplomaesp;
    }

    public String getStdNDiplomagen() {
        return stdNDiplomagen;
    }

    public void setStdNDiplomagen(String stdNDiplomagen) {
        this.stdNDiplomagen = stdNDiplomagen;
    }

    public String getStdNDiplomaita() {
        return stdNDiplomaita;
    }

    public void setStdNDiplomaita(String stdNDiplomaita) {
        this.stdNDiplomaita = stdNDiplomaita;
    }

    public String getStdNDiplomager() {
        return stdNDiplomager;
    }

    public void setStdNDiplomager(String stdNDiplomager) {
        this.stdNDiplomager = stdNDiplomager;
    }

    public String getStdNDiplomafra() {
        return stdNDiplomafra;
    }

    public void setStdNDiplomafra(String stdNDiplomafra) {
        this.stdNDiplomafra = stdNDiplomafra;
    }

    public String getStdIdDipLevel() {
        return stdIdDipLevel;
    }

    public void setStdIdDipLevel(String stdIdDipLevel) {
        this.stdIdDipLevel = stdIdDipLevel;
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
        hash += (stdLuEduDiplomaPK != null ? stdLuEduDiplomaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdLuEduDiploma)) {
            return false;
        }
        StdLuEduDiploma other = (StdLuEduDiploma) object;
        if ((this.stdLuEduDiplomaPK == null && other.stdLuEduDiplomaPK != null) || (this.stdLuEduDiplomaPK != null && !this.stdLuEduDiplomaPK.equals(other.stdLuEduDiplomaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdLuEduDiploma[ stdLuEduDiplomaPK=" + stdLuEduDiplomaPK + " ]";
    }
    
}
