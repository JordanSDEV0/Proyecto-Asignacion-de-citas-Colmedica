package com.eps.Appointments.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eps.Appointments.DTOs.AppointmentDTO;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.AppointmentService;
import com.eps.Appointments.services.DoctorService;
import com.eps.Appointments.services.PatientService;
import com.eps.Appointments.services.DateService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DateService dateService;

    @PostMapping
    private ResponseEntity<? extends AbstractResponse> create(@RequestBody AppointmentDTO appointmentDTO){
        try {
            if(doctorService.getById(appointmentDTO.getDoctorId()) != null && patientService.getById(appointmentDTO.getPatientId()) && dateService.getById(appointmentDTO.getDateId())){
                AppointmentDTO newAppointment= appointmentService.create(appointmentDTO);
                if(newAppointment != null){
                    return new ResponseEntity<AppointmentDTO>(newAppointment, HttpStatus.CREATED);
                }
            }
            return new ResponseEntity<ErrorDTO>(new ErrorDTO("Appointment not created"), HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
}
