package com.controlador;

import com.modelo.Bosque;
import com.modelo.Dragon;
import com.modelo.Mago;

import jakarta.persistence.EntityManager;

public class Controladordragon {
    void insertar(Dragon dragon){
    try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();


            factory.persist(dragon);

            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    void buscar(){
         try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();

            Dragon a = factory.find(Dragon.class, 1);

            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
    }
    void actualizar(Dragon dragon){
         try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();

            Dragon a = factory.find(Dragon.class, 1);

        
            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
    }
    void borrar(){
         try (EntityManager factory = HibernateUtil.getEntityManager();){
            
            factory.getTransaction().begin();

            Dragon a = factory.find(Dragon.class, 1);
            factory.remove(a);
            factory.getTransaction().commit();


        }catch (Exception e) {
            System.out.println("Error");
        }
        
}
}
