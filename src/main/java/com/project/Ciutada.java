package com.project;

import java.io.Serializable;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

public class Ciutada implements Serializable{

    private long ciutadaId;
    private Ciutat ciutat;
    private String nom, cognom;
    private Integer edat;

    public Ciutada(){}

    public Ciutada(String nom, String cognom, Integer edat) {
        
        this.nom = nom;
        this.cognom =cognom;
        this.edat = edat;
    }

    public Ciutat getCiutat() {
        return ciutat;
    }

    public void setCiutat(Ciutat ciutat) {
        this.ciutat = ciutat;
    }

    public long getCiutadaId() {
        return ciutadaId;
    }

    public void setCiutadaId(long ciutadaId) {
        this.ciutadaId = ciutadaId;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

        @Override
    public String toString() {
        return this.getCiutadaId() + ": " + this.getNom() + " " + this.getCognom() + ": " + this.getEdat() + " Anys";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Ciutada ciutada = (Ciutada) o;
        return ciutadaId == ciutada.ciutadaId;
    }
    
    @Override
    public int hashCode() {
        return Long.hashCode(ciutadaId);
    }    

}