package com.eps.Appointments.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.persistance.entities.User;
import com.eps.Appointments.persistance.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User create(User user) throws IllegalArgumentException{
        return userRepository.save(user);
    }

    public User getUser(String id){
        return userRepository.findById(id).map(user -> {
            return user;
        }).orElse(null);
    }
    
}
