package com.anjana.Journal.Services;

import com.anjana.Journal.Entity.User;
import com.anjana.Journal.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //To save user in database
    public User saveEntry(User user){
        return userRepository.save(user);
    }

    //To get all users from database
    public List<User> getAll(){
        return userRepository.findAll();
    }

    //To get user by Id
    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    //To delete user by Id

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
