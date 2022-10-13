package com.eps.Appointments.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.DateTypeService;

/**
 * DateTypeController
 */
@RestController
@RequestMapping("/date_type")
@CrossOrigin
public class DateTypeController {

    @Autowired
    private DateTypeService dateTypeService;

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
