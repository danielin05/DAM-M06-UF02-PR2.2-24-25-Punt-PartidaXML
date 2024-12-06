package com.project;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ciutadans")
public class Ciutada implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ciutadaId", unique=true, nullable=false)

    private long ciutadaId;

    private String nom, cognom;
    private Integer edat;
    
    @ManyToOne
    @JoinColumn(name="ciutatId")
    private Ciutat ciutat;


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