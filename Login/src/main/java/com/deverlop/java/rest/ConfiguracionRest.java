package com.deverlop.java.rest;
import com.deverlop.java.controllers.UserController;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//seteamos api como raiz en Rest
@ApplicationPath("api")//https://localhost:8080/Login/api/
public class ConfiguracionRest extends Application{    
    
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>>classes=new HashSet();
        classes.add(UserController.class);
        return classes;
    }
    
    
}
