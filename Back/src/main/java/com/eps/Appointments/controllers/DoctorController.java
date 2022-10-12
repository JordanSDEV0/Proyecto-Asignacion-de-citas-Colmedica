package com.eps.Appointments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eps.Appointments.DTOs.DoctorDTO;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody DoctorDTO doctor){
        try {
            DoctorDTO newDoctor= doctorService.create(doctor);
            if(newDoctor != null){
                return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(new ErrorDTO("Admin not created"), HttpStatus.ACCEPTED);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<? extends Object> getAll(@PathVariable("id") String id){
        try{
            return new ResponseEntity<DoctorDTO>(doctorService.getById(id), HttpStatus.ACCEPTED);
	} catch(IllegalArgumentException illegalArgumentException){
	    System.out.println(illegalArgumentException.getCause());
	    return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	    System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping()
    public ResponseEntity<? extends Object> getAll(){
        try{
            return new ResponseEntity<List<DoctorDTO>>(doctorService.getAll(), HttpStatus.OK);
	} catch(IllegalArgumentException illegalArgumentException){
	    System.out.println(illegalArgumentException.getCause());
	    return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	    System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
}
