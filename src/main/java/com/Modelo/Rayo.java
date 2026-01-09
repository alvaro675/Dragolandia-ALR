package com.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "rayo")
public class Rayo implements Hechizo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String nombre;
    private int dano=50;

    Rayo(){}
    Rayo(String nombre, int dano){
        this.nombre=nombre;
        this.dano=dano;
    }


    @Override
    public void lanzarv(Monstruo[] m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lanzarv'");
    }

    @Override
    public void lanzar(Monstruo m) {
        m.setVida(m.getVida()-dano);
    }

    @Override
        public String toString() {
            // TODO Auto-generated method stub
            return this.nombre;
        }
        
}
