package com.example.progmodketto.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Table(name = "konyv")
@EnableAutoConfiguration
public class Konyv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String cim;
    @Column(nullable = false)
    private String szerzo;
    @Column(nullable = false)
    private String kiado;
    @Column(nullable = false)
    private Integer kiadasEve;
    @ManyToOne
    @JoinColumn(name = "vendeg_id")
    private Vendeg vendeg;



    public Konyv() {
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public String getKiado() {
        return kiado;
    }

    public void setKiado(String kiado) {
        this.kiado = kiado;
    }

    public Integer getKiadasEve() {
        return kiadasEve;
    }

    public void setKiadasEve(Integer kiadasEve) {
        this.kiadasEve = kiadasEve;
    }

    public Vendeg getVendeg() {
        return vendeg;
    }

    public Integer getId() {
        return id;
    }

    public void setVendeg(Vendeg vendeg) {
        this.vendeg = vendeg;
        
    }
    
}
