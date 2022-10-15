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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.SchedulingDTO;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.SchedulingService;
/**
* @RestController Simplifica la implementacion del controller
* @RequestMapping para asignar todas las URL de solicitudes HTTP entrantes a los métodos de controlador correspondientes
* @CrossOrigin permitir solicitudes de origen cruzado en clases de controlador específicas y/o métodos de controlador
**/
@RestController
@RequestMapping("/scheduling")
@CrossOrigin
public class SchedulingController {

/**
* Se crea una clase publica llamada shedulingController
**/	
    @Autowired
    private SchedulingService schedulingService;
/**
* Se crea un metodo privado llamada shedulingservice 
* @Autowired. Permite que Spring resuelva e inyecte beans colaboradores en nuestro bean
**/

	
/**
* Se crea un metodo llamada ResponseEntity  en donde dara la orden de mostrarnos si sale si la cita no fue creada 
* @PostMapping es una versión especializada de la anotación @RequestMapping
**/
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
/**
*Se crea un metodo tipo publico el cual obtendra esta informacion
*@GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/
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
/**
* se crea un metodo de tipo publica el cual tendra la funcion de obtener la informacion
* @GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/
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
