/**
* paquete por donde se accede al controlador
**/

package com.eps.Appointments.controllers;
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
import com.eps.Appointments.DTOs.DateDTO;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.DateService;
/**
* @RestController Simplifica la implementacion del controller
* @RequestMapping para asignar todas las URL de solicitudes HTTP entrantes a los métodos de controlador correspondientes
*@CrossOrigin permitir solicitudes de origen cruzado en clases de controlador específicas y/o métodos de controlador
**/
@RestController
@RequestMapping("/dates")
@CrossOrigin(origins = "*")

public class DateController {
/**
*Se crea una clase DateController
* @Autowired. Permite que Spring resuelva e inyecte beans colaboradores en nuestro bean
**/
    @Autowired
    private DateService dateService;
/**
* Se crea un metodo el cual sirve para mostrar si el dato fue creado
* @PostMapping es una versión especializada de la anotación @RequestMapping
**/
    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody DateDTO dateDTO){
        try{
            DateDTO newDate= dateService.create(dateDTO);
            if(newDate != null){
                return new ResponseEntity<>(newDate, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new ErrorDTO("Date not created"), HttpStatus.ACCEPTED);
        } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* Se crea un metodo el  cual pueda obtener esta informacion y diga si el admin puede o no por medio de id
* @GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/
    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> getById(@PathVariable("id") Integer id){
        try{
            DateDTO date= dateService.getById(id);
            if(date != null){
                return new ResponseEntity<>(dateService.getById(id), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ErrorDTO(("Admin not found with id: " + id)), HttpStatus.ACCEPTED);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* se crea un metodo para que pueda comprobar si la informacion se esta obteniendo
* @GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/
    @GetMapping
    public ResponseEntity<? extends Object> getAll(){
        try{
            return new ResponseEntity<>(dateService.getAll(), HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* se hace un solicitud y valida si el paciente no esta creado
* @PutMapping en su aplicación de servicios web RESTful para poder aceptar solicitudes HTTP Put que contengan un cuerpo de solicitud con JSON
**/
    @PutMapping("/{id}")
    private ResponseEntity<? extends Object> Update(@RequestBody DateDTO dateDTO, @PathVariable("id") String id){
        try {
            DateDTO updatedDate= dateService.updateDate(dateDTO);
            if(updatedDate != null){
                return new ResponseEntity<>(updatedDate, HttpStatus.CREATED);
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
