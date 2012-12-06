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
@Table(name = "M4SCO_EDUC_CENTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4scoEducCenter.findAll", query = "SELECT m FROM M4scoEducCenter m"),
    @NamedQuery(name = "M4scoEducCenter.findByIdOrganization", query = "SELECT m FROM M4scoEducCenter m WHERE m.m4scoEducCenterPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4scoEducCenter.findByScoIdEducCenter", query = "SELECT m FROM M4scoEducCenter m WHERE m.m4scoEducCenterPK.scoIdEducCenter = :scoIdEducCenter"),
    @NamedQuery(name = "M4scoEducCenter.findByDtEnd", query = "SELECT m FROM M4scoEducCenter m WHERE m.dtEnd = :dtEnd"),
    @NamedQuery(name = "M4scoEducCenter.findByDtStart", query = "SELECT m FROM M4scoEducCenter m WHERE m.dtStart = :dtStart"),
    @NamedQuery(name = "M4scoEducCenter.findByScoComment", query = "SELECT m FROM M4scoEducCenter m WHERE m.scoComment = :scoComment"),
    @NamedQuery(name = "M4scoEducCenter.findBySukIdEduCentre", query = "SELECT m FROM M4scoEducCenter m WHERE m.sukIdEduCentre = :sukIdEduCentre"),
    @NamedQuery(name = "M4scoEducCenter.findByIdApprole", query = "SELECT m FROM M4scoEducCenter m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4scoEducCenter.findByIdSecuser", query = "SELECT m FROM M4scoEducCenter m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4scoEducCenter.findByDtLastUpdate", query = "SELECT m FROM M4scoEducCenter m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4scoEducCenter implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4scoEducCenterPK m4scoEducCenterPK;
    @Column(name = "DT_END")
    @Temporal(TemporalType.DATE)
    private Date dtEnd;
    @Column(name = "DT_START")
    @Temporal(TemporalType.DATE)
    private Date dtStart;
    @Column(name = "SCO_COMMENT")
    private String scoComment;
    @Column(name = "SUK_ID_EDU_CENTRE_")
    private String sukIdEduCentre;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4scoEducCenter() {
    }

    public M4scoEducCenter(M4scoEducCenterPK m4scoEducCenterPK) {
        this.m4scoEducCenterPK = m4scoEducCenterPK;
    }

    public M4scoEducCenter(String idOrganization, String scoIdEducCenter) {
        this.m4scoEducCenterPK = new M4scoEducCenterPK(idOrganization, scoIdEducCenter);
    }

    public M4scoEducCenterPK getM4scoEducCenterPK() {
        return m4scoEducCenterPK;
    }

    public void setM4scoEducCenterPK(M4scoEducCenterPK m4scoEducCenterPK) {
        this.m4scoEducCenterPK = m4scoEducCenterPK;
    }

    public Date getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }

    public Date getDtStart() {
        return dtStart;
    }

    public void setDtStart(Date dtStart) {
        this.dtStart = dtStart;
    }

    public String getScoComment() {
        return scoComment;
    }

    public void setScoComment(String scoComment) {
        this.scoComment = scoComment;
    }

    public String getSukIdEduCentre() {
        return sukIdEduCentre;
    }

    public void setSukIdEduCentre(String sukIdEduCentre) {
        this.sukIdEduCentre = sukIdEduCentre;
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
        hash += (m4scoEducCenterPK != null ? m4scoEducCenterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoEducCenter)) {
            return false;
        }
        M4scoEducCenter other = (M4scoEducCenter) object;
        if ((this.m4scoEducCenterPK == null && other.m4scoEducCenterPK != null) || (this.m4scoEducCenterPK != null && !this.m4scoEducCenterPK.equals(other.m4scoEducCenterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4scoEducCenter[ m4scoEducCenterPK=" + m4scoEducCenterPK + " ]";
    }
    
}
