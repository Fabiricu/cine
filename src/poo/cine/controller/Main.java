/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cine.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author joaquinleonelrobles
 */
public class Main {
   static private SessionFactory sessionFactory = null;
    
    public static void main (String[] args) {
        
        
        // A SessionFactory is set up once for an application!
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure("resources/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
			.build();
	try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	}
	catch (Exception e) {
            System.out.println("Error al crear factory: " + e.getMessage());

            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
	}
        
        new GestorPelicula(sessionFactory).run();
        
    }
    
     /*void agregargenero(String s){
     
     Genero g = new Genero();
     g.setname(s);
     
     Session se = sessionFactory.openSession();
    se.beginTransaction();
    se.save(g);
    se.getTransaction().commit();
    se.close();
    
     }
    */
}
