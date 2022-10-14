package com.eps.Appointments.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.DTOs.DoctorDTO;
import com.eps.Appointments.mappers.DoctorMapper;
import com.eps.Appointments.mappers.UserMapper;
import com.eps.Appointments.persistance.entities.Doctor;
import com.eps.Appointments.persistance.entities.User;
import com.eps.Appointments.persistance.repositories.DoctorRepository;
/**
     * Esta clase define los objetos necesariso para DoctorService
	 * @author:
     *
	 */
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
/**
     * Este metodo sirve para crear los DoctorDTO Lo cual significara que puede trasportar datos a al base
     * @return si este llega a ser null en dado caso el new user
	 */
    @Transactional
    public DoctorDTO create(DoctorDTO doctorDTO) throws IllegalArgumentException{
        if(userService.getById(doctorDTO.getId()) == null){
            User newUser= userMapper.toUser(userService.create(userMapper.toUserDTO(new User(doctorDTO.getId(), doctorDTO.getPassword()))));
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
     * Se define su get para obtener la informacion de esta misma
	 */
    public DoctorDTO getById(String id){
        return doctorMapper.toDoctorDTO(doctorRepository.findById(id).map(doctor -> {
            return doctor;
        }).orElseGet(null));
    }
/**
     * Este metodo sirve para Actualizar los DoctorDTO Lo cual significara que cambiara automaticamente el que ya estaba establecido
     * @return si este llega a ser null 
	 */
    @Transactional
    public DoctorDTO updateDoctor(DoctorDTO doctorDTO){
        if(getById(doctorDTO.getId()) != null){
            Doctor updateDoctor = doctorMapper.toDoctor(doctorDTO);
            return doctorMapper.toDoctorDTO(doctorRepository.save(updateDoctor));
        }
        return null;
    }
/**
     * Se define su get para obtener la informacion de esta misma
	 */
    public List<DoctorDTO> getAll(){
        List<Doctor> admin= (List<Doctor>) doctorRepository.findAll();
        return doctorMapper.toAdminDTOs(admin);
    }

}
