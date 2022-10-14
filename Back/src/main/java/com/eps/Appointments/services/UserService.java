/**
* Package with which the services of the appointments access
**/
package com.eps.Appointments.services;
/**
* Imports of java util
*/
import java.util.List;
/**
* Imports of transaction
*/
import javax.transaction.Transactional;
/**
* Imports of springframework
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.UserDTO;
import com.eps.Appointments.mappers.UserMapper;
import com.eps.Appointments.persistance.entities.User;
import com.eps.Appointments.persistance.repositories.UserRepository;
/**
* Creation of the public class AdminService
* @Service It is used to mark the class as a service provider 
**/
@Service
public class UserService {
    /**
    * annotation that allows to inject some dependencies with others inside Spring
    **/
    @Autowired
    /**
    * Private attribute of type UserMapper of name userMapper
    **/
    private UserMapper userMapper;
    @Autowired
    /**
    * Private attribute of type UserRepository of name userRepository
    **/
    private UserRepository userRepository;
    /**
    * class creation UserDTO with attributes user and exception IllegalArgumentException
    * @Transactional annotation is the metadata that specifies the semantics of the transactions on a method
    **/
    @Transactional
    public UserDTO create(UserDTO user) throws IllegalArgumentException{
        return userMapper.toUserDTO(userRepository.save(userMapper.toUser(user)));
    }
    /**
    * creation of the class UserDTO getById with id attributes
    **/
    public UserDTO getById(String id){
        return userMapper.toUserDTO(userRepository.findById(id).map(user -> {
            return user;
        }).orElse(null));
    }
    /**
    * creation of the class List<UserDTO> getAll
    **/
    public List<UserDTO> getAll(){
        List<User> user=(List<User>) userRepository.findAll();
        return userMapper.toUserDTOs(user);
    }
       /**
    * class creation UserDTO with updateUser and userSTO attributes 
    * @Transactional annotation is the metadata that specifies the semantics of the transactions on a method
    **/
    @Transactional
    public UserDTO updateUser(UserDTO userDTO){
        if(getById(userDTO.getId()) != null){
            User updateUser = userMapper.toUser(userDTO);
            return userMapper.toUserDTO(userRepository.save(updateUser));
        }
        return null;
    }
    
}
