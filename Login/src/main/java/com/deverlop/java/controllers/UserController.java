package com.deverlop.java.controllers;

import com.deverlop.java.interfaces.I_UserRepository;
import com.deverlop.java.repositories.UserRepository;
import com.google.gson.Gson;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author richie
 */

//@RequestMapping("/usuarios")
@Path("/usuarios")
@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.GET,RequestMethod.POST}, maxAge = 3600)
@RestController
public class UserController {
    
    
    UserRepository ur;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
    I_UserRepository iUr = new UserRepository(emf);

    @Autowired
    public UserController() {
        ur = new UserRepository(emf);
    }

    /*
    @GetMapping("/all")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public  Iterable<User> getAll() {
        Iterable<User> user = ur.getAll();
        return user;    
    }
    */
    @GET
    @CrossOrigin( origins = "https://localhost:4200")//puerto front-end Angular
    @Path("/all")//https://localhost:8080/Login/api/usuarios/all
    public String getAll() {
        return new Gson().toJson(ur.getAll());
    }
    
}
