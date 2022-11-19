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
import com.eps.Appointments.DTOs.OccupationDTO;
import com.eps.Appointments.services.OcupationService;

/**
 * A class called occupationController is created which will be in charge of
 * running the assigned methods
 * 
 * @RestController Simplifies controller implementation
 * @RequestMapping to map all incoming HTTP request URLs to the corresponding
 *                 controller methods
 **/
@RestController
@RequestMapping("/ocupation")
public class OcupationController {
    /**
     * A method called occupationservice is created
     * @Autowired. Allows Spring to resolve and inject helper beans into our bean
     **/
    @Autowired
    private OcupationService ocupationService;

    /**
     * A method is created which will say if the admin was created or not
     * 
     * @PostMapping is a specialized version of the @RequestMapping annotation
     **/
    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody OccupationDTO ocupation) {
        try {
            OccupationDTO newOcupation = ocupationService.create(ocupation);
            if (newOcupation != null) {
                return new ResponseEntity<OccupationDTO>(newOcupation, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<ErrorDTO>(new ErrorDTO("Admin not created"), HttpStatus.ACCEPTED);
            }
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
     * a method is created which will be responsible for obtaining the information
     * 
     * @GetMapping is a compound annotation that acts as a shortcut
     *             for @RequestMapping
     **/
    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> getAll(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<OccupationDTO>(ocupationService.getById(id), HttpStatus.ACCEPTED);
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
     * A method is created which checks if the obtaining of objects is being done
     * 
     * @GetMapping is a compound annotation that acts as a shortcut
     *             for @RequestMapping
     **/
    @GetMapping
    public ResponseEntity<? extends Object> getAll() {
        try {
            return new ResponseEntity<List<OccupationDTO>>(ocupationService.getAll(), HttpStatus.OK);
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
     * A method is created which makes HTTP requests
     * 
     * @PutMapping in your RESTful web services application to be able to accept
     *             HTTP Put requests that contain a JSON request body
     **/
    @PutMapping("/{id}")
    private ResponseEntity<? extends Object> Update(@RequestBody OccupationDTO ocupationDTO,
            @PathVariable("id") String id) {
        try {
            OccupationDTO updateOcupation = ocupationService.updateOcupation(ocupationDTO);
            if (updateOcupation != null) {
                return new ResponseEntity<>(updateOcupation, HttpStatus.CREATED);
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
