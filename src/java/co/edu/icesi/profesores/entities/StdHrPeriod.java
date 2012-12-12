/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "STD_HR_PERIOD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdHrPeriod.findAll", query = "SELECT s FROM StdHrPeriod s"),
    @NamedQuery(name = "StdHrPeriod.findByIdOrganization", query = "SELECT s FROM StdHrPeriod s WHERE s.stdHrPeriodPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdHrPeriod.findByStdIdHr", query = "SELECT s FROM StdHrPeriod s WHERE s.stdHrPeriodPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "StdHrPeriod.findByStdOrHrPeriod", query = "SELECT s FROM StdHrPeriod s WHERE s.stdHrPeriodPK.stdOrHrPeriod = :stdOrHrPeriod"),
    @NamedQuery(name = "StdHrPeriod.findByStdDtStart", query = "SELECT s FROM StdHrPeriod s WHERE s.stdDtStart = :stdDtStart"),
    @NamedQuery(name = "StdHrPeriod.findByStdDtEnd", query = "SELECT s FROM StdHrPeriod s WHERE s.stdDtEnd = :stdDtEnd"),
    @NamedQuery(name = "StdHrPeriod.findByStdIdHrpSrtRea", query = "SELECT s FROM StdHrPeriod s WHERE s.stdIdHrpSrtRea = :stdIdHrpSrtRea"),
    @NamedQuery(name = "StdHrPeriod.findByStdIdHrpEndRea", query = "SELECT s FROM StdHrPeriod s WHERE s.stdIdHrpEndRea = :stdIdHrpEndRea"),
    @NamedQuery(name = "StdHrPeriod.findByStdIdHrType", query = "SELECT s FROM StdHrPeriod s WHERE s.stdIdHrType = :stdIdHrType"),
    @NamedQuery(name = "StdHrPeriod.findByStdComment", query = "SELECT s FROM StdHrPeriod s WHERE s.stdComment = :stdComment"),
    @NamedQuery(name = "StdHrPeriod.findByStdIdExternOrg", query = "SELECT s FROM StdHrPeriod s WHERE s.stdIdExternOrg = :stdIdExternOrg"),
    @NamedQuery(name = "StdHrPeriod.findByStdKeyEmployee", query = "SELECT s FROM StdHrPeriod s WHERE s.stdKeyEmployee = :stdKeyEmployee"),
    @NamedQuery(name = "StdHrPeriod.findByStdStrategicEmp", query = "SELECT s FROM StdHrPeriod s WHERE s.stdStrategicEmp = :stdStrategicEmp"),
    @NamedQuery(name = "StdHrPeriod.findBySukContServReas", query = "SELECT s FROM StdHrPeriod s WHERE s.sukContServReas = :sukContServReas"),
    @NamedQuery(name = "StdHrPeriod.findBySspFecAntiguedad", query = "SELECT s FROM StdHrPeriod s WHERE s.sspFecAntiguedad = :sspFecAntiguedad"),
    @NamedQuery(name = "StdHrPeriod.findBySspFecExtras", query = "SELECT s FROM StdHrPeriod s WHERE s.sspFecExtras = :sspFecExtras"),
    @NamedQuery(name = "StdHrPeriod.findBySspNumMatricula", query = "SELECT s FROM StdHrPeriod s WHERE s.sspNumMatricula = :sspNumMatricula"),
    @NamedQuery(name = "StdHrPeriod.findBySspNumPluriempl", query = "SELECT s FROM StdHrPeriod s WHERE s.sspNumPluriempl = :sspNumPluriempl"),
    @NamedQuery(name = "StdHrPeriod.findBySspPagoTa", query = "SELECT s FROM StdHrPeriod s WHERE s.sspPagoTa = :sspPagoTa"),
    @NamedQuery(name = "StdHrPeriod.findBySukActLeavDt", query = "SELECT s FROM StdHrPeriod s WHERE s.sukActLeavDt = :sukActLeavDt"),
    @NamedQuery(name = "StdHrPeriod.findBySukContServDate", query = "SELECT s FROM StdHrPeriod s WHERE s.sukContServDate = :sukContServDate"),
    @NamedQuery(name = "StdHrPeriod.findBySukLastWkDt", query = "SELECT s FROM StdHrPeriod s WHERE s.sukLastWkDt = :sukLastWkDt"),
    @NamedQuery(name = "StdHrPeriod.findBySukProbEndDate", query = "SELECT s FROM StdHrPeriod s WHERE s.sukProbEndDate = :sukProbEndDate"),
    @NamedQuery(name = "StdHrPeriod.findBySukTermResigDt", query = "SELECT s FROM StdHrPeriod s WHERE s.sukTermResigDt = :sukTermResigDt"),
    @NamedQuery(name = "StdHrPeriod.findBySfrDtSeniority", query = "SELECT s FROM StdHrPeriod s WHERE s.sfrDtSeniority = :sfrDtSeniority"),
    @NamedQuery(name = "StdHrPeriod.findBySfrDtSeniorityG", query = "SELECT s FROM StdHrPeriod s WHERE s.sfrDtSeniorityG = :sfrDtSeniorityG"),
    @NamedQuery(name = "StdHrPeriod.findBySfrDtSeniorityL", query = "SELECT s FROM StdHrPeriod s WHERE s.sfrDtSeniorityL = :sfrDtSeniorityL"),
    @NamedQuery(name = "StdHrPeriod.findByStdDtSenProf", query = "SELECT s FROM StdHrPeriod s WHERE s.stdDtSenProf = :stdDtSenProf"),
    @NamedQuery(name = "StdHrPeriod.findBySfrSenSup", query = "SELECT s FROM StdHrPeriod s WHERE s.sfrSenSup = :sfrSenSup"),
    @NamedQuery(name = "StdHrPeriod.findBySukProbResults", query = "SELECT s FROM StdHrPeriod s WHERE s.sukProbResults = :sukProbResults"),
    @NamedQuery(name = "StdHrPeriod.findBySukExtProbEndD", query = "SELECT s FROM StdHrPeriod s WHERE s.sukExtProbEndD = :sukExtProbEndD"),
    @NamedQuery(name = "StdHrPeriod.findByIdApprole", query = "SELECT s FROM StdHrPeriod s WHERE s.idApprole = :idApprole"),
    @NamedQuery(name = "StdHrPeriod.findBySmeIdHrStatus", query = "SELECT s FROM StdHrPeriod s WHERE s.smeIdHrStatus = :smeIdHrStatus"),
    @NamedQuery(name = "StdHrPeriod.findByIdSecuser", query = "SELECT s FROM StdHrPeriod s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdHrPeriod.findBySmeSalary", query = "SELECT s FROM StdHrPeriod s WHERE s.smeSalary = :smeSalary"),
    @NamedQuery(name = "StdHrPeriod.findBySspChkIrpfMovil", query = "SELECT s FROM StdHrPeriod s WHERE s.sspChkIrpfMovil = :sspChkIrpfMovil"),
    @NamedQuery(name = "StdHrPeriod.findByDtLastUpdate", query = "SELECT s FROM StdHrPeriod s WHERE s.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "StdHrPeriod.findBySspChkIrpfProlo", query = "SELECT s FROM StdHrPeriod s WHERE s.sspChkIrpfProlo = :sspChkIrpfProlo"),
    @NamedQuery(name = "StdHrPeriod.findBySpoComentSaida", query = "SELECT s FROM StdHrPeriod s WHERE s.spoComentSaida = :spoComentSaida"),
    @NamedQuery(name = "StdHrPeriod.findBySpoIdEstQuadro", query = "SELECT s FROM StdHrPeriod s WHERE s.spoIdEstQuadro = :spoIdEstQuadro"),
    @NamedQuery(name = "StdHrPeriod.findBySpoIdEstSalario", query = "SELECT s FROM StdHrPeriod s WHERE s.spoIdEstSalario = :spoIdEstSalario"),
    @NamedQuery(name = "StdHrPeriod.findBySpoExtTelef", query = "SELECT s FROM StdHrPeriod s WHERE s.spoExtTelef = :spoExtTelef"),
    @NamedQuery(name = "StdHrPeriod.findBySarCertifOrig", query = "SELECT s FROM StdHrPeriod s WHERE s.sarCertifOrig = :sarCertifOrig"),
    @NamedQuery(name = "StdHrPeriod.findBySarCodigo", query = "SELECT s FROM StdHrPeriod s WHERE s.sarCodigo = :sarCodigo"),
    @NamedQuery(name = "StdHrPeriod.findBySarIdSitRevista", query = "SELECT s FROM StdHrPeriod s WHERE s.sarIdSitRevista = :sarIdSitRevista"),
    @NamedQuery(name = "StdHrPeriod.findByScbOrHrPerAnt", query = "SELECT s FROM StdHrPeriod s WHERE s.scbOrHrPerAnt = :scbOrHrPerAnt"),
    @NamedQuery(name = "StdHrPeriod.findByCcbIdMotRequi", query = "SELECT s FROM StdHrPeriod s WHERE s.ccbIdMotRequi = :ccbIdMotRequi"),
    @NamedQuery(name = "StdHrPeriod.findByIdSegmento", query = "SELECT s FROM StdHrPeriod s WHERE s.idSegmento = :idSegmento"),
    @NamedQuery(name = "StdHrPeriod.findByCcbIdTpRequi", query = "SELECT s FROM StdHrPeriod s WHERE s.ccbIdTpRequi = :ccbIdTpRequi")})
public class StdHrPeriod implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdHrPeriodPK stdHrPeriodPK;
    @Column(name = "STD_DT_START")
    @Temporal(TemporalType.DATE)
    private Date stdDtStart;
    @Column(name = "STD_DT_END")
    @Temporal(TemporalType.DATE)
    private Date stdDtEnd;
    @Column(name = "STD_ID_HRP_SRT_REA")
    private String stdIdHrpSrtRea;
    @Column(name = "STD_ID_HRP_END_REA")
    private String stdIdHrpEndRea;
    @Column(name = "STD_ID_HR_TYPE")
    private String stdIdHrType;
    @Column(name = "STD_COMMENT")
    private String stdComment;
    @Column(name = "STD_ID_EXTERN_ORG")
    private String stdIdExternOrg;
    @Column(name = "STD_KEY_EMPLOYEE")
    private String stdKeyEmployee;
    @Column(name = "STD_STRATEGIC_EMP")
    private String stdStrategicEmp;
    @Column(name = "SUK_CONT_SERV_REAS")
    private String sukContServReas;
    @Column(name = "SSP_FEC_ANTIGUEDAD")
    @Temporal(TemporalType.DATE)
    private Date sspFecAntiguedad;
    @Column(name = "SSP_FEC_EXTRAS")
    @Temporal(TemporalType.DATE)
    private Date sspFecExtras;
    @Column(name = "SSP_NUM_MATRICULA")
    private String sspNumMatricula;
    @Column(name = "SSP_NUM_PLURIEMPL")
    private String sspNumPluriempl;
    @Column(name = "SSP_PAGO_TA")
    private Short sspPagoTa;
    @Column(name = "SUK_ACT_LEAV_DT")
    @Temporal(TemporalType.DATE)
    private Date sukActLeavDt;
    @Column(name = "SUK_CONT_SERV_DATE")
    @Temporal(TemporalType.DATE)
    private Date sukContServDate;
    @Column(name = "SUK_LAST_WK_DT")
    @Temporal(TemporalType.DATE)
    private Date sukLastWkDt;
    @Column(name = "SUK_PROB_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date sukProbEndDate;
    @Column(name = "SUK_TERM_RESIG_DT")
    @Temporal(TemporalType.DATE)
    private Date sukTermResigDt;
    @Column(name = "SFR_DT_SENIORITY")
    @Temporal(TemporalType.DATE)
    private Date sfrDtSeniority;
    @Column(name = "SFR_DT_SENIORITY_G")
    @Temporal(TemporalType.DATE)
    private Date sfrDtSeniorityG;
    @Column(name = "SFR_DT_SENIORITY_L")
    @Temporal(TemporalType.DATE)
    private Date sfrDtSeniorityL;
    @Column(name = "STD_DT_SEN_PROF")
    @Temporal(TemporalType.DATE)
    private Date stdDtSenProf;
    @Column(name = "SFR_SEN_SUP")
    private Short sfrSenSup;
    @Column(name = "SUK_PROB_RESULTS")
    private Short sukProbResults;
    @Column(name = "SUK_EXT_PROB_END_D")
    @Temporal(TemporalType.DATE)
    private Date sukExtProbEndD;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "SME_ID_HR_STATUS")
    private String smeIdHrStatus;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SME_SALARY")
    private BigDecimal smeSalary;
    @Column(name = "SSP_CHK_IRPF_MOVIL")
    private Short sspChkIrpfMovil;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "SSP_CHK_IRPF_PROLO")
    private Short sspChkIrpfProlo;
    @Column(name = "SPO_COMENT_SAIDA")
    private String spoComentSaida;
    @Column(name = "SPO_ID_EST_QUADRO")
    private String spoIdEstQuadro;
    @Column(name = "SPO_ID_EST_SALARIO")
    private String spoIdEstSalario;
    @Column(name = "SPO_EXT_TELEF")
    private String spoExtTelef;
    @Column(name = "SAR_CERTIF_ORIG")
    private String sarCertifOrig;
    @Column(name = "SAR_CODIGO")
    private Integer sarCodigo;
    @Column(name = "SAR_ID_SIT_REVISTA")
    private String sarIdSitRevista;
    @Column(name = "SCB_OR_HR_PER_ANT")
    private Short scbOrHrPerAnt;
    @Column(name = "CCB_ID_MOT_REQUI")
    private String ccbIdMotRequi;
    @Column(name = "ID_SEGMENTO")
    private String idSegmento;
    @Column(name = "CCB_ID_TP_REQUI")
    private String ccbIdTpRequi;

    public StdHrPeriod() {
    }

    public StdHrPeriod(StdHrPeriodPK stdHrPeriodPK) {
        this.stdHrPeriodPK = stdHrPeriodPK;
    }

    public StdHrPeriod(String idOrganization, String stdIdHr, short stdOrHrPeriod) {
        this.stdHrPeriodPK = new StdHrPeriodPK(idOrganization, stdIdHr, stdOrHrPeriod);
    }

    public StdHrPeriodPK getStdHrPeriodPK() {
        return stdHrPeriodPK;
    }

    public void setStdHrPeriodPK(StdHrPeriodPK stdHrPeriodPK) {
        this.stdHrPeriodPK = stdHrPeriodPK;
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

    public String getStdIdHrpSrtRea() {
        return stdIdHrpSrtRea;
    }

    public void setStdIdHrpSrtRea(String stdIdHrpSrtRea) {
        this.stdIdHrpSrtRea = stdIdHrpSrtRea;
    }

    public String getStdIdHrpEndRea() {
        return stdIdHrpEndRea;
    }

    public void setStdIdHrpEndRea(String stdIdHrpEndRea) {
        this.stdIdHrpEndRea = stdIdHrpEndRea;
    }

    public String getStdIdHrType() {
        return stdIdHrType;
    }

    public void setStdIdHrType(String stdIdHrType) {
        this.stdIdHrType = stdIdHrType;
    }

    public String getStdComment() {
        return stdComment;
    }

    public void setStdComment(String stdComment) {
        this.stdComment = stdComment;
    }

    public String getStdIdExternOrg() {
        return stdIdExternOrg;
    }

    public void setStdIdExternOrg(String stdIdExternOrg) {
        this.stdIdExternOrg = stdIdExternOrg;
    }

    public String getStdKeyEmployee() {
        return stdKeyEmployee;
    }

    public void setStdKeyEmployee(String stdKeyEmployee) {
        this.stdKeyEmployee = stdKeyEmployee;
    }

    public String getStdStrategicEmp() {
        return stdStrategicEmp;
    }

    public void setStdStrategicEmp(String stdStrategicEmp) {
        this.stdStrategicEmp = stdStrategicEmp;
    }

    public String getSukContServReas() {
        return sukContServReas;
    }

    public void setSukContServReas(String sukContServReas) {
        this.sukContServReas = sukContServReas;
    }

    public Date getSspFecAntiguedad() {
        return sspFecAntiguedad;
    }

    public void setSspFecAntiguedad(Date sspFecAntiguedad) {
        this.sspFecAntiguedad = sspFecAntiguedad;
    }

    public Date getSspFecExtras() {
        return sspFecExtras;
    }

    public void setSspFecExtras(Date sspFecExtras) {
        this.sspFecExtras = sspFecExtras;
    }

    public String getSspNumMatricula() {
        return sspNumMatricula;
    }

    public void setSspNumMatricula(String sspNumMatricula) {
        this.sspNumMatricula = sspNumMatricula;
    }

    public String getSspNumPluriempl() {
        return sspNumPluriempl;
    }

    public void setSspNumPluriempl(String sspNumPluriempl) {
        this.sspNumPluriempl = sspNumPluriempl;
    }

    public Short getSspPagoTa() {
        return sspPagoTa;
    }

    public void setSspPagoTa(Short sspPagoTa) {
        this.sspPagoTa = sspPagoTa;
    }

    public Date getSukActLeavDt() {
        return sukActLeavDt;
    }

    public void setSukActLeavDt(Date sukActLeavDt) {
        this.sukActLeavDt = sukActLeavDt;
    }

    public Date getSukContServDate() {
        return sukContServDate;
    }

    public void setSukContServDate(Date sukContServDate) {
        this.sukContServDate = sukContServDate;
    }

    public Date getSukLastWkDt() {
        return sukLastWkDt;
    }

    public void setSukLastWkDt(Date sukLastWkDt) {
        this.sukLastWkDt = sukLastWkDt;
    }

    public Date getSukProbEndDate() {
        return sukProbEndDate;
    }

    public void setSukProbEndDate(Date sukProbEndDate) {
        this.sukProbEndDate = sukProbEndDate;
    }

    public Date getSukTermResigDt() {
        return sukTermResigDt;
    }

    public void setSukTermResigDt(Date sukTermResigDt) {
        this.sukTermResigDt = sukTermResigDt;
    }

    public Date getSfrDtSeniority() {
        return sfrDtSeniority;
    }

    public void setSfrDtSeniority(Date sfrDtSeniority) {
        this.sfrDtSeniority = sfrDtSeniority;
    }

    public Date getSfrDtSeniorityG() {
        return sfrDtSeniorityG;
    }

    public void setSfrDtSeniorityG(Date sfrDtSeniorityG) {
        this.sfrDtSeniorityG = sfrDtSeniorityG;
    }

    public Date getSfrDtSeniorityL() {
        return sfrDtSeniorityL;
    }

    public void setSfrDtSeniorityL(Date sfrDtSeniorityL) {
        this.sfrDtSeniorityL = sfrDtSeniorityL;
    }

    public Date getStdDtSenProf() {
        return stdDtSenProf;
    }

    public void setStdDtSenProf(Date stdDtSenProf) {
        this.stdDtSenProf = stdDtSenProf;
    }

    public Short getSfrSenSup() {
        return sfrSenSup;
    }

    public void setSfrSenSup(Short sfrSenSup) {
        this.sfrSenSup = sfrSenSup;
    }

    public Short getSukProbResults() {
        return sukProbResults;
    }

    public void setSukProbResults(Short sukProbResults) {
        this.sukProbResults = sukProbResults;
    }

    public Date getSukExtProbEndD() {
        return sukExtProbEndD;
    }

    public void setSukExtProbEndD(Date sukExtProbEndD) {
        this.sukExtProbEndD = sukExtProbEndD;
    }

    public String getIdApprole() {
        return idApprole;
    }

    public void setIdApprole(String idApprole) {
        this.idApprole = idApprole;
    }

    public String getSmeIdHrStatus() {
        return smeIdHrStatus;
    }

    public void setSmeIdHrStatus(String smeIdHrStatus) {
        this.smeIdHrStatus = smeIdHrStatus;
    }

    public String getIdSecuser() {
        return idSecuser;
    }

    public void setIdSecuser(String idSecuser) {
        this.idSecuser = idSecuser;
    }

    public BigDecimal getSmeSalary() {
        return smeSalary;
    }

    public void setSmeSalary(BigDecimal smeSalary) {
        this.smeSalary = smeSalary;
    }

    public Short getSspChkIrpfMovil() {
        return sspChkIrpfMovil;
    }

    public void setSspChkIrpfMovil(Short sspChkIrpfMovil) {
        this.sspChkIrpfMovil = sspChkIrpfMovil;
    }

    public Date getDtLastUpdate() {
        return dtLastUpdate;
    }

    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }

    public Short getSspChkIrpfProlo() {
        return sspChkIrpfProlo;
    }

    public void setSspChkIrpfProlo(Short sspChkIrpfProlo) {
        this.sspChkIrpfProlo = sspChkIrpfProlo;
    }

    public String getSpoComentSaida() {
        return spoComentSaida;
    }

    public void setSpoComentSaida(String spoComentSaida) {
        this.spoComentSaida = spoComentSaida;
    }

    public String getSpoIdEstQuadro() {
        return spoIdEstQuadro;
    }

    public void setSpoIdEstQuadro(String spoIdEstQuadro) {
        this.spoIdEstQuadro = spoIdEstQuadro;
    }

    public String getSpoIdEstSalario() {
        return spoIdEstSalario;
    }

    public void setSpoIdEstSalario(String spoIdEstSalario) {
        this.spoIdEstSalario = spoIdEstSalario;
    }

    public String getSpoExtTelef() {
        return spoExtTelef;
    }

    public void setSpoExtTelef(String spoExtTelef) {
        this.spoExtTelef = spoExtTelef;
    }

    public String getSarCertifOrig() {
        return sarCertifOrig;
    }

    public void setSarCertifOrig(String sarCertifOrig) {
        this.sarCertifOrig = sarCertifOrig;
    }

    public Integer getSarCodigo() {
        return sarCodigo;
    }

    public void setSarCodigo(Integer sarCodigo) {
        this.sarCodigo = sarCodigo;
    }

    public String getSarIdSitRevista() {
        return sarIdSitRevista;
    }

    public void setSarIdSitRevista(String sarIdSitRevista) {
        this.sarIdSitRevista = sarIdSitRevista;
    }

    public Short getScbOrHrPerAnt() {
        return scbOrHrPerAnt;
    }

    public void setScbOrHrPerAnt(Short scbOrHrPerAnt) {
        this.scbOrHrPerAnt = scbOrHrPerAnt;
    }

    public String getCcbIdMotRequi() {
        return ccbIdMotRequi;
    }

    public void setCcbIdMotRequi(String ccbIdMotRequi) {
        this.ccbIdMotRequi = ccbIdMotRequi;
    }

    public String getIdSegmento() {
        return idSegmento;
    }

    public void setIdSegmento(String idSegmento) {
        this.idSegmento = idSegmento;
    }

    public String getCcbIdTpRequi() {
        return ccbIdTpRequi;
    }

    public void setCcbIdTpRequi(String ccbIdTpRequi) {
        this.ccbIdTpRequi = ccbIdTpRequi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdHrPeriodPK != null ? stdHrPeriodPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdHrPeriod)) {
            return false;
        }
        StdHrPeriod other = (StdHrPeriod) object;
        if ((this.stdHrPeriodPK == null && other.stdHrPeriodPK != null) || (this.stdHrPeriodPK != null && !this.stdHrPeriodPK.equals(other.stdHrPeriodPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.StdHrPeriod[ stdHrPeriodPK=" + stdHrPeriodPK + " ]";
    }
    
}
