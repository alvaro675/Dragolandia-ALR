package com.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modelo.Bosque;
import com.modelo.Dragon;
import com.modelo.Mago;
import com.modelo.Monstruo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
public class ControladorBosque{
   void insertar(Bosque bosque){
    try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();


            factory.persist(bosque);

            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    void buscar(){
         try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();

            Bosque a = factory.find(Bosque.class, 1);

            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
    }
    void actualizar(Bosque bosque){
         try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();

            Bosque a = factory.find(Bosque.class, 1);

            a.cambiarJefe(bosque.getMonstruoJefe());
            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
    }
    void borrar(){
         try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();

            Bosque a = factory.find(Bosque.class, 1);
            factory.remove(a);
            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
        
    }
       
}

    

