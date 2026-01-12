package com.vista;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modelo.Boladefuego;
import com.modelo.Boladenieve;
import com.modelo.Bosque;
import com.modelo.Dragon;
import com.modelo.Hechizo;
import com.modelo.Lanzardado;
import com.modelo.Mago;
import com.modelo.Monstruo;
import com.modelo.Rayo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {

        Session session= null;
        Mago mago= new Mago();
        Monstruo mons= new Monstruo();
        Bosque bosque= new Bosque();
        Dragon dragon= new  Dragon();
        Scanner sc= new Scanner(System.in);
        //Hechizo[] listaHechizos= {Rayo.class};


         System.out.println("Bosque");
            //System.out.println("Id Bosque");
            bosque.setId();
            //sc.nextLine();
            System.out.println("Nombre Bosque");
            bosque.setNombre(sc.nextLine());
            System.out.println("Nivel de peligro");
            bosque.setNivelPeligro(sc.nextDouble());
            sc.nextLine();
            bosque.cambiarJefe(mons);


            int nmonstruos=2;
            while (nmonstruos<3) {
                System.out.println("Cuantos monstruos a crear? (Minimo 3)");
                nmonstruos= sc.nextInt();
                sc.nextLine();   
            }


        for (int i = 0; i < nmonstruos; i++) {
            System.out.println("Monstruo");
            //System.out.println("Id Monstruo");
            mons.setId();
            //sc.nextLine();
            System.out.println("Nombre Monstruo");
            mons.setNombre(sc.nextLine());
            System.out.println("Tipo Monstruo: 1.ogro 2.troll 3.espectro");
            mons.setTipo(sc.nextInt());
            sc.nextLine();
            /*
            System.out.println("Vida Monstruo");
            mons.setVida(sc.nextDouble());
            sc.nextLine();*/
            mons.setVidaSegunTipo();
            System.out.println("Fuerza Monstruo");
            mons.setFuerza(sc.nextDouble());
            sc.nextLine();
            bosque.addMonstruo(mons);    
        }
        List<Monstruo> listamontruos= bosque.getMonstruosL();
        bosque.cambiarJefe(listamontruos.get(1));
            
        System.out.println("Dragon");
            System.out.println("Nombre dragon");
            dragon.setNombre(sc.nextLine());
            System.out.println("Resistencia");
            dragon.setResistencia(sc.nextDouble());
            sc.nextLine();
            System.out.println("Intensidad set");
            dragon.setIntesidadFuego(sc.nextDouble());
            sc.nextLine();

            int nmagos=1;
            while (nmagos<2) {
                System.out.println("Cuantos magos a crear? (Minimo 2)");
                nmagos= sc.nextInt();
                sc.nextLine();   
            }

        Rayo rayo= new Rayo();
        Boladefuego boladefuego= new Boladefuego();
        Boladenieve boladenieve= new Boladenieve();
        Lanzardado lanzardado= new Lanzardado();
        Hechizo[] listaHechizos = {rayo,boladefuego,boladenieve,lanzardado};

        for (int i = 0; i < nmagos; i++) {
        System.out.println("Mago");
            //System.out.println("Id de Mago");
            mago.setId();
            //sc.nextLine();
            System.out.println("Nombre Mago");
            mago.setNombre(sc.nextLine());
            System.out.println("Vida Mago");
            mago.setVida(sc.nextDouble());
            sc.nextLine();
            System.out.println("Nivel Magia Mago");
            mago.setNivelMagia(sc.nextDouble());
            sc.nextLine();
            mago.setConjuros(listaHechizos);
                
        }    
        

            


            
           bosque.mostrarJefe();
            System.out.println("");
            System.out.println("");
            






        

        
            
        while (mago.getVida().equals(0.0) || bosque.getMonstruoJefe().getVida().equals(0.0) ) {
            mago.lanzarHechizo(bosque.getMonstruoJefe(),rayo);
            bosque.getMonstruoJefe().atacar(mago);
        }
        if (bosque.getMonstruoJefe().getVida().equals(0.0)) {
            System.out.println("El mago "+mago.getNombre()+" a derrotado al monstruo");
           

        }
        if (mago.getVida().equals(0.0)) {
            System.out.println("El monstruo gana");
            bosque.mostrarJefe();
        }






    }
}