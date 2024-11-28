package com.project;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

public class Ciutat implements Serializable{
    private long ciutatId;
    private String nom, pais;
    private Integer poblacio;

    private Set<Ciutada> ciutadans = new HashSet<>();

    public Ciutat(){}

    public Ciutat(String nom, String pais, Integer poblacio) {
        
        this.nom = nom;
        this.pais = pais;
        this.poblacio = poblacio;
    }


    public long getCiutatId() {
        return ciutatId;
    }

    public void setCiutatId(long ciutatId) {
        this.ciutatId = ciutatId;
    }
        
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(Integer poblacio) {
        this.poblacio = poblacio;
    }
    
    public Set<Ciutada> getCiutadans() {
        return ciutadans;
    }


    public void setCiutadans(Set<Ciutada> ciutadans) {
        if (ciutadans != null) {
            ciutadans.forEach(this::addCiutada);
        }
    }

    public void addCiutada(Ciutada ciutada) {
        ciutadans.add(ciutada);
        ciutada.setCiutat(this);
    }

    public void removeCiutada(Ciutada ciutada) {
        ciutadans.remove(ciutada);
        ciutada.setCiutat(null);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Ciutada ciutada : ciutadans) {
            if (str.length() > 0) {
                str.append(" | ");
            }
            str.append(ciutada.getNom());
            str.append(" " + ciutada.getCognom());
        }
        return this.getCiutatId() + ": " + this.getNom() + ", " + this.getPais() + ", (" + this.getPoblacio() + "), Ciutadans: [" + str + "]";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Ciutat ciutat = (Ciutat) o;
        return ciutatId == ciutat.ciutatId;
    }
    
    @Override
    public int hashCode() {
        return Long.hashCode(ciutatId);
    }  

}