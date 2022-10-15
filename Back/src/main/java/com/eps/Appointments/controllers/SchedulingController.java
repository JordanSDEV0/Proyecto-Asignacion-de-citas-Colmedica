/**
* paquete por donde se accede al controlador
**/
package com.eps.Appointments.controllers;


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

import com.eps.Appointments.DTOs.SchedulingDTO;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.SchedulingService;

@RestController
@RequestMapping("/scheduling")
@CrossOrigin
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

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
