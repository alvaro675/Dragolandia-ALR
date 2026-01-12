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
public class ControladorMonstruo{
    void insertar(Monstruo mons){
    try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();


            factory.persist(mons);

            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    void buscar(){
         try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();

            Monstruo a = factory.find(Monstruo.class, 1);

            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
        
    }
    void actualizar(Monstruo monstruo){
         try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();

            Monstruo a = factory.find(Monstruo.class, 1);
            a.setVida(monstruo.getVida());
            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
    }
    void borrar(){
         try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();

            Monstruo a = factory.find(Monstruo.class, 1);
            factory.remove(a);
            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
        
    }
       
}

    

