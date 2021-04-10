package com.deverlop.java.repositories;

import com.deverlop.java.models.User;
import com.deverlop.java.interfaces.I_UserRepository;
import static com.deverlop.java.utiles.Utiles.tryCatch;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author richie
 */
public class UserRepository implements I_UserRepository {

    private EntityManagerFactory emf;

    public UserRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(User user) {
            if (user == null) return;
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            em.close();
    }

    @Override
    public void update(User user) {
        if (user == null) return;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(user));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(User user) {
        if (user == null) return;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //em.persist(em.merge(user));
        em.remove(em.contains(user) ? user : em.merge(user));
        em.getTransaction().commit();
        em.close();
    }
   
    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList();
        EntityManager em = emf.createEntityManager();
        list = (List<User>) em.createNamedQuery("User.findAll").getResultList();
        em.close();
        return list;
    }

}
