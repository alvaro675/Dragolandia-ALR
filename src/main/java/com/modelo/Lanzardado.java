package com.modelo;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hechizo")
public class Lanzardado extends Hechizo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    

    private String nombre;

    public Lanzardado(){}
    Lanzardado(String nombre){
        this.nombre=nombre;
    }
/*
    @Override
    public void lanzarv(Monstruo[] m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lanzarv'");
    }

    @Override
    public void lanzar(Monstruo m) {
        int[] dado= {1,10,20,60,70,150};
        
        m.setVida(m.getVida()   );
    }
*/



    /*
    @Override
    public boolean equals(Object obj) {
        
        return ;
    }*/

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return this.nombre;
        }

}
