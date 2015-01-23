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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "indicadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicador.findAll", query = "SELECT i FROM Indicador i"),
    @NamedQuery(name = "Indicador.findById", query = "SELECT i FROM Indicador i WHERE i.id = :id"),
    @NamedQuery(name = "Indicador.findByNombre", query = "SELECT i FROM Indicador i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Indicador.findByInversion", query = "SELECT i FROM Indicador i WHERE i.inversion = :inversion"),
    @NamedQuery(name = "Indicador.findByMeta", query = "SELECT i FROM Indicador i WHERE i.meta = :meta"),
    @NamedQuery(name = "Indicador.findByUnidadmedicion", query = "SELECT i FROM Indicador i WHERE i.unidadmedicion = :unidadmedicion"),
    @NamedQuery(name = "Indicador.findByPeriodoinsersion", query = "SELECT i FROM Indicador i WHERE i.periodoinsersion = :periodoinsersion")})
public class Indicador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inversion")
    private Float inversion;
    @Column(name = "meta")
    private Float meta;
    @Column(name = "unidadmedicion")
    private Integer unidadmedicion;
    @Column(name = "periodoinsersion")
    private Integer periodoinsersion;
    @JoinColumn(name = "proceso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proceso proceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indicador")
    private List<ValorPeriodo> valorPeriodoList;

    public Indicador() {
    }

    public Indicador(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getInversion() {
        return inversion;
    }

    public void setInversion(Float inversion) {
        this.inversion = inversion;
    }

    public Float getMeta() {
        return meta;
    }

    public void setMeta(Float meta) {
        this.meta = meta;
    }

    public Integer getUnidadmedicion() {
        return unidadmedicion;
    }

    public void setUnidadmedicion(Integer unidadmedicion) {
        this.unidadmedicion = unidadmedicion;
    }

    public Integer getPeriodoinsersion() {
        return periodoinsersion;
    }

    public void setPeriodoinsersion(Integer periodoinsersion) {
        this.periodoinsersion = periodoinsersion;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    @XmlTransient
    public List<ValorPeriodo> getValorPeriodoList() {
        return valorPeriodoList;
    }

    public void setValorPeriodoList(List<ValorPeriodo> valorPeriodoList) {
        this.valorPeriodoList = valorPeriodoList;
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
        if (!(object instanceof Indicador)) {
            return false;
        }
        Indicador other = (Indicador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.simoin.api.Indicador[ id=" + id + " ]";
    }
    
}
