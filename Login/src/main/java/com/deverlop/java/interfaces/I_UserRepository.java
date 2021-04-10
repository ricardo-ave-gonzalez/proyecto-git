package com.deverlop.java.interfaces;

import com.deverlop.java.models.User;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author richie
 */
public interface I_UserRepository {

    void save(User user);
    
    void update(User user);
    
    void remove(User user);

    List<User> getAll();

    default Stream<User> getStream() {
        return getAll().stream();
    }
    
    default User getById(String id){
        return getAll()
                .stream()
                .filter(u -> u.id.equals(id))
                .findAny()
                .orElse(new User());
    }
}