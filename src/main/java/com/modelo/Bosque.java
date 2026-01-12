package com.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    private List<Monstruo> monstruosL;

    public Bosque(){}
    public Bosque( int id,String nombre,Double nivelPeligro,Monstruo monstruoJefe,List<Monstruo> monstruosL){
        this.id= id;
        this.nombre= nombre;
        this.nivelPeligro= nivelPeligro;
        this.monstruoJefe=monstruoJefe;
        this.monstruosL=monstruosL;
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
    public void setMonstruosL(List<Monstruo> monstruosL) {
        this.monstruosL = monstruosL;
    }
    public List<Monstruo> getMonstruosL() {
        return monstruosL;
    }

    public void mostrarJefe(){
        Monstruo m=getMonstruoJefe();
       System.out.println("Id: "+m.getId()+" Nombre: "+m.getNombre()+" Tipo: "+m.getTipo()+" Vida: "+m.getVida()+" Fuerza: "+m.getFuerza()); 

    }
    public void cambiarJefe(Monstruo m){
        this.setMonstruoJefe(m);
    }

    public void addMonstruo(Monstruo m){
        List<Monstruo> l=monstruosL;
        l.add(m);
        setMonstruosL(l);
    }

    @OneToMany
    private Monstruo monstruo;
}
