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
        System.out.println(appointmentMapper.toAppointment(appointmentDTO));
        return appointmentMapper.toAppointmentDTO(appointmentRepository.save(appointmentMapper.toAppointment(appointmentDTO)));
    }
    
    public List<AppointmentDTO> getAll(){
        List<Appointment> appointments= (List<Appointment>) appointmentRepository.findAll();
        return appointmentMapper.toAppointmentDTOs(appointments);
    }

    @Transactional
    public AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO){
        if(getById(appointmentDTO.getId()) != null){
            Appointment updatedAppointment = appointmentMapper.toAppointment(appointmentDTO);
            return appointmentMapper.toAppointmentDTO(appointmentRepository.save(updatedAppointment));
        }
        return null;
    }

    public AppointmentDTO getById(int id){
        return appointmentMapper.toAppointmentDTO(appointmentRepository.findById(id).map(ocupation -> {
            return ocupation;
        }).orElseGet(null));
    }

}
