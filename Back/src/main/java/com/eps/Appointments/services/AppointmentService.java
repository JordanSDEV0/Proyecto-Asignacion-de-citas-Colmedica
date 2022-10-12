package com.eps.Appointments.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eps.Appointments.DTOs.AppointmentDTO;
import com.eps.Appointments.mappers.AppointmentMapper;
import com.eps.Appointments.persistance.entities.Appointment;
import com.eps.Appointments.persistance.repositories.AppointmentRepository;

@Service
public class AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private AppointmentMapper appointmentMapper;

    @Transactional
    public AppointmentDTO create(AppointmentDTO appointmentDTO) throws IllegalArgumentException{
        return appointmentMapper.toAppointmentDTO(appointmentRepository.save(appointmentMapper.toAppointment(appointmentDTO)));
    }
    
    @Transactional
    public List<AppointmentDTO> getAll(){
        List<Appointment> appointments= (List<Appointment>) appointmentRepository.findAll();
        return appointmentMapper.toAppointmentDTOs(appointments);
    }
}
     //@Transactional
    //public AppointmentDTO getById(Integer id){
     //   return AppointmentMapper.toAppointmentDTO(appointmentMapper.findById(id)).map(ocupation -> {
      //     return ocupation;
      // }).orElseGet(null);
    //}
    

