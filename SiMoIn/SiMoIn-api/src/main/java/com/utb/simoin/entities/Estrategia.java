/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utb.simoin.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "estrategias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estrategia.findAll", query = "SELECT e FROM Estrategia e"),
    @NamedQuery(name = "Estrategia.findById", query = "SELECT e FROM Estrategia e WHERE e.id = :id"),
    @NamedQuery(name = "Estrategia.findByNombre", query = "SELECT e FROM Estrategia e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estrategia.findByDescripcion", query = "SELECT e FROM Estrategia e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Estrategia.findByImpacto", query = "SELECT e FROM Estrategia e WHERE e.impacto = :impacto"),
    @NamedQuery(name = "Estrategia.findByCumplio", query = "SELECT e FROM Estrategia e WHERE e.cumplio = :cumplio")})
public class Estrategia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "impacto")
    private Integer impacto;
    @Column(name = "cumplio")
    private Boolean cumplio;
    @JoinColumn(name = "periodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ValorPeriodo periodo;

    public Estrategia() {
    }

    public Estrategia(Integer id) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getImpacto() {
        return impacto;
    }

    public void setImpacto(Integer impacto) {
        this.impacto = impacto;
    }

    public Boolean getCumplio() {
        return cumplio;
    }

    public void setCumplio(Boolean cumplio) {
        this.cumplio = cumplio;
    }

    public ValorPeriodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(ValorPeriodo periodo) {
        this.periodo = periodo;
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
        if (!(object instanceof Estrategia)) {
            return false;
        }
        Estrategia other = (Estrategia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.simoin.api.Estrategia[ id=" + id + " ]";
    }
    
}
