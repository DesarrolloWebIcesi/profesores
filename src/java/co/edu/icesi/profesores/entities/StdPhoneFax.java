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
@Table(name = "STD_PHONE_FAX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdPhoneFax.findAll", query = "SELECT s FROM StdPhoneFax s"),
    @NamedQuery(name = "StdPhoneFax.findByIdOrganization", query = "SELECT s FROM StdPhoneFax s WHERE s.stdPhoneFaxPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdPhoneFax.findByStdIdPerson", query = "SELECT s FROM StdPhoneFax s WHERE s.stdPhoneFaxPK.stdIdPerson = :stdIdPerson"),
    @NamedQuery(name = "StdPhoneFax.findByStdOrPhone", query = "SELECT s FROM StdPhoneFax s WHERE s.stdPhoneFaxPK.stdOrPhone = :stdOrPhone"),
    @NamedQuery(name = "StdPhoneFax.findByStdDtStart", query = "SELECT s FROM StdPhoneFax s WHERE s.stdDtStart = :stdDtStart"),
    @NamedQuery(name = "StdPhoneFax.findByStdDtEnd", query = "SELECT s FROM StdPhoneFax s WHERE s.stdDtEnd = :stdDtEnd"),
    @NamedQuery(name = "StdPhoneFax.findByStdIdLocatType", query = "SELECT s FROM StdPhoneFax s WHERE s.stdIdLocatType = :stdIdLocatType"),
    @NamedQuery(name = "StdPhoneFax.findByStdIdLineType", query = "SELECT s FROM StdPhoneFax s WHERE s.stdIdLineType = :stdIdLineType"),
    @NamedQuery(name = "StdPhoneFax.findByStdIntCountCode", query = "SELECT s FROM StdPhoneFax s WHERE s.stdIntCountCode = :stdIntCountCode"),
    @NamedQuery(name = "StdPhoneFax.findByStdIntRegCode", query = "SELECT s FROM StdPhoneFax s WHERE s.stdIntRegCode = :stdIntRegCode"),
    @NamedQuery(name = "StdPhoneFax.findByStdNatRegCode", query = "SELECT s FROM StdPhoneFax s WHERE s.stdNatRegCode = :stdNatRegCode"),
    @NamedQuery(name = "StdPhoneFax.findByStdPhone", query = "SELECT s FROM StdPhoneFax s WHERE s.stdPhone = :stdPhone"),
    @NamedQuery(name = "StdPhoneFax.findByDtLastUpdate", query = "SELECT s FROM StdPhoneFax s WHERE s.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "StdPhoneFax.findByIdApprole", query = "SELECT s FROM StdPhoneFax s WHERE s.idApprole = :idApprole"),
    @NamedQuery(name = "StdPhoneFax.findByIdSecuser", query = "SELECT s FROM StdPhoneFax s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdPhoneFax.findInstitutionalPhoneByStdIdPerson", query = "SELECT s FROM StdPhoneFax s WHERE s.stdPhoneFaxPK.stdIdPerson = :stdIdPerson and s.stdIdLineType='001'")
})
public class StdPhoneFax implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdPhoneFaxPK stdPhoneFaxPK;
    @Column(name = "STD_DT_START")
    @Temporal(TemporalType.DATE)
    private Date stdDtStart;
    @Column(name = "STD_DT_END")
    @Temporal(TemporalType.DATE)
    private Date stdDtEnd;
    @Column(name = "STD_ID_LOCAT_TYPE")
    private String stdIdLocatType;
    @Column(name = "STD_ID_LINE_TYPE")
    private String stdIdLineType;
    @Column(name = "STD_INT_COUNT_CODE")
    private String stdIntCountCode;
    @Column(name = "STD_INT_REG_CODE")
    private String stdIntRegCode;
    @Column(name = "STD_NAT_REG_CODE")
    private String stdNatRegCode;
    @Column(name = "STD_PHONE")
    private String stdPhone;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;

    public StdPhoneFax() {
    }

    public StdPhoneFax(StdPhoneFaxPK stdPhoneFaxPK) {
        this.stdPhoneFaxPK = stdPhoneFaxPK;
    }

    public StdPhoneFax(String idOrganization, String stdIdPerson, int stdOrPhone) {
        this.stdPhoneFaxPK = new StdPhoneFaxPK(idOrganization, stdIdPerson, stdOrPhone);
    }

    public StdPhoneFaxPK getStdPhoneFaxPK() {
        return stdPhoneFaxPK;
    }

    public void setStdPhoneFaxPK(StdPhoneFaxPK stdPhoneFaxPK) {
        this.stdPhoneFaxPK = stdPhoneFaxPK;
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

    public String getStdIdLocatType() {
        return stdIdLocatType;
    }

    public void setStdIdLocatType(String stdIdLocatType) {
        this.stdIdLocatType = stdIdLocatType;
    }

    public String getStdIdLineType() {
        return stdIdLineType;
    }

    public void setStdIdLineType(String stdIdLineType) {
        this.stdIdLineType = stdIdLineType;
    }

    public String getStdIntCountCode() {
        return stdIntCountCode;
    }

    public void setStdIntCountCode(String stdIntCountCode) {
        this.stdIntCountCode = stdIntCountCode;
    }

    public String getStdIntRegCode() {
        return stdIntRegCode;
    }

    public void setStdIntRegCode(String stdIntRegCode) {
        this.stdIntRegCode = stdIntRegCode;
    }

    public String getStdNatRegCode() {
        return stdNatRegCode;
    }

    public void setStdNatRegCode(String stdNatRegCode) {
        this.stdNatRegCode = stdNatRegCode;
    }

    public String getStdPhone() {
        return stdPhone;
    }

    public void setStdPhone(String stdPhone) {
        this.stdPhone = stdPhone;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdPhoneFaxPK != null ? stdPhoneFaxPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdPhoneFax)) {
            return false;
        }
        StdPhoneFax other = (StdPhoneFax) object;
        if ((this.stdPhoneFaxPK == null && other.stdPhoneFaxPK != null) || (this.stdPhoneFaxPK != null && !this.stdPhoneFaxPK.equals(other.stdPhoneFaxPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdPhoneFax[ stdPhoneFaxPK=" + stdPhoneFaxPK + " ]";
    }
    
}
