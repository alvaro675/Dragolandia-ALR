package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "boladefuego")
public class Boladefuego implements Hechizo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String nombre;
    private int dano;

    Boladefuego(){}
    Boladefuego(String nombre){
        this.nombre=nombre;
    }
    @Override
    public void lanzarv(Monstruo[] m) {
        for (int i = 0; i < m.length; i++) {
            m[i].setVida(m[i].getVida()-40);
        }
    }
    @Override
    public void lanzar(Monstruo m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lanzar'");
    }

    @Override
        public String toString() {
            // TODO Auto-generated method stub
            return this.nombre;
        }
}
