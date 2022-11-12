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
import com.eps.Appointments.DTOs.DoctorDTO;
import com.eps.Appointments.mappers.DoctorMapper;
import com.eps.Appointments.mappers.UserMapper;
import com.eps.Appointments.persistance.entities.Doctor;
import com.eps.Appointments.persistance.entities.User;
import com.eps.Appointments.persistance.repositories.DoctorRepository;
/**
* Creation of the public class DoctorService
* @Service It is used to mark the class as a service provider 
**/
@Service
public class DoctorService {
	/**
    * annotation that allows to inject some dependencies with others inside Spring
    **/
    @Autowired
	/**
    * Private attribute of type DoctorRepository of name doctorRepository
    **/
    private DoctorRepository doctorRepository;
    @Autowired
	/**
    * Private attribute of type DoctorMapper of name doctorMapper
    **/
    private DoctorMapper doctorMapper;
    @Autowired
	/**
    * Private attribute of type UserService of name userService
    **/
    private UserService userService;
    @Autowired
	/**
    * Private attribute of type UserMapper of name userMapper
    **/
    private UserMapper userMapper;
/**
    * class creation DoctorDTO with attributes doctorDTO and exception IllegalArgumentException
    * @Transactional annotation is the metadata that specifies the semantics of the transactions on a method
    **/
    @Transactional
    public DoctorDTO create(DoctorDTO doctorDTO) throws IllegalArgumentException{
        if(userService.getById(doctorDTO.getId()) == null){
            User newUser= userMapper.toUser(userService.create(userMapper.toUserDTO(new User(doctorDTO.getId(), doctorDTO.getPassword(), doctorDTO.getRol()))));
            if(newUser != null){
                Doctor newDoctor= doctorMapper.toDoctor(doctorDTO);
                newDoctor.setUser(newUser);
                return doctorMapper.toDoctorDTO(doctorRepository.save(newDoctor));
            }
            return null;
        }else{
            return null;
        }
    }
/**
    * creation of the class DoctorDTO getById with id attributes
    **/
    public DoctorDTO getById(String id){
        return doctorMapper.toDoctorDTO(doctorRepository.findById(id).map(doctor -> {
            return doctor;
        }).orElseGet(null));
    }

     /**
    * class creation DoctorDTO with and updateDoctor attributes doctorDTO 
    * @Transactional annotation is the metadata that specifies the semantics of the transactions on a method
    **/
    @Transactional
    public DoctorDTO updateDoctor(DoctorDTO doctorDTO){
        if(getById(doctorDTO.getId()) != null){
            Doctor updateDoctor = doctorMapper.toDoctor(doctorDTO);
            return doctorMapper.toDoctorDTO(doctorRepository.save(updateDoctor));
        }
        return null;
    }
/**
    * creation of the class List<DoctorDTO> getAll
    **/
    public List<DoctorDTO> getAll(){
        List<Doctor> admin= (List<Doctor>) doctorRepository.findAll();
        return doctorMapper.toAdminDTOs(admin);
    }

}
