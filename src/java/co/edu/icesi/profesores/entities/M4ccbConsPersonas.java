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
@Table(name = "M4CCB_CONS_PERSONAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbConsPersonas.findAll", query = "SELECT m FROM M4ccbConsPersonas m"),
    @NamedQuery(name = "M4ccbConsPersonas.findByCcbIdPerson", query = "SELECT m FROM M4ccbConsPersonas m WHERE m.m4ccbConsPersonasPK.ccbIdPerson = :ccbIdPerson"),
    @NamedQuery(name = "M4ccbConsPersonas.findByCcbIdWeb", query = "SELECT m FROM M4ccbConsPersonas m WHERE m.m4ccbConsPersonasPK.ccbIdWeb = :ccbIdWeb"),
    @NamedQuery(name = "M4ccbConsPersonas.findByCcbDtStart", query = "SELECT m FROM M4ccbConsPersonas m WHERE m.m4ccbConsPersonasPK.ccbDtStart = :ccbDtStart"),
    @NamedQuery(name = "M4ccbConsPersonas.findByCcbDtEnd", query = "SELECT m FROM M4ccbConsPersonas m WHERE m.ccbDtEnd = :ccbDtEnd")})
public class M4ccbConsPersonas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbConsPersonasPK m4ccbConsPersonasPK;
    @Column(name = "CCB_DT_END")
    @Temporal(TemporalType.DATE)
    private Date ccbDtEnd;

    public M4ccbConsPersonas() {
    }

    public M4ccbConsPersonas(M4ccbConsPersonasPK m4ccbConsPersonasPK) {
        this.m4ccbConsPersonasPK = m4ccbConsPersonasPK;
    }

    public M4ccbConsPersonas(String ccbIdPerson, String ccbIdWeb, Date ccbDtStart) {
        this.m4ccbConsPersonasPK = new M4ccbConsPersonasPK(ccbIdPerson, ccbIdWeb, ccbDtStart);
    }

    public M4ccbConsPersonasPK getM4ccbConsPersonasPK() {
        return m4ccbConsPersonasPK;
    }

    public void setM4ccbConsPersonasPK(M4ccbConsPersonasPK m4ccbConsPersonasPK) {
        this.m4ccbConsPersonasPK = m4ccbConsPersonasPK;
    }

    public Date getCcbDtEnd() {
        return ccbDtEnd;
    }

    public void setCcbDtEnd(Date ccbDtEnd) {
        this.ccbDtEnd = ccbDtEnd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (m4ccbConsPersonasPK != null ? m4ccbConsPersonasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbConsPersonas)) {
            return false;
        }
        M4ccbConsPersonas other = (M4ccbConsPersonas) object;
        if ((this.m4ccbConsPersonasPK == null && other.m4ccbConsPersonasPK != null) || (this.m4ccbConsPersonasPK != null && !this.m4ccbConsPersonasPK.equals(other.m4ccbConsPersonasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.profesores.entities.M4ccbConsPersonas[ m4ccbConsPersonasPK=" + m4ccbConsPersonasPK + " ]";
    }
    
}
