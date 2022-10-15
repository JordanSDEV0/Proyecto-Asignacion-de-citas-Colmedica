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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.DateTypeService;

/**
* se crea un clase llamad DateTypeController
* @RestController Simplifica la implementacion del controller
* @RequestMapping para asignar todas las URL de solicitudes HTTP entrantes a los métodos de controlador correspondientes
* @CrossOrigin permitir solicitudes de origen cruzado en clases de controlador específicas y/o métodos de controlador
 */
@RestController
@RequestMapping("/date_type")
@CrossOrigin
public class DateTypeController {
/**
* Se usa un metodo llamado DateTypeService
* @Autowired. Permite que Spring resuelva e inyecte beans colaboradores en nuestro bean
**/
    @Autowired
    private DateTypeService dateTypeService;
/**
*Se usa el metodo para obtener informacion
*@GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping 
**/
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
