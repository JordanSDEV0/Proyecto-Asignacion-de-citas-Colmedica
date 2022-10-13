package com.eps.Appointments.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eps.Appointments.DTOs.PatientDTO;
import com.eps.Appointments.mappers.PatientMapper;
import com.eps.Appointments.mappers.UserMapper;
import com.eps.Appointments.persistance.entities.Patient;
import com.eps.Appointments.persistance.entities.User;
import com.eps.Appointments.persistance.repositories.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    public PatientDTO getById(String id) {
        return patientMapper.toPatientDTO(patientRepository.findById(id).map(patient -> {
            return patient;
        }).orElseGet(null));
    }

    @Transactional
    public PatientDTO create(PatientDTO patientDTO)throws IllegalArgumentException{
        if(userService.getById(patientDTO.getId()) == null){
            User newUser= userMapper.toUser(userService.create(userMapper.toUserDTO(new User(patientDTO.getId(), patientDTO.getPassword()))));
            if(newUser != null){
                Patient patient = patientMapper.toPatient(patientDTO);
                patient.setUser(newUser);
                return patientMapper.toPatientDTO(patientRepository.save(patient));
            }
            return null;
        }
        return null;
    }

    @Transactional
    public PatientDTO updatePatient(PatientDTO patientDTO){
        if(getById(patientDTO.getId()) != null){
            Patient updatedPatient = patientMapper.toPatient(patientDTO);
            return patientMapper.toPatientDTO(patientRepository.save(updatedPatient));
        }
        return null;
    }

    public List<PatientDTO> getAll(){
        List<Patient> patient= (List<Patient>) patientRepository.findAll();
        return patientMapper.toPatientDTOs(patient);
    }
    
}
