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
import com.eps.Appointments.DTOs.AppointmentDTO;
import com.eps.Appointments.DTOs.ErrorDTO;
import com.eps.Appointments.services.AppointmentService;
import com.eps.Appointments.services.DoctorService;
import com.eps.Appointments.services.PatientService;
import com.eps.Appointments.services.DateService;
/**
* @RestController Simplifica la implementacion del controller
* @RequestMapping para asignar todas las URL de solicitudes HTTP entrantes a los métodos de controlador correspondientes
**/
@RestController
@RequestMapping("/appointments")
public class AppointmentController {
/**
* 
**/
    @Autowired
    private AppointmentService appointmentService;
/**
* Definimos un atributo de tipo privado llamado appointmentservice
* @Autowired. Permite que Spring resuelva e inyecte beans colaboradores en nuestro bean
**/	
    @Autowired
    private DoctorService doctorService;
/**
* definimos un atributo tipo privado llamdo doctorservice
* @Autowired. Permite que Spring resuelva e inyecte beans colaboradores en nuestro bean
**/
    @Autowired
    private PatientService patientService;
/**
* definimos un atributo tipo privado llamado patientservice
* @Autowired. Permite que Spring resuelva e inyecte beans colaboradores en nuestro bean
**/
    @Autowired
    private DateService dateService;
/**
* definimos un atributo tipo privado llamado dateservice 
* @Autowired. Permite que Spring resuelva e inyecte beans colaboradores en nuestro bean
**/

/**
*se crea un metodo el cual recorrera todo hasta obtener la informacion suficiente
* @PostMapping es una versión especializada de la anotación @RequestMapping
**/
    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody AppointmentDTO appointmentDTO){
        try {
            if((doctorService.getById(appointmentDTO.getDoctorId()) != null) && (patientService.getById(appointmentDTO.getPatientId()) != null) && (dateService.getById(appointmentDTO.getDateId()) != null)){
                AppointmentDTO newAppointment= appointmentService.create(appointmentDTO);
                if(newAppointment != null){
                    return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
                }
                return new ResponseEntity<ErrorDTO>(new ErrorDTO("El agendamiento no fue creado"), HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<ErrorDTO>(new ErrorDTO("Appointment not created, no se encontro el doctor o el paciente o la cita"), HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
* Se crea un metdo el cual funciona para obtener informacion 
* @GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/
    @GetMapping
    public ResponseEntity<? extends Object> getAll(){
        try{
            return new ResponseEntity<>(appointmentService.getAll(), HttpStatus.OK);
	    } catch(IllegalArgumentException illegalArgumentException){
	        System.out.println(illegalArgumentException.getCause());
	        return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
	        System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/**
*Se crea un metodo el cual dira si el paciente fue creado por medio de id
* @PutMapping en su aplicación de servicios web RESTful para poder aceptar solicitudes HTTP Put que contengan un cuerpo de solicitud con JSON
**/
    @PutMapping("/{id}")
    private ResponseEntity<? extends Object> Update(@RequestBody AppointmentDTO appointmentDTO, @PathVariable("id") int id){
        try {
            AppointmentDTO updateAppointment= appointmentService.updateAppointment(appointmentDTO);
            if(updateAppointment != null){
                return new ResponseEntity<>(updateAppointment, HttpStatus.CREATED);
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
* Se crea un metodo que comprueba si la informacion se esta obteniendo
* @GetMapping es una anotación compuesta que actúa como acceso directo para @RequestMapping
**/
    @GetMapping("/{id}")
        public ResponseEntity<? extends Object> getById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<AppointmentDTO>(appointmentService.getById(id), HttpStatus.OK);
	} catch(IllegalArgumentException illegalArgumentException){
	    System.out.println(illegalArgumentException.getCause());
	    return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
    } catch(Exception e){
	    System.out.println(e.getCause());
        return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    }
}
