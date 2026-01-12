package com.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "boladenieve")
public class Boladenieve implements Hechizo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String nombre;

    Boladenieve(){}
    Boladenieve(String nombre){
        this.nombre=nombre;
    }

    @Override
    public void lanzarv(Monstruo[] m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lanzarv'");
    }

    @Override
    public void lanzar(Monstruo m) {
        m.setVida(0.0);
    }

    @Override
        public String toString() {
            // TODO Auto-generated method stub
            return this.nombre;
        }

        
}
