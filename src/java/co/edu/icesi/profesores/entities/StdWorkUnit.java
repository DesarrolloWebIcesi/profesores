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
@Table(name = "STD_WORK_UNIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdWorkUnit.findAll", query = "SELECT s FROM StdWorkUnit s"),
    @NamedQuery(name = "StdWorkUnit.findByIdOrganization", query = "SELECT s FROM StdWorkUnit s WHERE s.stdWorkUnitPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdWorkUnit.findByStdIdWorkUnit", query = "SELECT s FROM StdWorkUnit s WHERE s.stdWorkUnitPK.stdIdWorkUnit = :stdIdWorkUnit"),
    @NamedQuery(name = "StdWorkUnit.findByStdNWorkUnitbra", query = "SELECT s FROM StdWorkUnit s WHERE s.stdNWorkUnitbra = :stdNWorkUnitbra"),
    @NamedQuery(name = "StdWorkUnit.findByStdNWorkUniteng", query = "SELECT s FROM StdWorkUnit s WHERE s.stdNWorkUniteng = :stdNWorkUniteng"),
    @NamedQuery(name = "StdWorkUnit.findByStdNWorkUnitesp", query = "SELECT s FROM StdWorkUnit s WHERE s.stdNWorkUnitesp = :stdNWorkUnitesp"),
    @NamedQuery(name = "StdWorkUnit.findByStdNWorkUnitfra", query = "SELECT s FROM StdWorkUnit s WHERE s.stdNWorkUnitfra = :stdNWorkUnitfra"),
    @NamedQuery(name = "StdWorkUnit.findByStdNWorkUnitgen", query = "SELECT s FROM StdWorkUnit s WHERE s.stdNWorkUnitgen = :stdNWorkUnitgen"),
    @NamedQuery(name = "StdWorkUnit.findByStdNWorkUnitger", query = "SELECT s FROM StdWorkUnit s WHERE s.stdNWorkUnitger = :stdNWorkUnitger"),
    @NamedQuery(name = "StdWorkUnit.findByStdNWorkUnitita", query = "SELECT s FROM StdWorkUnit s WHERE s.stdNWorkUnitita = :stdNWorkUnitita"),
    @NamedQuery(name = "StdWorkUnit.findByStdDtStart", query = "SELECT s FROM StdWorkUnit s WHERE s.stdDtStart = :stdDtStart"),
    @NamedQuery(name = "StdWorkUnit.findByStdDtEnd", query = "SELECT s FROM StdWorkUnit s WHERE s.stdDtEnd = :stdDtEnd"),
    @NamedQuery(name = "StdWorkUnit.findByStdIdWuType", query = "SELECT s FROM StdWorkUnit s WHERE s.stdIdWuType = :stdIdWuType"),
    @NamedQuery(name = "StdWorkUnit.findByStdObjectives", query = "SELECT s FROM StdWorkUnit s WHERE s.stdObjectives = :stdObjectives"),
    @NamedQuery(name = "StdWorkUnit.findByScoWuIcon", query = "SELECT s FROM StdWorkUnit s WHERE s.scoWuIcon = :scoWuIcon"),
    @NamedQuery(name = "StdWorkUnit.findByScoPathVideo", query = "SELECT s FROM StdWorkUnit s WHERE s.scoPathVideo = :scoPathVideo"),
    @NamedQuery(name = "StdWorkUnit.findByStdDescription", query = "SELECT s FROM StdWorkUnit s WHERE s.stdDescription = :stdDescription"),
    @NamedQuery(name = "StdWorkUnit.findByScoIsRoot", query = "SELECT s FROM StdWorkUnit s WHERE s.scoIsRoot = :scoIsRoot"),
    @NamedQuery(name = "StdWorkUnit.findByIdApprole", query = "SELECT s FROM StdWorkUnit s WHERE s.idApprole = :idApprole"),
    @NamedQuery(name = "StdWorkUnit.findByIdSecuser", query = "SELECT s FROM StdWorkUnit s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdWorkUnit.findByDtLastUpdate", query = "SELECT s FROM StdWorkUnit s WHERE s.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "StdWorkUnit.findByCcbConsecutivo", query = "SELECT s FROM StdWorkUnit s WHERE s.ccbConsecutivo = :ccbConsecutivo"),
    @NamedQuery(name = "StdWorkUnit.findByCcbNomCorto", query = "SELECT s FROM StdWorkUnit s WHERE s.ccbNomCorto = :ccbNomCorto")})
public class StdWorkUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdWorkUnitPK stdWorkUnitPK;
    @Column(name = "STD_N_WORK_UNITBRA")
    private String stdNWorkUnitbra;
    @Column(name = "STD_N_WORK_UNITENG")
    private String stdNWorkUniteng;
    @Column(name = "STD_N_WORK_UNITESP")
    private String stdNWorkUnitesp;
    @Column(name = "STD_N_WORK_UNITFRA")
    private String stdNWorkUnitfra;
    @Column(name = "STD_N_WORK_UNITGEN")
    private String stdNWorkUnitgen;
    @Column(name = "STD_N_WORK_UNITGER")
    private String stdNWorkUnitger;
    @Column(name = "STD_N_WORK_UNITITA")
    private String stdNWorkUnitita;
    @Column(name = "STD_DT_START")
    @Temporal(TemporalType.DATE)
    private Date stdDtStart;
    @Column(name = "STD_DT_END")
    @Temporal(TemporalType.DATE)
    private Date stdDtEnd;
    @Column(name = "STD_ID_WU_TYPE")
    private String stdIdWuType;
    @Column(name = "STD_OBJECTIVES")
    private String stdObjectives;
    @Column(name = "SCO_WU_ICON")
    private String scoWuIcon;
    @Column(name = "SCO_PATH_VIDEO")
    private String scoPathVideo;
    @Column(name = "STD_DESCRIPTION")
    private String stdDescription;
    @Column(name = "SCO_IS_ROOT")
    private Short scoIsRoot;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "CCB_CONSECUTIVO")
    private Integer ccbConsecutivo;
    @Column(name = "CCB_NOM_CORTO")
    private String ccbNomCorto;

    public StdWorkUnit() {
    }

    public StdWorkUnit(StdWorkUnitPK stdWorkUnitPK) {
        this.stdWorkUnitPK = stdWorkUnitPK;
    }

    public StdWorkUnit(String idOrganization, String stdIdWorkUnit) {
        this.stdWorkUnitPK = new StdWorkUnitPK(idOrganization, stdIdWorkUnit);
    }

    public StdWorkUnitPK getStdWorkUnitPK() {
        return stdWorkUnitPK;
    }

    public void setStdWorkUnitPK(StdWorkUnitPK stdWorkUnitPK) {
        this.stdWorkUnitPK = stdWorkUnitPK;
    }

    public String getStdNWorkUnitbra() {
        return stdNWorkUnitbra;
    }

    public void setStdNWorkUnitbra(String stdNWorkUnitbra) {
        this.stdNWorkUnitbra = stdNWorkUnitbra;
    }

    public String getStdNWorkUniteng() {
        return stdNWorkUniteng;
    }

    public void setStdNWorkUniteng(String stdNWorkUniteng) {
        this.stdNWorkUniteng = stdNWorkUniteng;
    }

    public String getStdNWorkUnitesp() {
        return stdNWorkUnitesp;
    }

    public void setStdNWorkUnitesp(String stdNWorkUnitesp) {
        this.stdNWorkUnitesp = stdNWorkUnitesp;
    }

    public String getStdNWorkUnitfra() {
        return stdNWorkUnitfra;
    }

    public void setStdNWorkUnitfra(String stdNWorkUnitfra) {
        this.stdNWorkUnitfra = stdNWorkUnitfra;
    }

    public String getStdNWorkUnitgen() {
        return stdNWorkUnitgen;
    }

    public void setStdNWorkUnitgen(String stdNWorkUnitgen) {
        this.stdNWorkUnitgen = stdNWorkUnitgen;
    }

    public String getStdNWorkUnitger() {
        return stdNWorkUnitger;
    }

    public void setStdNWorkUnitger(String stdNWorkUnitger) {
        this.stdNWorkUnitger = stdNWorkUnitger;
    }

    public String getStdNWorkUnitita() {
        return stdNWorkUnitita;
    }

    public void setStdNWorkUnitita(String stdNWorkUnitita) {
        this.stdNWorkUnitita = stdNWorkUnitita;
    }

    public Date getStdDtStart() {
        return stdDtStart;
    }

    public void setStdDtStart(Date stdDtStart) {
        this.stdDtStart = stdDtStart;
    }

    public Date getStdDtEnd() {
        return stdDtEnd;
    }

    public void setStdDtEnd(Date stdDtEnd) {
        this.stdDtEnd = stdDtEnd;
    }

    public String getStdIdWuType() {
        return stdIdWuType;
    }

    public void setStdIdWuType(String stdIdWuType) {
        this.stdIdWuType = stdIdWuType;
    }

    public String getStdObjectives() {
        return stdObjectives;
    }

    public void setStdObjectives(String stdObjectives) {
        this.stdObjectives = stdObjectives;
    }

    public String getScoWuIcon() {
        return scoWuIcon;
    }

    public void setScoWuIcon(String scoWuIcon) {
        this.scoWuIcon = scoWuIcon;
    }

    public String getScoPathVideo() {
        return scoPathVideo;
    }

    public void setScoPathVideo(String scoPathVideo) {
        this.scoPathVideo = scoPathVideo;
    }

    public String getStdDescription() {
        return stdDescription;
    }

    public void setStdDescription(String stdDescription) {
        this.stdDescription = stdDescription;
    }

    public Short getScoIsRoot() {
        return scoIsRoot;
    }

    public void setScoIsRoot(Short scoIsRoot) {
        this.scoIsRoot = scoIsRoot;
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

    public String getCcbNomCorto() {
        return ccbNomCorto;
    }

    public void setCcbNomCorto(String ccbNomCorto) {
        this.ccbNomCorto = ccbNomCorto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdWorkUnitPK != null ? stdWorkUnitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdWorkUnit)) {
            return false;
        }
        StdWorkUnit other = (StdWorkUnit) object;
        if ((this.stdWorkUnitPK == null && other.stdWorkUnitPK != null) || (this.stdWorkUnitPK != null && !this.stdWorkUnitPK.equals(other.stdWorkUnitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdWorkUnit[ stdWorkUnitPK=" + stdWorkUnitPK + " ]";
    }
    
}
