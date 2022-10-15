/**
* paquete por donde se accede al controlador
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

import com.eps.Appointments.DTOs.DoctorDTO;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.DoctorService;
/**
* @RestController Simplifica la implementacion del controller
* @RequestMapping para asignar todas las URL de solicitudes HTTP entrantes a los métodos de controlador correspondientes
*@CrossOrigin permitir solicitudes de origen cruzado en clases de controlador específicas y/o métodos de controlador
**/
@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class DoctorController {
/**
*Se crea un metodo el cual se llamara Doctorservice
*@Autowired. Permite que Spring resuelva e inyecte beans colaboradores en nuestro bean 
**/
    @Autowired
    private DoctorService doctorService;
/**
*
*@PostMapping es una versión especializada de la anotación @RequestMapping 
**/
    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody DoctorDTO doctor){
        try {
            DoctorDTO newDoctor= doctorService.create(doctor);
            if(newDoctor != null){
                return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(new ErrorDTO("Doctor not created"), HttpStatus.ACCEPTED);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* Se hace un metodo tipo publico el cual buscara la variable id
*@GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/
    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> getById(@PathVariable("id") String id){
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
/**
* Se crea un metodo el cual se encargara de obtener la informacion
*@GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping 
**/
    @GetMapping
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
/** 
* Se crea un metodo el cual validara si el paciente esta creado
* @PutMapping en su aplicación de servicios web RESTful para poder aceptar solicitudes HTTP Put que contengan un cuerpo de solicitud con JSON
**/
    @PutMapping("/{id}")
    private ResponseEntity<? extends Object> Update(@RequestBody DoctorDTO doctorDTO, @PathVariable("id") String id){
        try {
            DoctorDTO updatedDoctor= doctorService.updateDoctor(doctorDTO);
            if(updatedDoctor != null){
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
    
}
