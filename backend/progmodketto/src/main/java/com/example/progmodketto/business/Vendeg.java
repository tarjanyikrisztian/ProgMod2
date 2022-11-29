package com.example.progmodketto.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

//import javax.persistence.criteria.CriteriaBuilder.In;

@Entity
@Table(name = "vendeg")
@EnableAutoConfiguration
public class Vendeg {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nev;
    @Column(nullable = false)
    private String telefonszam;

    public Vendeg() {
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(String telfonszam) {
        this.telefonszam = telfonszam;
    }

    public Integer getId() {
        return id;
    }
    
}
