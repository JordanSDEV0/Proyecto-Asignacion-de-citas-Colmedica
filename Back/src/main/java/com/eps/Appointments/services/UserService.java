package com.eps.Appointments.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.DTOs.UserDTO;
import com.eps.Appointments.mappers.UserMapper;
import com.eps.Appointments.persistance.entities.User;
import com.eps.Appointments.persistance.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDTO create(UserDTO user) throws IllegalArgumentException{
        return userMapper.toUserDTO(userRepository.save(userMapper.toUser(user)));
    }

    public UserDTO getById(String id){
        return userMapper.toUserDTO(userRepository.findById(id).map(user -> {
            return user;
        }).orElse(null));
    }

    public List<UserDTO> getAll(){
        List<User> user=(List<User>) userRepository.findAll();
        return userMapper.toUserDTOs(user);
    }
    
}
