package com.eps.Appointments.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    private ResponseEntity<? extends Object> create(@RequestBody AppointmentDTO appointmentDTO){
        try {
            if((doctorService.getById(appointmentDTO.getDoctorId()) != null) && (patientService.getById(appointmentDTO.getPatientId()) != null) && (dateService.getById(appointmentDTO.getDateId()) != null)){
                System.out.println(appointmentDTO);
                AppointmentDTO newAppointment= appointmentService.create(appointmentDTO);
               
                if(newAppointment != null){
                    
                    return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
                }
                return new ResponseEntity<ErrorDTO>(new ErrorDTO("El agendamiento no fue creado"), HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<ErrorDTO>(new ErrorDTO("Appointment not created, no se encontro el doctor o el paciente o la cita"), HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    private ResponseEntity<? extends Object> Update(@RequestBody AppointmentDTO appointmentDTO, @PathVariable("id") int id){
        try {
            AppointmentDTO newPatient= patientService.updatePatient(appointmentDTO);
            if(newPatient != null){
                return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new ErrorDTO("Patient not created"), HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping()
    public ResponseEntity<? extends Object> getAll(){
        try{
            return new ResponseEntity<>(appointmentService.getAll(), HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

   // @GetMapping("{id}")
   // public ResponseEntity<? extends Object> getAll(@PathVariable("id") Integer id){
     //   try{
      //      return new ResponseEntity<AppointmentDTO>(appointmentService.getById(id), HttpStatus.ACCEPTED);
	//} catch(IllegalArgumentException illegalArgumentException){
	  //  System.out.println(illegalArgumentException.getCause());
	   // return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        //} catch(Exception e){
	    //System.out.println(e.getCause());
         //   return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        //}
    //}
   
    
}
