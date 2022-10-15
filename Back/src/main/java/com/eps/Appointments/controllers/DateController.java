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
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.eps.Appointments.DTOs.DateDTO;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.DateService;
/**
* @RestController Simplifies controller implementation
* @RequestMapping to map all incoming HTTP request URLs to the corresponding controller methods
*@CrossOrigin allow cross-origin requests on specific controller classes and/or controller methods
**/
@RestController
@RequestMapping("/dates")
@CrossOrigin(origins = "*")

public class DateController {
/**
*Create a DateController class
* @Autowired. Allows Spring to resolve and inject helper beans into our bean
**/
    @Autowired
    private DateService dateService;
/**
* A method is created which serves to show if the data was created
* @PostMapping is a specialized version of the @RequestMapping annotation
**/
    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody DateDTO dateDTO){
        try{
            DateDTO newDate= dateService.create(dateDTO);
            if(newDate != null){
                return new ResponseEntity<>(newDate, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new ErrorDTO("Date not created"), HttpStatus.ACCEPTED);
        } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* A method is created which can obtain this information and say if the admin can or not by means of id
* @GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/
    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> getById(@PathVariable("id") Integer id){
        try{
            DateDTO date= dateService.getById(id);
            if(date != null){
                return new ResponseEntity<>(dateService.getById(id), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ErrorDTO(("Admin not found with id: " + id)), HttpStatus.ACCEPTED);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* a method is created so that you can check if the information is being obtained
* @GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/
    @GetMapping
    public ResponseEntity<? extends Object> getAll(){
        try{
            return new ResponseEntity<>(dateService.getAll(), HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* a request is made and validates if the patient is not created
* @PutMapping in your RESTful web services application to be able to accept HTTP Put requests that contain a JSON request body
**/
    @PutMapping("/{id}")
    private ResponseEntity<? extends Object> Update(@RequestBody DateDTO dateDTO, @PathVariable("id") String id){
        try {
            DateDTO updatedDate= dateService.updateDate(dateDTO);
            if(updatedDate != null){
                return new ResponseEntity<>(updatedDate, HttpStatus.CREATED);
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
    
}
