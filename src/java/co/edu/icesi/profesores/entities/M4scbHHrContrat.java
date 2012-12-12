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
@Table(name = "M4SCB_H_HR_CONTRAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4scbHHrContrat.findAll", query = "SELECT m FROM M4scbHHrContrat m"),
    @NamedQuery(name = "M4scbHHrContrat.findByIdOrganization", query = "SELECT m FROM M4scbHHrContrat m WHERE m.m4scbHHrContratPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4scbHHrContrat.findByStdIdHr", query = "SELECT m FROM M4scbHHrContrat m WHERE m.m4scbHHrContratPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4scbHHrContrat.findByStdOrHrPeriod", query = "SELECT m FROM M4scbHHrContrat m WHERE m.m4scbHHrContratPK.stdOrHrPeriod = :stdOrHrPeriod"),
    @NamedQuery(name = "M4scbHHrContrat.findByScbDtStart", query = "SELECT m FROM M4scbHHrContrat m WHERE m.m4scbHHrContratPK.scbDtStart = :scbDtStart"),
    @NamedQuery(name = "M4scbHHrContrat.findByScbDtEnd", query = "SELECT m FROM M4scbHHrContrat m WHERE m.scbDtEnd = :scbDtEnd"),
    @NamedQuery(name = "M4scbHHrContrat.findByScbIdContrato", query = "SELECT m FROM M4scbHHrContrat m WHERE m.scbIdContrato = :scbIdContrato"),
    @NamedQuery(name = "M4scbHHrContrat.findByScoIdReaChang", query = "SELECT m FROM M4scbHHrContrat m WHERE m.scoIdReaChang = :scoIdReaChang"),
    @NamedQuery(name = "M4scbHHrContrat.findByScbDtVencimiento", query = "SELECT m FROM M4scbHHrContrat m WHERE m.scbDtVencimiento = :scbDtVencimiento"),
    @NamedQuery(name = "M4scbHHrContrat.findByScbDtEndPrueba", query = "SELECT m FROM M4scbHHrContrat m WHERE m.scbDtEndPrueba = :scbDtEndPrueba"),
    @NamedQuery(name = "M4scbHHrContrat.findByScbComment", query = "SELECT m FROM M4scbHHrContrat m WHERE m.scbComment = :scbComment"),
    @NamedQuery(name = "M4scbHHrContrat.findByIdApprole", query = "SELECT m FROM M4scbHHrContrat m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4scbHHrContrat.findByIdSecuser", query = "SELECT m FROM M4scbHHrContrat m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4scbHHrContrat.findByDtLastUpdate", query = "SELECT m FROM M4scbHHrContrat m WHERE m.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "M4scbHHrContrat.findByCcbIndNoProrr", query = "SELECT m FROM M4scbHHrContrat m WHERE m.ccbIndNoProrr = :ccbIndNoProrr")})
public class M4scbHHrContrat implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4scbHHrContratPK m4scbHHrContratPK;
    @Column(name = "SCB_DT_END")
    @Temporal(TemporalType.DATE)
    private Date scbDtEnd;
    @Column(name = "SCB_ID_CONTRATO")
    private String scbIdContrato;
    @Column(name = "SCO_ID_REA_CHANG")
    private String scoIdReaChang;
    @Column(name = "SCB_DT_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date scbDtVencimiento;
    @Column(name = "SCB_DT_END_PRUEBA")
    @Temporal(TemporalType.DATE)
    private Date scbDtEndPrueba;
    @Column(name = "SCB_COMMENT")
    private String scbComment;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "CCB_IND_NO_PRORR")
    private String ccbIndNoProrr;

    public M4scbHHrContrat() {
    }

    public M4scbHHrContrat(M4scbHHrContratPK m4scbHHrContratPK) {
        this.m4scbHHrContratPK = m4scbHHrContratPK;
    }

    public M4scbHHrContrat(String idOrganization, String stdIdHr, short stdOrHrPeriod, Date scbDtStart) {
        this.m4scbHHrContratPK = new M4scbHHrContratPK(idOrganization, stdIdHr, stdOrHrPeriod, scbDtStart);
    }

    public M4scbHHrContratPK getM4scbHHrContratPK() {
        return m4scbHHrContratPK;
    }

    public void setM4scbHHrContratPK(M4scbHHrContratPK m4scbHHrContratPK) {
        this.m4scbHHrContratPK = m4scbHHrContratPK;
    }

    public Date getScbDtEnd() {
        return scbDtEnd;
    }

    public void setScbDtEnd(Date scbDtEnd) {
        this.scbDtEnd = scbDtEnd;
    }

    public String getScbIdContrato() {
        return scbIdContrato;
    }

    public void setScbIdContrato(String scbIdContrato) {
        this.scbIdContrato = scbIdContrato;
    }

    public String getScoIdReaChang() {
        return scoIdReaChang;
    }

    public void setScoIdReaChang(String scoIdReaChang) {
        this.scoIdReaChang = scoIdReaChang;
    }

    public Date getScbDtVencimiento() {
        return scbDtVencimiento;
    }

    public void setScbDtVencimiento(Date scbDtVencimiento) {
        this.scbDtVencimiento = scbDtVencimiento;
    }

    public Date getScbDtEndPrueba() {
        return scbDtEndPrueba;
    }

    public void setScbDtEndPrueba(Date scbDtEndPrueba) {
        this.scbDtEndPrueba = scbDtEndPrueba;
    }

    public String getScbComment() {
        return scbComment;
    }

    public void setScbComment(String scbComment) {
        this.scbComment = scbComment;
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

    public String getCcbIndNoProrr() {
        return ccbIndNoProrr;
    }

    public void setCcbIndNoProrr(String ccbIndNoProrr) {
        this.ccbIndNoProrr = ccbIndNoProrr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (m4scbHHrContratPK != null ? m4scbHHrContratPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scbHHrContrat)) {
            return false;
        }
        M4scbHHrContrat other = (M4scbHHrContrat) object;
        if ((this.m4scbHHrContratPK == null && other.m4scbHHrContratPK != null) || (this.m4scbHHrContratPK != null && !this.m4scbHHrContratPK.equals(other.m4scbHHrContratPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4scbHHrContrat[ m4scbHHrContratPK=" + m4scbHHrContratPK + " ]";
    }
    
}
