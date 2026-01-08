package com.example;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mago")
public class Mago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private Double vida;
    private Double nivelMagia;
    



    public Mago (){}

    public Mago(int id, String nombre, Double vida,Double nivelMagia ){
        this.id= id;
        this.nombre= nombre;
        this.vida= vida;
        this.nivelMagia= nivelMagia;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Double getNivelMagia() {
        return nivelMagia;
    }
    public void setNivelMagia(Double nivelMagia) {
        this.nivelMagia = nivelMagia;
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
    void lanzarHechizo(Monstruo m){

        m.setVida( m.getVida() - this.getNivelMagia()) ; 

    }

}
