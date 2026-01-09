package com.Modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private Hechizo Conjuros;
    



    public Mago (){}

    public Mago(int id, String nombre, Double vida,Double nivelMagia, Hechizo Conjuros){
        this.id= id;
        this.nombre= nombre;
        this.vida= vida;
        this.nivelMagia= nivelMagia;
        this.Conjuros=Conjuros;
    }


    public int getId() {
        return id;
    }
    public void setId() {
        this.id= getId()+1;
        
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
    
    void LanzarHechizo(Monstruo m, Hechizo hechizo){


        if (hechizo instanceof Boladefuego) {
           /* for (int i = 0; i < m.length; i++) {
            m[i].setVida(m[i].getVida()-40); */

            m.setVida(m.getVida()-40);
        }else{
        
        if (hechizo instanceof Rayo) {
            m.setVida(m.getVida() - 50 );
        }else{
        if (hechizo instanceof Boladenieve) {
            m.setVida(0.0 );
        }else{
        if (hechizo instanceof Lanzardado) {
            m.setVida(Math.random() );
        }else{
            setVida(getVida()-1);
        }
    }
        }
        }
        
        
        




        /*
        Boolean valido= false;

        for (int i = 0; i < getConjuros().length; i++) {
            if (getConjuros()[i].equals(hechizo)) {
            valido=true;
            i=getConjuros().length;
        }    
        }*/
        /*
        if (valido) {
            // m.setVida( m.getVida() - this.getNivelMagia()) ; 
        }else{
           setVida(getVida()-1); 
        }*/
        
    } 

    
    @OneToMany
    private Hechizo hechizo;
}
