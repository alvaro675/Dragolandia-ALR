package com.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "monstruo")
public class Monstruo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private Double vida;
    private String tipo;
    private Double fuerza;

    public Monstruo(){}
    Monstruo(int id,String nombre,Double vida,String tipo,Double fuerza){

        this.id= id;
        this.nombre= nombre;
        this.vida= vida;
        this.tipo= tipo;
        this.fuerza= fuerza;
        

    }

    public int getId() {
        return id;
    }
    public void setId() {
        this.id= getId()+1;
        
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getVida() {
        return vida;
    }
    public void setVida(Double vida) {
        
        if (vida < 0.0) {
            System.out.println("Error la vida no puede ser negativa");
            this.vida= 0.0;
        }else{
            this.vida = vida;
        }
    }
    public void setVidaSegunTipo() {


        String tipo= getTipo();

        if (tipo.equals("ogro")) {
            this.vida=80.0;
        }
        if (tipo.equals("troll")) {
            this.vida=125.46;
        }
        if (tipo.equals("espectro")) {
            this.vida=40.0;
        }
        

        /*
        if (vida < 0.0) {
            System.out.println("Error la vida no puede ser negativa");
            this.vida= 0.0;
        }else{
            this.vida = vida;
        }*/
    }
    public void setFuerza(Double fuerza) {
        this.fuerza = fuerza;
    }
    public Double getFuerza() {
        return fuerza;
    }
    public void setTipo(int t) {
        if (t== 1) {
            this.tipo = "ogro" ;    
        }
        if (t== 2) {
            this.tipo = "troll";    
        }
        if (t==3) {
            this.tipo = "espectro" ;    
        }
        
    }
    public String getTipo() {
        return tipo;
    }

    public void atacar(Mago m){

        m.setVida( m.getVida() - this.getFuerza()) ; 

    }

    @ManyToOne
    private Bosque bosque;

}
