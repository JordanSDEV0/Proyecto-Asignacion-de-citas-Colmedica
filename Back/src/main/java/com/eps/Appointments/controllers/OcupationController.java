package com.eps.Appointments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.DTOs.OcupationDTO;
import com.eps.Appointments.services.OcupationService;

@RestController
@RequestMapping("/ocupation")
public class OcupationController {

    @Autowired
    private OcupationService ocupationService;

    @PostMapping
    private ResponseEntity<? extends AbstractResponse> create(@RequestBody OcupationDTO ocupation){
        try {
            OcupationDTO newOcupation= ocupationService.create(ocupation);
            if(newOcupation != null){
                return new ResponseEntity<OcupationDTO>(newOcupation, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ErrorDTO>(new ErrorDTO("Admin not created"), HttpStatus.ACCEPTED);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getCause());
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    //@GetMapping("{id}")
    //public ResponseEntity<? extends Object> getAll(@PathVariable("id") String id){
      //  try{
        //    return new ResponseEntity<OcupationDTO>(ocupationService.getById(id), HttpStatus.ACCEPTED);
	//} catch(IllegalArgumentException illegalArgumentException){
	  //  System.out.println(illegalArgumentException.getCause());
	    //return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        //} catch(Exception e){
	    //System.out.println(e.getCause());
        //    return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
       // }
    //}
    @GetMapping()
    public ResponseEntity<? extends Object> getAll(){
        try{
            return new ResponseEntity<List<OcupationDTO>>(ocupationService.getAll(), HttpStatus.OK);
	} catch(IllegalArgumentException illegalArgumentException){
	    System.out.println(illegalArgumentException.getCause());
	    return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	    System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
}
