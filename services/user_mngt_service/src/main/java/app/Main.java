package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {


    public static void main (String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "persistanceUnit" );
        EntityManager entitymanager = emfactory.createEntityManager();

        entitymanager.getTransaction().begin();

//        entitymanager.persist(person);

        entitymanager.getTransaction().commit();
        entitymanager.close();


    }
}
