/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1130619373
 */
@Entity
@Table(name = "M4SCO_H_HR_POS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4scoHHrPos.findAll", query = "SELECT m FROM M4scoHHrPos m"),
    @NamedQuery(name = "M4scoHHrPos.findByIdOrganization", query = "SELECT m FROM M4scoHHrPos m WHERE m.m4scoHHrPosPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4scoHHrPos.findByScoIdHr", query = "SELECT m FROM M4scoHHrPos m WHERE m.m4scoHHrPosPK.scoIdHr = :scoIdHr"),
    @NamedQuery(name = "M4scoHHrPos.findByScoDtStart", query = "SELECT m FROM M4scoHHrPos m WHERE m.scoDtStart = :scoDtStart"),
    @NamedQuery(name = "M4scoHHrPos.findByScoDtEnd", query = "SELECT m FROM M4scoHHrPos m WHERE m.scoDtEnd = :scoDtEnd"),
    @NamedQuery(name = "M4scoHHrPos.findByScoIdPosition", query = "SELECT m FROM M4scoHHrPos m WHERE m.scoIdPosition = :scoIdPosition"),
    @NamedQuery(name = "M4scoHHrPos.findByScoOrHrRole", query = "SELECT m FROM M4scoHHrPos m WHERE m.m4scoHHrPosPK.scoOrHrRole = :scoOrHrRole"),
    @NamedQuery(name = "M4scoHHrPos.findByDtLastUpdate", query = "SELECT m FROM M4scoHHrPos m WHERE m.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "M4scoHHrPos.findByIdSecuser", query = "SELECT m FROM M4scoHHrPos m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4scoHHrPos.findByIdApprole", query = "SELECT m FROM M4scoHHrPos m WHERE m.idApprole = :idApprole")})
public class M4scoHHrPos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4scoHHrPosPK m4scoHHrPosPK;
    @Column(name = "SCO_DT_START")
    @Temporal(TemporalType.DATE)
    private Date scoDtStart;
    @Column(name = "SCO_DT_END")
    @Temporal(TemporalType.DATE)
    private Date scoDtEnd;
    @Column(name = "SCO_ID_POSITION")
    private String scoIdPosition;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "ID_APPROLE")
    private String idApprole;

    public M4scoHHrPos() {
    }

    public M4scoHHrPos(M4scoHHrPosPK m4scoHHrPosPK) {
        this.m4scoHHrPosPK = m4scoHHrPosPK;
    }

    public M4scoHHrPos(String idOrganization, String scoIdHr, short scoOrHrRole) {
        this.m4scoHHrPosPK = new M4scoHHrPosPK(idOrganization, scoIdHr, scoOrHrRole);
    }

    public M4scoHHrPosPK getM4scoHHrPosPK() {
        return m4scoHHrPosPK;
    }

    public void setM4scoHHrPosPK(M4scoHHrPosPK m4scoHHrPosPK) {
        this.m4scoHHrPosPK = m4scoHHrPosPK;
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

    public String getScoIdPosition() {
        return scoIdPosition;
    }

    public void setScoIdPosition(String scoIdPosition) {
        this.scoIdPosition = scoIdPosition;
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
        hash += (m4scoHHrPosPK != null ? m4scoHHrPosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoHHrPos)) {
            return false;
        }
        M4scoHHrPos other = (M4scoHHrPos) object;
        if ((this.m4scoHHrPosPK == null && other.m4scoHHrPosPK != null) || (this.m4scoHHrPosPK != null && !this.m4scoHHrPosPK.equals(other.m4scoHHrPosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4scoHHrPos[ m4scoHHrPosPK=" + m4scoHHrPosPK + " ]";
    }
    
}
