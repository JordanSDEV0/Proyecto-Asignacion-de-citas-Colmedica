package com.eps.Appointments.services;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.DTOs.DoctorDTO;
import com.eps.Appointments.mappers.DoctorMapper;
import com.eps.Appointments.persistance.entities.Doctor;
import com.eps.Appointments.persistance.entities.User;
import com.eps.Appointments.persistance.repositories.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private UserService userService;

    @Transactional
    public DoctorDTO create(DoctorDTO doctorDTO) throws IllegalArgumentException{
        if(userService.getUser(doctorDTO.getId()) == null){
            User newUser= userService.create(new User(doctorDTO.getId(), doctorDTO.getPassword()));
            if(newUser != null){
                Doctor newDoctor= doctorMapper.toDoctor(doctorDTO);
                newDoctor.setUser(newUser);
                System.out.println(newDoctor);
                return doctorMapper.toDoctorDTO(doctorRepository.save(newDoctor));
            }
            return null;
        }else{
            return null;
        }
    }

    public Object getById(String doctorId) {
        return null;
    }

}
