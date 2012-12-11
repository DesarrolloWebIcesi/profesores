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
@Table(name = "STD_EXTERNAL_ORG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdExternalOrg.findAll", query = "SELECT s FROM StdExternalOrg s"),
    @NamedQuery(name = "StdExternalOrg.findByIdOrganization", query = "SELECT s FROM StdExternalOrg s WHERE s.stdExternalOrgPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdExternalOrg.findByStdIdExternOrg", query = "SELECT s FROM StdExternalOrg s WHERE s.stdExternalOrgPK.stdIdExternOrg = :stdIdExternOrg"),
    @NamedQuery(name = "StdExternalOrg.findByStdNExtOrgeng", query = "SELECT s FROM StdExternalOrg s WHERE s.stdNExtOrgeng = :stdNExtOrgeng"),
    @NamedQuery(name = "StdExternalOrg.findByStdNExtOrgesp", query = "SELECT s FROM StdExternalOrg s WHERE s.stdNExtOrgesp = :stdNExtOrgesp"),
    @NamedQuery(name = "StdExternalOrg.findByStdNExtOrgfra", query = "SELECT s FROM StdExternalOrg s WHERE s.stdNExtOrgfra = :stdNExtOrgfra"),
    @NamedQuery(name = "StdExternalOrg.findByStdNExtOrgger", query = "SELECT s FROM StdExternalOrg s WHERE s.stdNExtOrgger = :stdNExtOrgger"),
    @NamedQuery(name = "StdExternalOrg.findByStdNExtOrgbra", query = "SELECT s FROM StdExternalOrg s WHERE s.stdNExtOrgbra = :stdNExtOrgbra"),
    @NamedQuery(name = "StdExternalOrg.findByStdNExtOrgita", query = "SELECT s FROM StdExternalOrg s WHERE s.stdNExtOrgita = :stdNExtOrgita"),
    @NamedQuery(name = "StdExternalOrg.findByStdNExtOrggen", query = "SELECT s FROM StdExternalOrg s WHERE s.stdNExtOrggen = :stdNExtOrggen"),
    @NamedQuery(name = "StdExternalOrg.findByIdApprole", query = "SELECT s FROM StdExternalOrg s WHERE s.idApprole = :idApprole"),
    @NamedQuery(name = "StdExternalOrg.findByIdSecuser", query = "SELECT s FROM StdExternalOrg s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdExternalOrg.findByStdDtStart", query = "SELECT s FROM StdExternalOrg s WHERE s.stdDtStart = :stdDtStart"),
    @NamedQuery(name = "StdExternalOrg.findByDtLastUpdate", query = "SELECT s FROM StdExternalOrg s WHERE s.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "StdExternalOrg.findByStdDtEnd", query = "SELECT s FROM StdExternalOrg s WHERE s.stdDtEnd = :stdDtEnd"),
    @NamedQuery(name = "StdExternalOrg.findByStdIdExtHolding", query = "SELECT s FROM StdExternalOrg s WHERE s.stdIdExtHolding = :stdIdExtHolding"),
    @NamedQuery(name = "StdExternalOrg.findByScoHttpPath", query = "SELECT s FROM StdExternalOrg s WHERE s.scoHttpPath = :scoHttpPath"),
    @NamedQuery(name = "StdExternalOrg.findByStdComment", query = "SELECT s FROM StdExternalOrg s WHERE s.stdComment = :stdComment"),
    @NamedQuery(name = "StdExternalOrg.findByScoIdLegal", query = "SELECT s FROM StdExternalOrg s WHERE s.scoIdLegal = :scoIdLegal"),
    @NamedQuery(name = "StdExternalOrg.findByScbNit", query = "SELECT s FROM StdExternalOrg s WHERE s.scbNit = :scbNit"),
    @NamedQuery(name = "StdExternalOrg.findByScbDigVerif", query = "SELECT s FROM StdExternalOrg s WHERE s.scbDigVerif = :scbDigVerif")})
public class StdExternalOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdExternalOrgPK stdExternalOrgPK;
    @Column(name = "STD_N_EXT_ORGENG")
    private String stdNExtOrgeng;
    @Column(name = "STD_N_EXT_ORGESP")
    private String stdNExtOrgesp;
    @Column(name = "STD_N_EXT_ORGFRA")
    private String stdNExtOrgfra;
    @Column(name = "STD_N_EXT_ORGGER")
    private String stdNExtOrgger;
    @Column(name = "STD_N_EXT_ORGBRA")
    private String stdNExtOrgbra;
    @Column(name = "STD_N_EXT_ORGITA")
    private String stdNExtOrgita;
    @Column(name = "STD_N_EXT_ORGGEN")
    private String stdNExtOrggen;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "STD_DT_START")
    @Temporal(TemporalType.DATE)
    private Date stdDtStart;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "STD_DT_END")
    @Temporal(TemporalType.DATE)
    private Date stdDtEnd;
    @Column(name = "STD_ID_EXT_HOLDING")
    private String stdIdExtHolding;
    @Column(name = "SCO_HTTP_PATH")
    private String scoHttpPath;
    @Column(name = "STD_COMMENT")
    private String stdComment;
    @Column(name = "SCO_ID_LEGAL")
    private String scoIdLegal;
    @Column(name = "SCB_NIT")
    private String scbNit;
    @Column(name = "SCB_DIG_VERIF")
    private String scbDigVerif;

    public StdExternalOrg() {
    }

    public StdExternalOrg(StdExternalOrgPK stdExternalOrgPK) {
        this.stdExternalOrgPK = stdExternalOrgPK;
    }

    public StdExternalOrg(String idOrganization, String stdIdExternOrg) {
        this.stdExternalOrgPK = new StdExternalOrgPK(idOrganization, stdIdExternOrg);
    }

    public StdExternalOrgPK getStdExternalOrgPK() {
        return stdExternalOrgPK;
    }

    public void setStdExternalOrgPK(StdExternalOrgPK stdExternalOrgPK) {
        this.stdExternalOrgPK = stdExternalOrgPK;
    }

    public String getStdNExtOrgeng() {
        return stdNExtOrgeng;
    }

    public void setStdNExtOrgeng(String stdNExtOrgeng) {
        this.stdNExtOrgeng = stdNExtOrgeng;
    }

    public String getStdNExtOrgesp() {
        return stdNExtOrgesp;
    }

    public void setStdNExtOrgesp(String stdNExtOrgesp) {
        this.stdNExtOrgesp = stdNExtOrgesp;
    }

    public String getStdNExtOrgfra() {
        return stdNExtOrgfra;
    }

    public void setStdNExtOrgfra(String stdNExtOrgfra) {
        this.stdNExtOrgfra = stdNExtOrgfra;
    }

    public String getStdNExtOrgger() {
        return stdNExtOrgger;
    }

    public void setStdNExtOrgger(String stdNExtOrgger) {
        this.stdNExtOrgger = stdNExtOrgger;
    }

    public String getStdNExtOrgbra() {
        return stdNExtOrgbra;
    }

    public void setStdNExtOrgbra(String stdNExtOrgbra) {
        this.stdNExtOrgbra = stdNExtOrgbra;
    }

    public String getStdNExtOrgita() {
        return stdNExtOrgita;
    }

    public void setStdNExtOrgita(String stdNExtOrgita) {
        this.stdNExtOrgita = stdNExtOrgita;
    }

    public String getStdNExtOrggen() {
        return stdNExtOrggen;
    }

    public void setStdNExtOrggen(String stdNExtOrggen) {
        this.stdNExtOrggen = stdNExtOrggen;
    }

    public String getIdApprole() {
        return idApprole;
    }

    public void setIdApprole(String idApprole) {
        this.idApprole = idApprole;
    }

    public String getIdSecuser() {
        return idSecuser;
    }

    public void setIdSecuser(String idSecuser) {
        this.idSecuser = idSecuser;
    }

    public Date getStdDtStart() {
        return stdDtStart;
    }

    public void setStdDtStart(Date stdDtStart) {
        this.stdDtStart = stdDtStart;
    }

    public Date getDtLastUpdate() {
        return dtLastUpdate;
    }

    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }

    public Date getStdDtEnd() {
        return stdDtEnd;
    }

    public void setStdDtEnd(Date stdDtEnd) {
        this.stdDtEnd = stdDtEnd;
    }

    public String getStdIdExtHolding() {
        return stdIdExtHolding;
    }

    public void setStdIdExtHolding(String stdIdExtHolding) {
        this.stdIdExtHolding = stdIdExtHolding;
    }

    public String getScoHttpPath() {
        return scoHttpPath;
    }

    public void setScoHttpPath(String scoHttpPath) {
        this.scoHttpPath = scoHttpPath;
    }

    public String getStdComment() {
        return stdComment;
    }

    public void setStdComment(String stdComment) {
        this.stdComment = stdComment;
    }

    public String getScoIdLegal() {
        return scoIdLegal;
    }

    public void setScoIdLegal(String scoIdLegal) {
        this.scoIdLegal = scoIdLegal;
    }

    public String getScbNit() {
        return scbNit;
    }

    public void setScbNit(String scbNit) {
        this.scbNit = scbNit;
    }

    public String getScbDigVerif() {
        return scbDigVerif;
    }

    public void setScbDigVerif(String scbDigVerif) {
        this.scbDigVerif = scbDigVerif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdExternalOrgPK != null ? stdExternalOrgPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdExternalOrg)) {
            return false;
        }
        StdExternalOrg other = (StdExternalOrg) object;
        if ((this.stdExternalOrgPK == null && other.stdExternalOrgPK != null) || (this.stdExternalOrgPK != null && !this.stdExternalOrgPK.equals(other.stdExternalOrgPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdExternalOrg[ stdExternalOrgPK=" + stdExternalOrgPK + " ]";
    }
    
}
