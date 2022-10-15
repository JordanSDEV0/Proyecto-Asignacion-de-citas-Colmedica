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
import com.eps.Appointments.DTOs.OcupationDTO;
import com.eps.Appointments.services.OcupationService;
/**
* Se crea una clase llamada ocupationController la cual se encargara de correr los metodos asignados
* @RestController Simplifica la implementacion del controller
* @RequestMapping para asignar todas las URL de solicitudes HTTP entrantes a los métodos de controlador correspondientes
**/
@RestController
@RequestMapping("/ocupation")
public class OcupationController {
/**
* Se crea un metodo llamado ocupationservice
* @Autowired. Permite que Spring resuelva e inyecte beans colaboradores en nuestro bean
**/
    @Autowired
    private OcupationService ocupationService;
/**
* Se crea un metodo el cual dira si el admin fue creado o no
*@PostMapping es una versión especializada de la anotación @RequestMapping
**/
    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody OcupationDTO ocupation){
        try {
            OcupationDTO newOcupation= ocupationService.create(ocupation);
            if(newOcupation != null){
                return new ResponseEntity<OcupationDTO>(newOcupation, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ErrorDTO>(new ErrorDTO("Admin not created"), HttpStatus.ACCEPTED);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/** 
* se crea un metodo el cual se encargara de obtener la informacion
*@GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/
    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> getAll(@PathVariable("id") int id){
       try{
            return new ResponseEntity<OcupationDTO>(ocupationService.getById(id), HttpStatus.ACCEPTED);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* Se crea un metdo el cual comprueba si la obtecion de objetos se esta haciendo
* @GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/
    @GetMapping
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
/**
* Se crea un metodo el cual hace solicitudes HTTP
* @PutMapping en su aplicación de servicios web RESTful para poder aceptar solicitudes HTTP Put que contengan un cuerpo de solicitud con JSON
**/
    @PutMapping("/{id}")
    private ResponseEntity<? extends Object> Update(@RequestBody OcupationDTO ocupationDTO, @PathVariable("id") String id){
        try {
            OcupationDTO updateOcupation= ocupationService.updateOcupation(ocupationDTO);
            if(updateOcupation != null){
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
