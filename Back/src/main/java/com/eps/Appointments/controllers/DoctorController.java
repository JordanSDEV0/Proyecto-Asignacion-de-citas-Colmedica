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

import com.eps.Appointments.DTOs.DoctorDTO;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.persistance.repositories.DoctorRepository;
import com.eps.Appointments.services.DoctorService;

/**
 * @RestController Simplifies controller implementation
 * @RequestMapping to map all incoming HTTP request URLs to the corresponding
 *                 controller methods
 * @CrossOrigin allow cross-origin requests on specific controller classes
 *              and/or controller methods
 **/
@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class DoctorController {
    /**
     * A method is created which will be called Doctorservice
     * @Autowired. Allows Spring to resolve and inject helper beans into our bean
     **/
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorRepository doctorRepository;

    /**
     * a method is created which says if the doctor was created
     *
     * @PostMapping is a specialized version of the @RequestMapping annotation
     **/
    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody DoctorDTO doctor) {
        try {
            DoctorDTO newDoctor = doctorService.create(doctor);
            if (newDoctor != null) {
                return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(new ErrorDTO("Doctor not created"), HttpStatus.ACCEPTED);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * A public type method is made which will look for the id variable
     *
     * @GetMapping is a compound annotation that acts as a shortcut
     *             for @RequestMapping
     **/
    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> getById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<DoctorDTO>(doctorService.getById(id), HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()),
                    HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * A method is created which will be responsible for obtaining the information
     *
     * @GetMapping is a compound annotation that acts as a shortcut
     *             for @RequestMapping
     **/
    @GetMapping
    public ResponseEntity<? extends Object> getAll() {
        try {
            return new ResponseEntity<List<DoctorDTO>>(doctorService.getAll(), HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()),
                    HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * A method is created which will validate if the patient is created
     *
     * @PutMapping in your RESTful web services application to be able to accept
     *             HTTP Put requests that contain a JSON request body
     **/
    @PutMapping("/{id}")
    private ResponseEntity<? extends Object> Update(@RequestBody DoctorDTO doctorDTO, @PathVariable("id") String id) {
        try {
            DoctorDTO updatedDoctor = doctorService.updateDoctor(doctorDTO);
            if (updatedDoctor != null) {
                return new ResponseEntity<>(updatedDoctor, HttpStatus.CREATED);
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
     * method that delete Doctor
     *
     * @DeleteMapping to remove a resource. We use annotations to configure a Spring
     *                web application
     **/

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable String id) {
        doctorRepository.deleteById(id);
    }
}
