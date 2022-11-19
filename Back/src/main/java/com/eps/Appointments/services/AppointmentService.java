/**
* Package with which the services of the appointments access
**/
package com.eps.Appointments.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
/**
* Imports of java util
*/
import java.util.List;
/**
* Imports of springframework
*/
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
    private final MedicalDateRepository medicalDateRepository;

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

    /**
     * creation of the class List<AppointmentDTO> getAll
     **/
    public List<AppointmentDTO> getAll() {
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        List<MedicalDate> medicalDates = medicalDateService.getAll();
        return appointmentMapper.toAppointmentDTOs(appointments, medicalDates);
    }

    /**
     * class creation AppointmentDTO updateAppointment with attributes
     * appointmentDTO
     *
     * @Transactional annotation is the metadata that specifies the semantics of the
     *                transactions on a method
     **/
    @Transactional
    public AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO) {
        if (getById(appointmentDTO.getId()) != null) {
            Appointment updatedAppointment = appointmentMapper.toAppointment(appointmentDTO);
            MedicalDate medicalDate = appointmentMapper.toMedicalDate(appointmentDTO);
            return appointmentMapper.toAppointmentDTO(appointmentRepository.save(updatedAppointment),
                    medicalDateRepository.save(medicalDate));
        }
        return null;
    }

    /**
     * creation of the class AppointmentDTO getById with id attributes
     **/
    public AppointmentDTO getById(int id) {
        return appointmentRepository.findById(id).map(appointment -> {
            MedicalDate medicalDate = medicalDateService.getById(appointment.getDate().getId());
            return appointmentMapper.toAppointmentDTO(appointment, medicalDate);
        }).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * creation of the class AppointmentDTO getAllByDoctor with id attributes
     **/
    public List<AppointmentDTO> getAllByDoctor(String id) {
        List<Appointment> appointments2 = new ArrayList<>();
        List<MedicalDate> medicalDates = new ArrayList<>();
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        for (Appointment appointment : appointments) {
            if (id.equals(appointment.getDoctor().getId())) {
                appointments2.add(appointment);
                medicalDates.add(medicalDateService.getById(appointment.getDate().getId()));
            }
        }
        return appointmentMapper.toAppointmentDTOs(appointments2, medicalDates);
    }

    /**
     * creation of the class AppointmentDTO getAllByPatient with id attributes
     **/
    public List<AppointmentDTO> getAllByPatient(String id) {
        List<Appointment> appointments2 = new ArrayList<>();
        List<MedicalDate> medicalDates = new ArrayList<>();
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        for (Appointment appointment : appointments) {
            if (id.equals(appointment.getPatient().getId())) {
                appointments2.add(appointment);
                medicalDates.add(medicalDateService.getById(appointment.getDate().getId()));
            }
        }
        return appointmentMapper.toAppointmentDTOs(appointments2, medicalDates);
    }

    /**
     * method that deletw AppointmentDTO
     *
     * @Transactional annotation is the metadata that specifies the semantics of
     *                the
     *                transactions on a method
     **/
    @Transactional
    public AppointmentDTO delete(int id) {
        return appointmentRepository.findById(id).map(appointment -> {
            MedicalDate medicalDate = medicalDateService.getById(appointment.getDate().getId());
            appointmentRepository.delete(appointment);
            medicalDateRepository.delete(medicalDate);
            return appointmentMapper.toAppointmentDTO(appointment, medicalDate);
        }).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * creation of the class list AppointmentDTO getAllACtive with id attributes
     **/
    public List<AppointmentDTO> getAllActive() {
        List<MedicalDate> medicalDates = medicalDateRepository
                .findAllByInitialTimeAfter(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        return appointmentMapper.toAppointmentDTOs(
                appointmentRepository
                        .findAllByDateIn(medicalDates),
                medicalDates);
    }

}
