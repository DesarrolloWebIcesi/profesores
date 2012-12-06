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
@Table(name = "STD_REL_WORK_UNIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdRelWorkUnit.findAll", query = "SELECT s FROM StdRelWorkUnit s"),
    @NamedQuery(name = "StdRelWorkUnit.findByIdOrganization", query = "SELECT s FROM StdRelWorkUnit s WHERE s.stdRelWorkUnitPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdRelWorkUnit.findByStdIdWuChild", query = "SELECT s FROM StdRelWorkUnit s WHERE s.stdRelWorkUnitPK.stdIdWuChild = :stdIdWuChild"),
    @NamedQuery(name = "StdRelWorkUnit.findByStdDtStart", query = "SELECT s FROM StdRelWorkUnit s WHERE s.stdRelWorkUnitPK.stdDtStart = :stdDtStart"),
    @NamedQuery(name = "StdRelWorkUnit.findByStdDtEnd", query = "SELECT s FROM StdRelWorkUnit s WHERE s.stdDtEnd = :stdDtEnd"),
    @NamedQuery(name = "StdRelWorkUnit.findByStdIdWuParent", query = "SELECT s FROM StdRelWorkUnit s WHERE s.stdIdWuParent = :stdIdWuParent"),
    @NamedQuery(name = "StdRelWorkUnit.findByStdIdLocChgRea", query = "SELECT s FROM StdRelWorkUnit s WHERE s.stdIdLocChgRea = :stdIdLocChgRea"),
    @NamedQuery(name = "StdRelWorkUnit.findByScoComment", query = "SELECT s FROM StdRelWorkUnit s WHERE s.scoComment = :scoComment"),
    @NamedQuery(name = "StdRelWorkUnit.findByIdApprole", query = "SELECT s FROM StdRelWorkUnit s WHERE s.idApprole = :idApprole"),
    @NamedQuery(name = "StdRelWorkUnit.findByIdSecuser", query = "SELECT s FROM StdRelWorkUnit s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdRelWorkUnit.findByDtLastUpdate", query = "SELECT s FROM StdRelWorkUnit s WHERE s.dtLastUpdate = :dtLastUpdate")})
public class StdRelWorkUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdRelWorkUnitPK stdRelWorkUnitPK;
    @Column(name = "STD_DT_END")
    @Temporal(TemporalType.DATE)
    private Date stdDtEnd;
    @Column(name = "STD_ID_WU_PARENT")
    private String stdIdWuParent;
    @Column(name = "STD_ID_LOC_CHG_REA")
    private String stdIdLocChgRea;
    @Column(name = "SCO_COMMENT")
    private String scoComment;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public StdRelWorkUnit() {
    }

    public StdRelWorkUnit(StdRelWorkUnitPK stdRelWorkUnitPK) {
        this.stdRelWorkUnitPK = stdRelWorkUnitPK;
    }

    public StdRelWorkUnit(String idOrganization, String stdIdWuChild, Date stdDtStart) {
        this.stdRelWorkUnitPK = new StdRelWorkUnitPK(idOrganization, stdIdWuChild, stdDtStart);
    }

    public StdRelWorkUnitPK getStdRelWorkUnitPK() {
        return stdRelWorkUnitPK;
    }

    public void setStdRelWorkUnitPK(StdRelWorkUnitPK stdRelWorkUnitPK) {
        this.stdRelWorkUnitPK = stdRelWorkUnitPK;
    }

    public Date getStdDtEnd() {
        return stdDtEnd;
    }

    public void setStdDtEnd(Date stdDtEnd) {
        this.stdDtEnd = stdDtEnd;
    }

    public String getStdIdWuParent() {
        return stdIdWuParent;
    }

    public void setStdIdWuParent(String stdIdWuParent) {
        this.stdIdWuParent = stdIdWuParent;
    }

    public String getStdIdLocChgRea() {
        return stdIdLocChgRea;
    }

    public void setStdIdLocChgRea(String stdIdLocChgRea) {
        this.stdIdLocChgRea = stdIdLocChgRea;
    }

    public String getScoComment() {
        return scoComment;
    }

    public void setScoComment(String scoComment) {
        this.scoComment = scoComment;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdRelWorkUnitPK != null ? stdRelWorkUnitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdRelWorkUnit)) {
            return false;
        }
        StdRelWorkUnit other = (StdRelWorkUnit) object;
        if ((this.stdRelWorkUnitPK == null && other.stdRelWorkUnitPK != null) || (this.stdRelWorkUnitPK != null && !this.stdRelWorkUnitPK.equals(other.stdRelWorkUnitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdRelWorkUnit[ stdRelWorkUnitPK=" + stdRelWorkUnitPK + " ]";
    }
    
}
