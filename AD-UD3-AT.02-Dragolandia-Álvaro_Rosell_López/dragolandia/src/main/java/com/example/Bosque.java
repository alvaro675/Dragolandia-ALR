package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bosque")
public class Bosque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private Double nivelPeligro;
    private Monstruo monstruoJefe;

    public Bosque(){}
    public Bosque( int id,String nombre,Double nivelPeligro,Monstruo monstruoJefe){
        this.id= id;
        this.nombre= nombre;
        this.nivelPeligro= nivelPeligro;
        this.monstruoJefe=monstruoJefe;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getNivelPeligro() {
        return nivelPeligro;
    }
    public void setNivelPeligro(Double nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }
    public Monstruo getMonstruoJefe() {
        return monstruoJefe;
    }
    public void setMonstruoJefe(Monstruo monstruoJefe) {
        this.monstruoJefe = monstruoJefe;
    }

    void mostrarJefe(){
        Monstruo m=getMonstruoJefe();
       System.out.println("Id: "+m.getId()+" Nombre: "+m.getNombre()+" Tipo: "+m.getTipo()+" Vida: "+m.getVida()+" Fuerza: "+m.getFuerza()); 

    }
    void cambiarJefe(Monstruo m){
        this.setMonstruoJefe(m);
    }
}
