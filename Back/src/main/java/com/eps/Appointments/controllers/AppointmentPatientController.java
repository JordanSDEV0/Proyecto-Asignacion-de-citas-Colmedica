/**
* package where the controller is accessed
**/
package com.eps.Appointments.controllers;
/**
*  imports of Springframework
**/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.AppointmentService;
/**
* @RestController Simplifies controller implementation
* @RequestMapping to map all incoming HTTP request URLs to the corresponding controller methods
**/
@RestController
@RequestMapping("/appointmentsPatient")
public class AppointmentPatientController {
/**
* the class is created
**/
   @Autowired
    private AppointmentService appointmentService;
/**
* We define a private type attribute called appointmentservice
* @Autowired. Allows Spring to resolve and inject helper beans into our bean
**/
  
/**
* A method is created which works to obtain information
* @GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/
    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> getById(@PathVariable("id") String id){
        {
        try{
            return new ResponseEntity<>(appointmentService.getAllPatient(id), HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
}