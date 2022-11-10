/**
* package where the controller is accessed
**/
package com.eps.Appointments.controllers;
/**
*  imports of util.list
**/
import java.util.List;
/**
*  imports of Springframework
**/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.DTOs.PatientDTO;
import com.eps.Appointments.persistance.repositories.PatientRepository;
import com.eps.Appointments.services.PatientService;

/**
* Create a class called patientController
* @RestController Simplifies controller implementation
* @RequestMapping to map all incoming HTTP request URLs to the corresponding controller methods
*@CrossOrigin allow cross-origin requests on specific controller classes and/or controller methods
**/
@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
/**
* a private type method called PatientService is created
*@Autowired. Allows Spring to resolve and inject helper beans into our bean
**/
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;
/**
* Create a
*@PostMapping is a specialized version of the @RequestMapping annotation
**/
    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody PatientDTO patientDTO){
        try {
            PatientDTO newPatient= patientService.create(patientDTO);
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
/**
* A private method called ResponseEntity is created and it will look for PatientDto and tell us if the patient is not created
*@PutMapping in your RESTful web services application to be able to accept HTTP Put requests that contain a JSON request body
**/
    @PutMapping("/{id}")
    private ResponseEntity<? extends Object> update(@RequestBody PatientDTO patientDTO, @PathVariable("id") String id){
        try {
            PatientDTO newPatient= patientService.updatePatient(patientDTO);
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
/**
* A method called ResponseEntity is created where we are going to obtain this information and be able to check it
* @GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/	
    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> getById(@PathVariable("id") String id){
        try{
            return new ResponseEntity<PatientDTO>(patientService.getById(id), HttpStatus.ACCEPTED);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* A method is created which will say if the information is there or not
*@GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/
    @GetMapping
    public ResponseEntity<? extends Object> getAll(){
        try{
            return new ResponseEntity<List<PatientDTO>>(patientService.getAll(), HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    /**
*method used to delete patient
*DeleteMapping to remove a resource. We use annotations to configure a Spring web application
**/
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable String id) {
	patientRepository.deleteById(id);
}

}
