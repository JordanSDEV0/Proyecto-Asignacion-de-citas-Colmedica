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
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.DTOs.PatientDTO;
import com.eps.Appointments.services.PatientService;

/**
* Se crea una clase llamada patientController
* @RestController Simplifica la implementacion del controller
* @RequestMapping para asignar todas las URL de solicitudes HTTP entrantes a los métodos de controlador correspondientes
*@CrossOrigin permitir solicitudes de origen cruzado en clases de controlador específicas y/o métodos de controlador
**/
@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
/**
* se crea un metodo de tipo privado llamado PatientService
*@Autowired. Permite que Spring resuelva e inyecte beans colaboradores en nuestro bean
**/
    @Autowired
    private PatientService patientService;
/**
* Se crea un 
*@PostMapping es una versión especializada de la anotación @RequestMapping
**/
    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody PatientDTO patientDTO){
        try {
            PatientDTO newPatient= patientService.create(patientDTO);
            if(newPatient != null){
                return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
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
* Se crea un metodo privado llamado ResponseEntity y este buscara PatientDto Y nos dira si el paciente no esta creado
*@PutMapping en su aplicación de servicios web RESTful para poder aceptar solicitudes HTTP Put que contengan un cuerpo de solicitud con JSON
**/
    @PutMapping("/{id}")
    private ResponseEntity<? extends Object> update(@RequestBody PatientDTO patientDTO, @PathVariable("id") String id){
        try {
            PatientDTO newPatient= patientService.updatePatient(patientDTO);
            if(newPatient != null){
                return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
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
* Se crea un metodo llamado ResponseEntity en donde vamos a obtener esta informacion y poder comprobarla 
* @GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/	
    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> getById(@PathVariable("id") String id){
        try{
            return new ResponseEntity<PatientDTO>(patientService.getById(id), HttpStatus.ACCEPTED);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* Se crea un metedo el cual dira si la informacion esta o no 
*@GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/
    @GetMapping
    public ResponseEntity<? extends Object> getAll(){
        try{
            return new ResponseEntity<List<PatientDTO>>(patientService.getAll(), HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
