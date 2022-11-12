/**
* Package with which the services of the appointments access
**/
package com.eps.Appointments.services;
/**
* Imports of java util
*/
import java.util.List;
/**
* Imports of springframework
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.PatientDTO;
import com.eps.Appointments.mappers.PatientMapper;
import com.eps.Appointments.mappers.UserMapper;
import com.eps.Appointments.persistance.entities.Patient;
import com.eps.Appointments.persistance.entities.User;
import com.eps.Appointments.persistance.repositories.PatientRepository;
/**
* Creation of the public class PatientService
* @Service It is used to mark the class as a service provider 
**/
@Service
public class PatientService {
    /**
    * annotation that allows to inject some dependencies with others inside Spring
    **/
    @Autowired
    /**
    * Private attribute of type PatientRepository of name patientRepository
    **/
    private PatientRepository patientRepository;
    @Autowired
    /**
    * Private attribute of type PatientMapper of name patientMapper
    **/
    private PatientMapper patientMapper;
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
    * creation of the class PatientDTO getById with id attributes
    **/
    public PatientDTO getById(String id) {
        return patientMapper.toPatientDTO(patientRepository.findById(id).map(patient -> {
            return patient;
        }).orElseGet(null));
    }
    /**
    * class creation PatientDTO with attributes patientDTO and exception IllegalArgumentException
    * @Transactional annotation is the metadata that specifies the semantics of the transactions on a method
    **/
    @Transactional
    public PatientDTO create(PatientDTO patientDTO)throws IllegalArgumentException{
        if(userService.getById(patientDTO.getId()) == null){
            User newUser= userMapper.toUser(userService.create(userMapper.toUserDTO(new User(patientDTO.getId(), patientDTO.getPassword(), patientDTO.getRol()))));
            if(newUser != null){
                Patient patient = patientMapper.toPatient(patientDTO);
                patient.setUser(newUser);
                return patientMapper.toPatientDTO(patientRepository.save(patient));
            }
            return null;
        }
        return null;
    }
    /**
    * class creation PatientDTO with updatePatient and patientDTO attributes  
    * @Transactional annotation is the metadata that specifies the semantics of the transactions on a method
    **/
    @Transactional
    public PatientDTO updatePatient(PatientDTO patientDTO){
        if(getById(patientDTO.getId()) != null){
            Patient updatedPatient = patientMapper.toPatient(patientDTO);
            return patientMapper.toPatientDTO(patientRepository.save(updatedPatient));
        }
        return null;
    }
    /**
    * creation of the class List<PatientDTO> getAll
    **/
    public List<PatientDTO> getAll(){
        List<Patient> patient= (List<Patient>) patientRepository.findAll();
        return patientMapper.toPatientDTOs(patient);
    }
    
}
