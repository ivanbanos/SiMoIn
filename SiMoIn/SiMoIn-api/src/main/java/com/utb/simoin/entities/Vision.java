/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utb.simoin.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "visiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vision.findAll", query = "SELECT v FROM Vision v"),
    @NamedQuery(name = "Vision.findById", query = "SELECT v FROM Vision v WHERE v.id = :id")})
public class Vision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "vision")
    private byte[] vision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vision")
    private List<Meta> metaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vision")
    private List<Periodo> periodoList;

    public Vision() {
    }

    public Vision(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getVision() {
        return vision;
    }

    public void setVision(byte[] vision) {
        this.vision = vision;
    }

    @XmlTransient
    public List<Meta> getMetaList() {
        return metaList;
    }

    public void setMetaList(List<Meta> metaList) {
        this.metaList = metaList;
    }

    @XmlTransient
    public List<Periodo> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(List<Periodo> periodoList) {
        this.periodoList = periodoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vision)) {
            return false;
        }
        Vision other = (Vision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.simoin.api.Vision[ id=" + id + " ]";
    }
    
}
