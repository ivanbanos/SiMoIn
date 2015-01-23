/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utb.simoin.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "valoresperiodos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValorPeriodo.findAll", query = "SELECT v FROM ValorPeriodo v"),
    @NamedQuery(name = "ValorPeriodo.findById", query = "SELECT v FROM ValorPeriodo v WHERE v.id = :id"),
    @NamedQuery(name = "ValorPeriodo.findByValor", query = "SELECT v FROM ValorPeriodo v WHERE v.valor = :valor"),
    @NamedQuery(name = "ValorPeriodo.findByFecha", query = "SELECT v FROM ValorPeriodo v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "ValorPeriodo.findByInversion", query = "SELECT v FROM ValorPeriodo v WHERE v.inversion = :inversion"),
    @NamedQuery(name = "ValorPeriodo.findByValordeseado", query = "SELECT v FROM ValorPeriodo v WHERE v.valordeseado = :valordeseado")})
public class ValorPeriodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "inversion")
    private String inversion;
    @Column(name = "valordeseado")
    private Float valordeseado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<Estrategia> estrategiaList;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "indicador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Indicador indicador;

    public ValorPeriodo() {
    }

    public ValorPeriodo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public Float getValordeseado() {
        return valordeseado;
    }

    public void setValordeseado(Float valordeseado) {
        this.valordeseado = valordeseado;
    }

    @XmlTransient
    public List<Estrategia> getEstrategiaList() {
        return estrategiaList;
    }

    public void setEstrategiaList(List<Estrategia> estrategiaList) {
        this.estrategiaList = estrategiaList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
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
        if (!(object instanceof ValorPeriodo)) {
            return false;
        }
        ValorPeriodo other = (ValorPeriodo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.simoin.api.ValorPeriodo[ id=" + id + " ]";
    }
    
}
