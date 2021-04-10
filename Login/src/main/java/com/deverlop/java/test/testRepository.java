package com.deverlop.java.test;

import com.deverlop.java.interfaces.I_UserRepository;
import com.deverlop.java.repositories.UserRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author richie
 */
public class testRepository {

    public static void main(String[] args) {
        
        /**
         * testeamos, persistimos y creamos 
         * un usuario en la base de datos
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
        EntityManager em=emf.createEntityManager();
        I_UserRepository ur = new UserRepository(emf);

        
        /*User user = new User(
                UUID.randomUUID().toString(), 
                "dario@deverlop.com", 
                "1a1s2s2d3cefef3232f"
        );
        ur.save(user);
        ver(user);*/
        
        
        /**
         * testeamos seleccionar por id
         * y deseamos mostrar el objeto
         */
        
        //User user = new User();
        //user = ur.getById("b3f84fe8-5d0c-466e-b9a6-c89258c7b3ed");
        //ver(user);
        
        
        /**
         * testeamos borrar objeto
         * por id
         */
        ur.remove(ur.getById("b9b76f86-903f-11eb-a677-4851b707621e"));
        
        
            
        em.close();
    }
}
