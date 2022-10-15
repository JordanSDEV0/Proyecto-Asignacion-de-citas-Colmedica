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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.HeadquarterService;
/**
* Se crea una clase llamad headquarterController
*@RestController Simplifica la implementacion del controller
*@RequestMapping para asignar todas las URL de solicitudes HTTP entrantes a los métodos de controlador correspondientes
*@CrossOrigin permitir solicitudes de origen cruzado en clases de controlador específicas y/o métodos de controlador
**/
@RestController
@RequestMapping("/headquarter")
@CrossOrigin
public class HeadquarterController {
/**
*Se crea un metodo llamado headquarterservice
* @Autowired. Permite que Spring resuelva e inyecte beans colaboradores en nuestro bean
**/
    @Autowired
    private HeadquarterService headquarterService;
/**
*Se creaun un metdoo para obtener el nombre
* @GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/
    @GetMapping("/{name}")
    private ResponseEntity<? extends Object> getByName(@PathVariable(name = "name") String name){
        try{
            return new ResponseEntity<>(headquarterService.getByName(name), HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* Se obtiene un objeto para saber si se esta cumpliendo
*@GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping 
**/
    @GetMapping
    private ResponseEntity<? extends Object> getAll(){
        try {
            return ResponseEntity.ok(headquarterService.getAll());
        } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
}
