package com.modelo;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hechizo")
public interface Hechizo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
/*
    private String Nombre;

    Hechizo(){}
    Hechizo(String Nombre){
        this.Nombre=Nombre;
    }
    */ 
   
   
    void lanzarv(Monstruo[] m);
    void lanzar(Monstruo m);
 


    /*
    void bolaDeFuego(Monstruo[] m){

        for (int i = 0; i < m.length; i++) {
            m[i].setVida(m[i].getVida()-40);
        }

    }

    void Rayo(Monstruo m){
        m.setVida(m.getVida()-10);
    }

    void bolaDeNieve(Monstruo m){
        m.setVida(0.0);
    }
    //Daño aleatorio
    void lanzarDado(Monstruo m){
        //int[] dado= {1,10,20,60,70,150};
        m.setVida(m.getVida()-Math.random());

    }



*/


/*
    @ManyToOne
    private Mago mago;*/
    
   
}
