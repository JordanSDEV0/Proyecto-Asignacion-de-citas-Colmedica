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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.DateTypeService;

/**
* Create a class called DateTypeController
* @RestController Simplifies controller implementation
* @RequestMapping to map all incoming HTTP request URLs to the corresponding controller methods
* @CrossOrigin allow cross-origin requests on specific controller classes and/or controller methods
 */
@RestController
@RequestMapping("/date_type")
@CrossOrigin
public class DateTypeController {
/**
* A method called DateTypeService is used
* @Autowired. Allows Spring to resolve and inject helper beans into our bean
**/
    @Autowired
    private DateTypeService dateTypeService;
/**
*The method is used to obtain information
*@GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/
    @GetMapping
    private ResponseEntity<? extends Object> getAll(){
        try {
            return ResponseEntity.ok(dateTypeService.getAll());
        } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
}
