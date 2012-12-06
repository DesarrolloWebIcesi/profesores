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
@Table(name = "M4SCO_H_HR_WUNIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4scoHHrWunit.findAll", query = "SELECT m FROM M4scoHHrWunit m"),
    @NamedQuery(name = "M4scoHHrWunit.findByIdOrganization", query = "SELECT m FROM M4scoHHrWunit m WHERE m.m4scoHHrWunitPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4scoHHrWunit.findByScoIdHr", query = "SELECT m FROM M4scoHHrWunit m WHERE m.m4scoHHrWunitPK.scoIdHr = :scoIdHr"),
    @NamedQuery(name = "M4scoHHrWunit.findByScoDtStart", query = "SELECT m FROM M4scoHHrWunit m WHERE m.m4scoHHrWunitPK.scoDtStart = :scoDtStart"),
    @NamedQuery(name = "M4scoHHrWunit.findByScoDtEnd", query = "SELECT m FROM M4scoHHrWunit m WHERE m.scoDtEnd = :scoDtEnd"),
    @NamedQuery(name = "M4scoHHrWunit.findByScoOrHrRole", query = "SELECT m FROM M4scoHHrWunit m WHERE m.m4scoHHrWunitPK.scoOrHrRole = :scoOrHrRole"),
    @NamedQuery(name = "M4scoHHrWunit.findByScoIdWorkUnit", query = "SELECT m FROM M4scoHHrWunit m WHERE m.scoIdWorkUnit = :scoIdWorkUnit"),
    @NamedQuery(name = "M4scoHHrWunit.findByScoIdReasChng", query = "SELECT m FROM M4scoHHrWunit m WHERE m.scoIdReasChng = :scoIdReasChng"),
    @NamedQuery(name = "M4scoHHrWunit.findByDtLastUpdate", query = "SELECT m FROM M4scoHHrWunit m WHERE m.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "M4scoHHrWunit.findByIdApprole", query = "SELECT m FROM M4scoHHrWunit m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4scoHHrWunit.findByIdSecuser", query = "SELECT m FROM M4scoHHrWunit m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4scoHHrWunit.findByScoComment", query = "SELECT m FROM M4scoHHrWunit m WHERE m.scoComment = :scoComment")})
public class M4scoHHrWunit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4scoHHrWunitPK m4scoHHrWunitPK;
    @Column(name = "SCO_DT_END")
    @Temporal(TemporalType.DATE)
    private Date scoDtEnd;
    @Column(name = "SCO_ID_WORK_UNIT")
    private String scoIdWorkUnit;
    @Column(name = "SCO_ID_REAS_CHNG")
    private String scoIdReasChng;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "SCO_COMMENT")
    private String scoComment;

    public M4scoHHrWunit() {
    }

    public M4scoHHrWunit(M4scoHHrWunitPK m4scoHHrWunitPK) {
        this.m4scoHHrWunitPK = m4scoHHrWunitPK;
    }

    public M4scoHHrWunit(String idOrganization, String scoIdHr, Date scoDtStart, short scoOrHrRole) {
        this.m4scoHHrWunitPK = new M4scoHHrWunitPK(idOrganization, scoIdHr, scoDtStart, scoOrHrRole);
    }

    public M4scoHHrWunitPK getM4scoHHrWunitPK() {
        return m4scoHHrWunitPK;
    }

    public void setM4scoHHrWunitPK(M4scoHHrWunitPK m4scoHHrWunitPK) {
        this.m4scoHHrWunitPK = m4scoHHrWunitPK;
    }

    public Date getScoDtEnd() {
        return scoDtEnd;
    }

    public void setScoDtEnd(Date scoDtEnd) {
        this.scoDtEnd = scoDtEnd;
    }

    public String getScoIdWorkUnit() {
        return scoIdWorkUnit;
    }

    public void setScoIdWorkUnit(String scoIdWorkUnit) {
        this.scoIdWorkUnit = scoIdWorkUnit;
    }

    public String getScoIdReasChng() {
        return scoIdReasChng;
    }

    public void setScoIdReasChng(String scoIdReasChng) {
        this.scoIdReasChng = scoIdReasChng;
    }

    public Date getDtLastUpdate() {
        return dtLastUpdate;
    }

    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
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

    public String getScoComment() {
        return scoComment;
    }

    public void setScoComment(String scoComment) {
        this.scoComment = scoComment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (m4scoHHrWunitPK != null ? m4scoHHrWunitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoHHrWunit)) {
            return false;
        }
        M4scoHHrWunit other = (M4scoHHrWunit) object;
        if ((this.m4scoHHrWunitPK == null && other.m4scoHHrWunitPK != null) || (this.m4scoHHrWunitPK != null && !this.m4scoHHrWunitPK.equals(other.m4scoHHrWunitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4scoHHrWunit[ m4scoHHrWunitPK=" + m4scoHHrWunitPK + " ]";
    }
    
}
