/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1130619373
 */
@Entity
@Table(name = "M4SCO_POSITION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4scoPosition.findAll", query = "SELECT m FROM M4scoPosition m"),
    @NamedQuery(name = "M4scoPosition.findByIdOrganization", query = "SELECT m FROM M4scoPosition m WHERE m.m4scoPositionPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4scoPosition.findByScoIdPosition", query = "SELECT m FROM M4scoPosition m WHERE m.m4scoPositionPK.scoIdPosition = :scoIdPosition"),
    @NamedQuery(name = "M4scoPosition.findByScoNmPositionbra", query = "SELECT m FROM M4scoPosition m WHERE m.scoNmPositionbra = :scoNmPositionbra"),
    @NamedQuery(name = "M4scoPosition.findByScoNmPositioneng", query = "SELECT m FROM M4scoPosition m WHERE m.scoNmPositioneng = :scoNmPositioneng"),
    @NamedQuery(name = "M4scoPosition.findByScoNmPositionesp", query = "SELECT m FROM M4scoPosition m WHERE m.scoNmPositionesp = :scoNmPositionesp"),
    @NamedQuery(name = "M4scoPosition.findByScoNmPositionfra", query = "SELECT m FROM M4scoPosition m WHERE m.scoNmPositionfra = :scoNmPositionfra"),
    @NamedQuery(name = "M4scoPosition.findByScoNmPositiongen", query = "SELECT m FROM M4scoPosition m WHERE m.scoNmPositiongen = :scoNmPositiongen"),
    @NamedQuery(name = "M4scoPosition.findByScoNmPositionger", query = "SELECT m FROM M4scoPosition m WHERE m.scoNmPositionger = :scoNmPositionger"),
    @NamedQuery(name = "M4scoPosition.findByScoNmPositionita", query = "SELECT m FROM M4scoPosition m WHERE m.scoNmPositionita = :scoNmPositionita"),
    @NamedQuery(name = "M4scoPosition.findByScoDtStart", query = "SELECT m FROM M4scoPosition m WHERE m.scoDtStart = :scoDtStart"),
    @NamedQuery(name = "M4scoPosition.findByScoDtEnd", query = "SELECT m FROM M4scoPosition m WHERE m.scoDtEnd = :scoDtEnd"),
    @NamedQuery(name = "M4scoPosition.findByScoIdJobCode", query = "SELECT m FROM M4scoPosition m WHERE m.scoIdJobCode = :scoIdJobCode"),
    @NamedQuery(name = "M4scoPosition.findByScoIdWorkLoc", query = "SELECT m FROM M4scoPosition m WHERE m.scoIdWorkLoc = :scoIdWorkLoc"),
    @NamedQuery(name = "M4scoPosition.findByScoIdWorkUnit", query = "SELECT m FROM M4scoPosition m WHERE m.scoIdWorkUnit = :scoIdWorkUnit"),
    @NamedQuery(name = "M4scoPosition.findByScoIdTempReg", query = "SELECT m FROM M4scoPosition m WHERE m.scoIdTempReg = :scoIdTempReg"),
    @NamedQuery(name = "M4scoPosition.findByScoMultipleFil", query = "SELECT m FROM M4scoPosition m WHERE m.scoMultipleFil = :scoMultipleFil"),
    @NamedQuery(name = "M4scoPosition.findByScoPosWHours", query = "SELECT m FROM M4scoPosition m WHERE m.scoPosWHours = :scoPosWHours"),
    @NamedQuery(name = "M4scoPosition.findByScoFullTime", query = "SELECT m FROM M4scoPosition m WHERE m.scoFullTime = :scoFullTime"),
    @NamedQuery(name = "M4scoPosition.findByScoIsRoot", query = "SELECT m FROM M4scoPosition m WHERE m.scoIsRoot = :scoIsRoot"),
    @NamedQuery(name = "M4scoPosition.findByScoPositionPath", query = "SELECT m FROM M4scoPosition m WHERE m.scoPositionPath = :scoPositionPath"),
    @NamedQuery(name = "M4scoPosition.findByScoDescriptionbra", query = "SELECT m FROM M4scoPosition m WHERE m.scoDescriptionbra = :scoDescriptionbra"),
    @NamedQuery(name = "M4scoPosition.findByScoDescriptioneng", query = "SELECT m FROM M4scoPosition m WHERE m.scoDescriptioneng = :scoDescriptioneng"),
    @NamedQuery(name = "M4scoPosition.findByScoDescriptionesp", query = "SELECT m FROM M4scoPosition m WHERE m.scoDescriptionesp = :scoDescriptionesp"),
    @NamedQuery(name = "M4scoPosition.findByScoDescriptionfra", query = "SELECT m FROM M4scoPosition m WHERE m.scoDescriptionfra = :scoDescriptionfra"),
    @NamedQuery(name = "M4scoPosition.findByScoDescriptiongen", query = "SELECT m FROM M4scoPosition m WHERE m.scoDescriptiongen = :scoDescriptiongen"),
    @NamedQuery(name = "M4scoPosition.findByScoDescriptionger", query = "SELECT m FROM M4scoPosition m WHERE m.scoDescriptionger = :scoDescriptionger"),
    @NamedQuery(name = "M4scoPosition.findByScoDescriptionita", query = "SELECT m FROM M4scoPosition m WHERE m.scoDescriptionita = :scoDescriptionita"),
    @NamedQuery(name = "M4scoPosition.findBySukCostCentreId", query = "SELECT m FROM M4scoPosition m WHERE m.sukCostCentreId = :sukCostCentreId"),
    @NamedQuery(name = "M4scoPosition.findByIdApprole", query = "SELECT m FROM M4scoPosition m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4scoPosition.findByScoKeyPosition", query = "SELECT m FROM M4scoPosition m WHERE m.scoKeyPosition = :scoKeyPosition"),
    @NamedQuery(name = "M4scoPosition.findByIdSecuser", query = "SELECT m FROM M4scoPosition m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4scoPosition.findByDtLastUpdate", query = "SELECT m FROM M4scoPosition m WHERE m.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "M4scoPosition.findByCcbConsecutivo", query = "SELECT m FROM M4scoPosition m WHERE m.ccbConsecutivo = :ccbConsecutivo"),
    @NamedQuery(name = "M4scoPosition.findByScbIdCentroCost", query = "SELECT m FROM M4scoPosition m WHERE m.scbIdCentroCost = :scbIdCentroCost")})
public class M4scoPosition implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4scoPositionPK m4scoPositionPK;
    @Column(name = "SCO_NM_POSITIONBRA")
    private String scoNmPositionbra;
    @Column(name = "SCO_NM_POSITIONENG")
    private String scoNmPositioneng;
    @Column(name = "SCO_NM_POSITIONESP")
    private String scoNmPositionesp;
    @Column(name = "SCO_NM_POSITIONFRA")
    private String scoNmPositionfra;
    @Column(name = "SCO_NM_POSITIONGEN")
    private String scoNmPositiongen;
    @Column(name = "SCO_NM_POSITIONGER")
    private String scoNmPositionger;
    @Column(name = "SCO_NM_POSITIONITA")
    private String scoNmPositionita;
    @Column(name = "SCO_DT_START")
    @Temporal(TemporalType.DATE)
    private Date scoDtStart;
    @Column(name = "SCO_DT_END")
    @Temporal(TemporalType.DATE)
    private Date scoDtEnd;
    @Column(name = "SCO_ID_JOB_CODE")
    private String scoIdJobCode;
    @Column(name = "SCO_ID_WORK_LOC")
    private String scoIdWorkLoc;
    @Column(name = "SCO_ID_WORK_UNIT")
    private String scoIdWorkUnit;
    @Column(name = "SCO_ID_TEMP_REG")
    private String scoIdTempReg;
    @Column(name = "SCO_MULTIPLE_FIL")
    private String scoMultipleFil;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SCO_POS_W_HOURS")
    private BigDecimal scoPosWHours;
    @Column(name = "SCO_FULL_TIME")
    private String scoFullTime;
    @Column(name = "SCO_IS_ROOT")
    private Short scoIsRoot;
    @Column(name = "SCO_POSITION_PATH")
    private String scoPositionPath;
    @Column(name = "SCO_DESCRIPTIONBRA")
    private String scoDescriptionbra;
    @Column(name = "SCO_DESCRIPTIONENG")
    private String scoDescriptioneng;
    @Column(name = "SCO_DESCRIPTIONESP")
    private String scoDescriptionesp;
    @Column(name = "SCO_DESCRIPTIONFRA")
    private String scoDescriptionfra;
    @Column(name = "SCO_DESCRIPTIONGEN")
    private String scoDescriptiongen;
    @Column(name = "SCO_DESCRIPTIONGER")
    private String scoDescriptionger;
    @Column(name = "SCO_DESCRIPTIONITA")
    private String scoDescriptionita;
    @Column(name = "SUK_COST_CENTRE_ID")
    private String sukCostCentreId;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "SCO_KEY_POSITION")
    private String scoKeyPosition;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "CCB_CONSECUTIVO")
    private Integer ccbConsecutivo;
    @Column(name = "SCB_ID_CENTRO_COST")
    private String scbIdCentroCost;

    public M4scoPosition() {
    }

    public M4scoPosition(M4scoPositionPK m4scoPositionPK) {
        this.m4scoPositionPK = m4scoPositionPK;
    }

    public M4scoPosition(String idOrganization, String scoIdPosition) {
        this.m4scoPositionPK = new M4scoPositionPK(idOrganization, scoIdPosition);
    }

    public M4scoPositionPK getM4scoPositionPK() {
        return m4scoPositionPK;
    }

    public void setM4scoPositionPK(M4scoPositionPK m4scoPositionPK) {
        this.m4scoPositionPK = m4scoPositionPK;
    }

    public String getScoNmPositionbra() {
        return scoNmPositionbra;
    }

    public void setScoNmPositionbra(String scoNmPositionbra) {
        this.scoNmPositionbra = scoNmPositionbra;
    }

    public String getScoNmPositioneng() {
        return scoNmPositioneng;
    }

    public void setScoNmPositioneng(String scoNmPositioneng) {
        this.scoNmPositioneng = scoNmPositioneng;
    }

    public String getScoNmPositionesp() {
        return scoNmPositionesp;
    }

    public void setScoNmPositionesp(String scoNmPositionesp) {
        this.scoNmPositionesp = scoNmPositionesp;
    }

    public String getScoNmPositionfra() {
        return scoNmPositionfra;
    }

    public void setScoNmPositionfra(String scoNmPositionfra) {
        this.scoNmPositionfra = scoNmPositionfra;
    }

    public String getScoNmPositiongen() {
        return scoNmPositiongen;
    }

    public void setScoNmPositiongen(String scoNmPositiongen) {
        this.scoNmPositiongen = scoNmPositiongen;
    }

    public String getScoNmPositionger() {
        return scoNmPositionger;
    }

    public void setScoNmPositionger(String scoNmPositionger) {
        this.scoNmPositionger = scoNmPositionger;
    }

    public String getScoNmPositionita() {
        return scoNmPositionita;
    }

    public void setScoNmPositionita(String scoNmPositionita) {
        this.scoNmPositionita = scoNmPositionita;
    }

    public Date getScoDtStart() {
        return scoDtStart;
    }

    public void setScoDtStart(Date scoDtStart) {
        this.scoDtStart = scoDtStart;
    }

    public Date getScoDtEnd() {
        return scoDtEnd;
    }

    public void setScoDtEnd(Date scoDtEnd) {
        this.scoDtEnd = scoDtEnd;
    }

    public String getScoIdJobCode() {
        return scoIdJobCode;
    }

    public void setScoIdJobCode(String scoIdJobCode) {
        this.scoIdJobCode = scoIdJobCode;
    }

    public String getScoIdWorkLoc() {
        return scoIdWorkLoc;
    }

    public void setScoIdWorkLoc(String scoIdWorkLoc) {
        this.scoIdWorkLoc = scoIdWorkLoc;
    }

    public String getScoIdWorkUnit() {
        return scoIdWorkUnit;
    }

    public void setScoIdWorkUnit(String scoIdWorkUnit) {
        this.scoIdWorkUnit = scoIdWorkUnit;
    }

    public String getScoIdTempReg() {
        return scoIdTempReg;
    }

    public void setScoIdTempReg(String scoIdTempReg) {
        this.scoIdTempReg = scoIdTempReg;
    }

    public String getScoMultipleFil() {
        return scoMultipleFil;
    }

    public void setScoMultipleFil(String scoMultipleFil) {
        this.scoMultipleFil = scoMultipleFil;
    }

    public BigDecimal getScoPosWHours() {
        return scoPosWHours;
    }

    public void setScoPosWHours(BigDecimal scoPosWHours) {
        this.scoPosWHours = scoPosWHours;
    }

    public String getScoFullTime() {
        return scoFullTime;
    }

    public void setScoFullTime(String scoFullTime) {
        this.scoFullTime = scoFullTime;
    }

    public Short getScoIsRoot() {
        return scoIsRoot;
    }

    public void setScoIsRoot(Short scoIsRoot) {
        this.scoIsRoot = scoIsRoot;
    }

    public String getScoPositionPath() {
        return scoPositionPath;
    }

    public void setScoPositionPath(String scoPositionPath) {
        this.scoPositionPath = scoPositionPath;
    }

    public String getScoDescriptionbra() {
        return scoDescriptionbra;
    }

    public void setScoDescriptionbra(String scoDescriptionbra) {
        this.scoDescriptionbra = scoDescriptionbra;
    }

    public String getScoDescriptioneng() {
        return scoDescriptioneng;
    }

    public void setScoDescriptioneng(String scoDescriptioneng) {
        this.scoDescriptioneng = scoDescriptioneng;
    }

    public String getScoDescriptionesp() {
        return scoDescriptionesp;
    }

    public void setScoDescriptionesp(String scoDescriptionesp) {
        this.scoDescriptionesp = scoDescriptionesp;
    }

    public String getScoDescriptionfra() {
        return scoDescriptionfra;
    }

    public void setScoDescriptionfra(String scoDescriptionfra) {
        this.scoDescriptionfra = scoDescriptionfra;
    }

    public String getScoDescriptiongen() {
        return scoDescriptiongen;
    }

    public void setScoDescriptiongen(String scoDescriptiongen) {
        this.scoDescriptiongen = scoDescriptiongen;
    }

    public String getScoDescriptionger() {
        return scoDescriptionger;
    }

    public void setScoDescriptionger(String scoDescriptionger) {
        this.scoDescriptionger = scoDescriptionger;
    }

    public String getScoDescriptionita() {
        return scoDescriptionita;
    }

    public void setScoDescriptionita(String scoDescriptionita) {
        this.scoDescriptionita = scoDescriptionita;
    }

    public String getSukCostCentreId() {
        return sukCostCentreId;
    }

    public void setSukCostCentreId(String sukCostCentreId) {
        this.sukCostCentreId = sukCostCentreId;
    }

    public String getIdApprole() {
        return idApprole;
    }

    public void setIdApprole(String idApprole) {
        this.idApprole = idApprole;
    }

    public String getScoKeyPosition() {
        return scoKeyPosition;
    }

    public void setScoKeyPosition(String scoKeyPosition) {
        this.scoKeyPosition = scoKeyPosition;
    }

    public String getIdSecuser() {
        return idSecuser;
    }

    public void setIdSecuser(String idSecuser) {
        this.idSecuser = idSecuser;
    }

    public Date getDtLastUpdate() {
        return dtLastUpdate;
    }

    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }

    public Integer getCcbConsecutivo() {
        return ccbConsecutivo;
    }

    public void setCcbConsecutivo(Integer ccbConsecutivo) {
        this.ccbConsecutivo = ccbConsecutivo;
    }

    public String getScbIdCentroCost() {
        return scbIdCentroCost;
    }

    public void setScbIdCentroCost(String scbIdCentroCost) {
        this.scbIdCentroCost = scbIdCentroCost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (m4scoPositionPK != null ? m4scoPositionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoPosition)) {
            return false;
        }
        M4scoPosition other = (M4scoPosition) object;
        if ((this.m4scoPositionPK == null && other.m4scoPositionPK != null) || (this.m4scoPositionPK != null && !this.m4scoPositionPK.equals(other.m4scoPositionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4scoPosition[ m4scoPositionPK=" + m4scoPositionPK + " ]";
    }
    
}
