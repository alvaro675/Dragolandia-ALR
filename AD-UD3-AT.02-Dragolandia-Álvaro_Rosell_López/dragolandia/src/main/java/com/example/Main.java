package com.example;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Session session= null;
        Mago mago= new Mago();
        Monstruo mons= new Monstruo();
        Bosque bosque= new Bosque();
        Scanner sc= new Scanner(System.in);


        System.out.println("Mago");
            System.out.println("Id de Mago");
            mago.setId(sc.nextInt());
            sc.nextLine();
            System.out.println("Nombre Mago");
            mago.setNombre(sc.nextLine());
            System.out.println("Vida Mago");
            mago.setVida(sc.nextDouble());
            sc.nextLine();
            System.out.println("Nivel Magia Mago");
            mago.setNivelMagia(sc.nextDouble());
            sc.nextLine();

            System.out.println("Monstruo");
            System.out.println("Id Monstruo");
            mons.setId(sc.nextInt());
            sc.nextLine();
            System.out.println("Nombre Monstruo");
            mons.setNombre(sc.nextLine());
            System.out.println("Tipo Monstruo: 1.ogro 2.troll 3.espectro");
            mons.setTipo(sc.nextInt());
            sc.nextLine();
            System.out.println("Vida Monstruo");
            mons.setVida(sc.nextDouble());
            sc.nextLine();
            System.out.println("Fuerza Monstruo");
            mons.setFuerza(sc.nextDouble());
            sc.nextLine();

            
            System.out.println("Bosque");
            System.out.println("Id Bosque");
            bosque.setId(sc.nextInt());
            sc.nextLine();
            System.out.println("Nombre Bosque");
            bosque.setNombre(sc.nextLine());
            System.out.println("Nivel de peligro");
            bosque.setNivelPeligro(sc.nextDouble());
            sc.nextLine();
            bosque.cambiarJefe(mons);

            bosque.mostrarJefe();
            System.out.println("");


        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();){
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();


            session.persist(mago);
            session.persist(mons);
            session.persist(bosque);

            tx.commit();


        }catch (Exception e) {
            System.out.println("Error");
        }

        

        while (mago.getVida().equals(0.0) || bosque.getMonstruoJefe().getVida().equals(0.0) ) {
            mago.lanzarHechizo(bosque.getMonstruoJefe());
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