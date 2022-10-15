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
import com.eps.Appointments.DTOs.UserDTO;
import com.eps.Appointments.services.UserService;
/**
* UserController class
* @Data allows the use of the program
* @RestController Simplifies controller implementation
* @CrossOrigin allow cross-origin requests on specific controller classes and/or controller methods
* @CrossOrigin map web requests to Spring Controller methods.
**/
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
/**
* Create a UserController class
*@Autowired. Allows Spring to resolve and inject helper beans into our bean
*@RequestMapping to map all incoming HTTP request URLs to the corresponding controller methods
* We place UserService private type
**/
    @Autowired
    private UserService userService;
/**
* A private type method is created that will use the UserDTO
*@PostMapping is a specialized version of the @RequestMapping annotation
**/
    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody UserDTO userDTO){
        try {
            UserDTO newUser= userService.create(userDTO);
            if(newUser != null){
                return new ResponseEntity<>(newUser, HttpStatus.CREATED);
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
* A private type method is created that UserDto will use where it will tell us if the patient is created or not
*@PutMapping in your RESTful web services application to be able to accept HTTP Put requests that contain a JSON request body
**/

    @PutMapping("/{id}")
    private ResponseEntity<? extends Object> update(@RequestBody UserDTO userDTO, @PathVariable("id") String id){
        try {
            UserDTO newUser= userService.updateUser(userDTO);
            if(newUser != null){
                return new ResponseEntity<>(newUser, HttpStatus.CREATED);
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
* A public type method is created which will obtain the ById
* @GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/
    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> getById(@PathVariable("id") String id){
        try{
            return new ResponseEntity<UserDTO>(userService.getById(id), HttpStatus.ACCEPTED);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* A public dipo method is created whose purpose is to show if the HTTP requests are running correctly or, on the contrary, it will vote an error
* @GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
**/
    @GetMapping
    public ResponseEntity<? extends Object> getAll(){
        try{
            return new ResponseEntity<List<UserDTO>>(userService.getAll(), HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
