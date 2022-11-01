/**
* Package with which the services of the appointments access
**/
package com.eps.Appointments.services;
import java.util.ArrayList;
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
import com.eps.Appointments.DTOs.AppointmentDTO;
import com.eps.Appointments.mappers.AppointmentMapper;
import com.eps.Appointments.persistance.entities.Appointment;
import com.eps.Appointments.persistance.repositories.AppointmentRepository;
/**
* Creation of the public class AppointmentService
* @Service It is used to mark the class as a service provider 
**/
@Service
public class AppointmentService{
 /**
    * annotation that allows to inject some dependencies with others inside Spring
    **/
    @Autowired 
    /**
    * Private attribute of type AppointmentRepository of name appointmentRepository
    **/
    private AppointmentRepository appointmentRepository;
    @Autowired
    /**
    * Private attribute of type AppointmentMapper of name appointmentMapper
    **/
    private AppointmentMapper appointmentMapper;
    /**
    * class creation AppointmentDTO with attributes appointmentDTO and exception IllegalArgumentException
    * @Transactional annotation is the metadata that specifies the semantics of the transactions on a method
    **/
    @Transactional
    public AppointmentDTO create(AppointmentDTO appointmentDTO) throws IllegalArgumentException{
        System.out.println(appointmentMapper.toAppointment(appointmentDTO));
        return appointmentMapper.toAppointmentDTO(appointmentRepository.save(appointmentMapper.toAppointment(appointmentDTO)));
    }
    /**
    * creation of the class List<AppointmentDTO> getAll
    **/
    public List<AppointmentDTO> getAll(){
        List<Appointment> appointments= (List<Appointment>) appointmentRepository.findAll();
        return appointmentMapper.toAppointmentDTOs(appointments);
    }
    /**
    * class creation AppointmentDTO updateAppointment with attributes appointmentDTO 
    * @Transactional annotation is the metadata that specifies the semantics of the transactions on a method
    **/
    @Transactional
    public AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO){
        if(getById(appointmentDTO.getId()) != null){
            Appointment updatedAppointment = appointmentMapper.toAppointment(appointmentDTO);
            return appointmentMapper.toAppointmentDTO(appointmentRepository.save(updatedAppointment));
        }
        return null;
    }
    /**
    * creation of the class AppointmentDTO getById with id attributes 
    **/
    public AppointmentDTO getById(int id){
        return appointmentMapper.toAppointmentDTO(appointmentRepository.findById(id).map(ocupation -> {
            return ocupation;
        }).orElseGet(null));

    }
   
    public List<AppointmentDTO> getAllDoctor(String id){
        List<Appointment> appointments2=new ArrayList<>();
        List<Appointment> appointments= (List<Appointment>) appointmentRepository.findAll();
        for (Appointment appointment: appointments) {
            if(id.equals(appointment.getDoctor().getId())){
                appointments2.add(appointment);
            }
        }
        return appointmentMapper.toAppointmentDTOs(appointments2);
    }
    public List<AppointmentDTO> getAllPatient(String id){
        List<Appointment> appointments2=new ArrayList<>();
        List<Appointment> appointments= (List<Appointment>) appointmentRepository.findAll();
        for (Appointment appointment: appointments) {
            if(id.equals(appointment.getPatient().getId())){
                appointments2.add(appointment);
            }
        }
        return appointmentMapper.toAppointmentDTOs(appointments2);
    }
}
