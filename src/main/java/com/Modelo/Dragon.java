package com.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dragon")
public class Dragon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Nombre;
    private Double IntesidadFuego;
    private Double resistencia;
    
    public Dragon(){}
    Dragon(String Nombre,Double IntesidadFuego,Double resistencia){
        this.Nombre=Nombre;
        this.IntesidadFuego=IntesidadFuego;
        this.resistencia=resistencia;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public void setResistencia(Double resistencia) {
        if (resistencia < 0.0) {
            System.out.println("Error la vida no puede ser negativa");
            this.resistencia= 0.0;
        }else{
            this.resistencia = resistencia;
        }
    }
    public void setIntesidadFuego(Double intesidadFuego) {
        IntesidadFuego = intesidadFuego;
    }
    public Double getIntesidadFuego() {
        return IntesidadFuego;
    }
    public String getNombre() {
        return Nombre;
    }
    public Double getResistencia() {
        return resistencia;
    }

    void exhalar(Monstruo m){

        m.setVida( m.getVida() - getIntesidadFuego() ) ; 

    }


    @OneToOne
    private Bosque bosque;

}
