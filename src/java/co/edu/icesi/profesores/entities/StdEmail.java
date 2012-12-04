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
@Table(name = "STD_EMAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdEmail.findAll", query = "SELECT s FROM StdEmail s"),
    @NamedQuery(name = "StdEmail.findByIdOrganization", query = "SELECT s FROM StdEmail s WHERE s.stdEmailPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdEmail.findByStdIdPerson", query = "SELECT s FROM StdEmail s WHERE s.stdEmailPK.stdIdPerson = :stdIdPerson"),
    @NamedQuery(name = "StdEmail.findByStdIdPersonStdIdLocatType", query = "SELECT s FROM StdEmail s WHERE s.stdIdLocatType = :stdIdLocatType and s.stdEmailPK.stdIdPerson = :stdIdPerson"),
    @NamedQuery(name = "StdEmail.findByStdOrMail", query = "SELECT s FROM StdEmail s WHERE s.stdEmailPK.stdOrMail = :stdOrMail"),
    @NamedQuery(name = "StdEmail.findByStdDtStart", query = "SELECT s FROM StdEmail s WHERE s.stdDtStart = :stdDtStart"),
    @NamedQuery(name = "StdEmail.findByStdDtEnd", query = "SELECT s FROM StdEmail s WHERE s.stdDtEnd = :stdDtEnd"),
    @NamedQuery(name = "StdEmail.findByStdEmail", query = "SELECT s FROM StdEmail s WHERE s.stdEmail = :stdEmail"),
    @NamedQuery(name = "StdEmail.findByStdIdLocatType", query = "SELECT s FROM StdEmail s WHERE s.stdIdLocatType = :stdIdLocatType"),
    @NamedQuery(name = "StdEmail.findByCcbPreferido", query = "SELECT s FROM StdEmail s WHERE s.ccbPreferido = :ccbPreferido"),
    @NamedQuery(name = "StdEmail.findByStdIdPersonCcbPreferido", query = "SELECT s FROM StdEmail s WHERE s.ccbPreferido = :ccbPreferido and s.stdEmailPK.stdIdPerson = :stdIdPerson"),
    @NamedQuery(name = "StdEmail.findByIdApprole", query = "SELECT s FROM StdEmail s WHERE s.idApprole = :idApprole"),
    @NamedQuery(name = "StdEmail.findByIdSecuser", query = "SELECT s FROM StdEmail s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdEmail.findByDtLastUpdate", query = "SELECT s FROM StdEmail s WHERE s.dtLastUpdate = :dtLastUpdate")})
public class StdEmail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdEmailPK stdEmailPK;
    @Column(name = "STD_DT_START")
    @Temporal(TemporalType.DATE)
    private Date stdDtStart;
    @Column(name = "STD_DT_END")
    @Temporal(TemporalType.DATE)
    private Date stdDtEnd;
    @Column(name = "STD_EMAIL")
    private String stdEmail;
    @Column(name = "STD_ID_LOCAT_TYPE")
    private String stdIdLocatType;
    @Column(name = "CCB_PREFERIDO")
    private String ccbPreferido;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public StdEmail() {
    }

    public StdEmail(StdEmailPK stdEmailPK) {
        this.stdEmailPK = stdEmailPK;
    }

    public StdEmail(String idOrganization, String stdIdPerson, int stdOrMail) {
        this.stdEmailPK = new StdEmailPK(idOrganization, stdIdPerson, stdOrMail);
    }

    public StdEmailPK getStdEmailPK() {
        return stdEmailPK;
    }

    public void setStdEmailPK(StdEmailPK stdEmailPK) {
        this.stdEmailPK = stdEmailPK;
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

    public String getStdEmail() {
        return stdEmail;
    }

    public void setStdEmail(String stdEmail) {
        this.stdEmail = stdEmail;
    }

    public String getStdIdLocatType() {
        return stdIdLocatType;
    }

    public void setStdIdLocatType(String stdIdLocatType) {
        this.stdIdLocatType = stdIdLocatType;
    }

    public String getCcbPreferido() {
        return ccbPreferido;
    }

    public void setCcbPreferido(String ccbPreferido) {
        this.ccbPreferido = ccbPreferido;
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
        hash += (stdEmailPK != null ? stdEmailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdEmail)) {
            return false;
        }
        StdEmail other = (StdEmail) object;
        if ((this.stdEmailPK == null && other.stdEmailPK != null) || (this.stdEmailPK != null && !this.stdEmailPK.equals(other.stdEmailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdEmail[ stdEmailPK=" + stdEmailPK + " ]";
    }
    
}
