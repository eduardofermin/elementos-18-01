/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.elementos1801;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author T-107
 */

@Entity
public class Direccion {
    @Id
    @GeneratedValue
    private Long id;
    
    //Relaccion con la entidad usuario(FK)
    @OneToOne
    @JoinColumn(name="cuenta")    
    private Usuario u;
    
    private String calle;
    private Integer cp;
    private String municipio;

    public Direccion() {
    }

    public Direccion(Long id, Usuario u, String calle, Integer cp, String municipio) {
        this.id = id;
        this.u = u;
        this.calle = calle;
        this.cp = cp;
        this.municipio = municipio;
    }

    public Direccion(Long id) {
        this.id = id;
    }

    public Direccion(Usuario u, String calle, Integer cp, String municipio) {
        this.u = u;
        this.calle = calle;
        this.cp = cp;
        this.municipio = municipio;
    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
}
