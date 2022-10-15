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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.HeadquarterService;
/**
* Create a class called headquarterController
*@RestController Simplifies controller implementation
*@RequestMapping to map all incoming HTTP request URLs to the corresponding controller methods
*@CrossOrigin allow cross-origin requests on specific controller classes and/or controller methods
**/
@RestController
@RequestMapping("/headquarter")
@CrossOrigin
public class HeadquarterController {
/**
* A method called headquarterservice is created
* @Autowired. Allows Spring to resolve and inject helper beans into our bean
**/
    @Autowired
    private HeadquarterService headquarterService;
/**
* A method is created to obtain the name
* @GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/
    @GetMapping("/{name}")
    private ResponseEntity<? extends Object> getByName(@PathVariable(name = "name") String name){
        try{
            return new ResponseEntity<>(headquarterService.getByName(name), HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* An object is obtained to know if it is being fulfilled
*@GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/
    @GetMapping
    private ResponseEntity<? extends Object> getAll(){
        try {
            return ResponseEntity.ok(headquarterService.getAll());
        } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
}
