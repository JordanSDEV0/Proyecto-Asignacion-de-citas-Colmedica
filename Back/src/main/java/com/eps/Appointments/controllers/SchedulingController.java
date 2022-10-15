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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.SchedulingDTO;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.SchedulingService;
/**
* @RestController Simplifies controller implementation
* @RequestMapping to map all incoming HTTP request URLs to the corresponding controller methods
* @CrossOrigin allow cross-origin requests on specific controller classes and/or controller methods
**/
@RestController
@RequestMapping("/scheduling")
@CrossOrigin
public class SchedulingController {

/**
* Create a public class called shedulingController
**/	
    @Autowired
    private SchedulingService schedulingService;
/**
* A method called ResponseEntity is created where it will give the order to show us if it exits if the appointment was not created
* @PostMapping is a specialized version of the @RequestMapping annotation
**/

	
/**
* A method called ResponseEntity is created where it will give the order to show us if it exits if the appointment was not created
* @PostMapping is a specialized version of the @RequestMapping annotation
**/
    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody SchedulingDTO scheduling){
        try {
          SchedulingDTO newScheduling= schedulingService.create(scheduling);
          if(scheduling != null){
            return new ResponseEntity<SchedulingDTO>(newScheduling, HttpStatus.CREATED);
          }
          return new ResponseEntity<ErrorDTO>(new ErrorDTO("Cita no creada"), HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* A public type method is created which will obtain this information
*@GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/
    @GetMapping
    public ResponseEntity<? extends Object> getAll(){
        try{
            return new ResponseEntity<>(null, HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* a public type method is created which will have the function of obtaining the information
* @GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/
    @GetMapping("/{id}")
        public ResponseEntity<? extends Object> getById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(null, HttpStatus.OK);
	} catch(IllegalArgumentException illegalArgumentException){
	    System.out.println(illegalArgumentException.getCause());
	    return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
    } catch(Exception e){
	    System.out.println(e.getCause());
        return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    }
}
