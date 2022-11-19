/**
* Package with which the services of the appointments access
**/
package com.eps.Appointments.services;

import java.time.LocalDateTime;
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
import com.eps.Appointments.persistance.entities.MedicalDate;
import com.eps.Appointments.persistance.repositories.AppointmentRepository;
import com.eps.Appointments.persistance.repositories.MedicalDateRepository;
import com.eps.Appointments.services.Domains.MedicalDateService;

import lombok.RequiredArgsConstructor;

/**
 * Creation of the public class AppointmentService
 *
 * @Service It is used to mark the class as a service provider
 **/
@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final MedicalDateService medicalDateService;

    /**
     * class creation AppointmentDTO with attributes appointmentDTO and exception
     * IllegalArgumentException
     *
     * @Transactional annotation is the metadata that specifies the semantics of the
     *                transactions on a method
     **/
    @Transactional
    public AppointmentDTO create(AppointmentDTO appointmentDTO) throws IllegalArgumentException {
        // TODO
        Appointment appointment = appointmentMapper.toAppointment(appointmentDTO);
        MedicalDate medicalDate = medicalDateService.create(appointmentMapper.toMedicalDate(appointmentDTO));
        appointment.setDate(medicalDate);
        return appointmentMapper.toAppointmentDTO(appointmentRepository.save(appointment), medicalDate);
    }

    /// **
    // * creation of the class List<AppointmentDTO> getAll
    // **/
    // public List<AppointmentDTO> getAll() {
    // List<Appointment> appointments = (List<Appointment>)
    /// appointmentRepository.findAll();
    // return appointmentMapper.toAppointmentDTOs(appointments);
    // }

    /// **
    // * class creation AppointmentDTO updateAppointment with attributes
    // * appointmentDTO
    // *
    // * @Transactional annotation is the metadata that specifies the semantics of
    /// the
    // * transactions on a method
    // **/
    // @Transactional
    // public AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO) {
    // if (getById(appointmentDTO.getId()) != null) {
    // Appointment updatedAppointment =
    /// appointmentMapper.toAppointment(appointmentDTO);
    // return
    /// appointmentMapper.toAppointmentDTO(appointmentRepository.save(updatedAppointment));
    // }
    // return null;
    // }

    /// **
    // * creation of the class AppointmentDTO getById with id attributes
    // **/
    // public AppointmentDTO getById(int id) {
    // return
    /// appointmentMapper.toAppointmentDTO(appointmentRepository.findById(id).map(ocupation
    /// -> {
    // return ocupation;
    // }).orElseGet(null));

    // }

    /// **
    // * creation of the class AppointmentDTO getAllByDoctor with id attributes
    // **/
    // public List<AppointmentDTO> getAllByDoctor(String id) {
    // List<Appointment> appointments2 = new ArrayList<>();
    // List<Appointment> appointments = (List<Appointment>)
    /// appointmentRepository.findAll();
    // for (Appointment appointment : appointments) {
    // if (id.equals(appointment.getDoctor().getId())) {
    // appointments2.add(appointment);
    // }
    // }
    // return appointmentMapper.toAppointmentDTOs(appointments2);
    // }

    /// **
    // * creation of the class AppointmentDTO getAllByPatient with id attributes
    // **/
    // public List<AppointmentDTO> getAllByPatient(String id) {
    // List<Appointment> appointments2 = new ArrayList<>();
    // List<Appointment> appointments = (List<Appointment>)
    /// appointmentRepository.findAll();
    // for (Appointment appointment : appointments) {
    // if (id.equals(appointment.getPatient().getId())) {
    // appointments2.add(appointment);
    // }
    // }
    // return appointmentMapper.toAppointmentDTOs(appointments2);
    // }

    /// **
    // * method that deletw AppointmentDTO
    // *
    // * @Transactional annotation is the metadata that specifies the semantics of
    /// the
    // * transactions on a method
    // **/
    // @Transactional
    // public AppointmentDTO delete(int id) {
    // return appointmentRepository.findById(id).map(appointment -> {
    // appointmentRepository.delete(appointment);
    // return appointmentMapper.toAppointmentDTO(appointment);
    // }).orElseThrow(IllegalArgumentException::new);
    // }

    /// **
    // * creation of the class list AppointmentDTO getAllACtive with id attributes
    // **/
    // public List<AppointmentDTO> getAllActive() {
    // System.out.println(LocalDateTime.now());
    // System.out.println(dateRepository.findAllByInitialTimeAfter(LocalDateTime.now()));
    // return appointmentMapper.toAppointmentDTOs(
    // appointmentRepository.findAllByDateIn(dateRepository.findAllByInitialTimeAfter(LocalDateTime.now())));
    // }

}
