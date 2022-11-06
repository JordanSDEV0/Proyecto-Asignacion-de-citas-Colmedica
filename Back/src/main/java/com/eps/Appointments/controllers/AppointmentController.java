/**
* package where the controller is accessed
**/
package com.eps.Appointments.controllers;
/**
*  imports of Springframework
**/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
* @RestController Simplifies controller implementation
* @RequestMapping to map all incoming HTTP request URLs to the corresponding controller methods
**/
@RestController
@RequestMapping("/appointments")
public class AppointmentController {
/**
* the class is created
**/
   @Autowired
    private AppointmentService appointmentService;
/**
* We define a private type attribute called appointmentservice
* @Autowired. Allows Spring to resolve and inject helper beans into our bean
**/
    @Autowired
    private DoctorService doctorService;
/**
* we define a private type attribute called doctorservice
* @Autowired. Allows Spring to resolve and inject helper beans into our bean
**/
    @Autowired
    private PatientService patientService;
/**
* we define a private type attribute called patientservice
* @Autowired. Allows Spring to resolve and inject helper beans into our bean
**/
    @Autowired
    private DateService dateService;
/**
* a method is created which will go through everything until it obtains enough information
* @PostMapping is a specialized version of the @RequestMapping annotation
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
* A method is created which works to obtain information
* @GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
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

    @GetMapping
    public ResponseEntity<?> getAllActive(){
        try {
            return new ResponseEntity<>(appointmentService.getAllActive(), HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println("IAE on getAllActive method on appointment controller:\n" + illegalArgumentException.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("General Error on getAllActive method on appointment controller:\n" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patients/{id}")
    private ResponseEntity<?> getAllByPatient(@PathVariable(name = "id") String id){
        try {
            return new ResponseEntity<>(appointmentService.getAllByPatient(id), HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println("IAE on getAllByUser method on appointment controller:\n" + illegalArgumentException.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("General Error on getAllByUser method on appointment controller:\n" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

/**
* A method is created which will say if the patient was created by means of id
* @PutMapping in your RESTful web services application to be able to accept HTTP Put requests that contain a JSON request body
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
* A method is created that checks if the information is being obtained
* @GetMapping is a compound annotation that acts as a shortcut for @RequestMapping
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable int id) {
        try {
            return new ResponseEntity<>(appointmentService.delete(id), HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println("IAE on delete method on appointment controller:\n" + illegalArgumentException.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("General Error on delete method on appointment controller:\n" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
