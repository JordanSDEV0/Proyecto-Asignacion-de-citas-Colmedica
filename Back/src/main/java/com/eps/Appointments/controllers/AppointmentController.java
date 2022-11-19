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
import org.springframework.web.bind.annotation.CrossOrigin;
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

/**
 * @RestController Simplifies controller implementation
 * @RequestMapping to map all incoming HTTP request URLs to the corresponding
 *                 controller methods
 **/
@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")

public class AppointmentController {
    /**
     * the class is created
     **/
    @Autowired
    private AppointmentService appointmentService;

    /**
     * a method is created which will go through everything until it obtains enough
     * information
     *
     * @PostMapping is a specialized version of the @RequestMapping annotation
     **/
    @PostMapping
    private ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.create(appointmentDTO));
    }

    /**
     * A method is created which works to obtain information
     *
     * @GetMapping is a compound annotation that acts as a shortcut
     *             for @RequestMapping
     **/
    @GetMapping
    public ResponseEntity<? extends Object> getAll() {
        try {
            return new ResponseEntity<>(appointmentService.getAll(), HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getCause());
            return new ResponseEntity<>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    /// **
    // *
    // * A method is created which works to obtain information
    // *
    // * @GetMapping is a compound annotation that acts as a shortcut
    // * for @RequestMapping
    // **/
    // @GetMapping("/active")
    // public ResponseEntity<?> getAllActive() {
    // try {
    // return new ResponseEntity<>(appointmentService.getAllActive(),
    /// HttpStatus.OK);
    // } catch (IllegalArgumentException illegalArgumentException) {
    // System.out.println(
    // "IAE on getAllActive method on appointment controller:\n" +
    /// illegalArgumentException.getMessage());
    // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    // } catch (Exception e) {
    // System.out.println("General Error on getAllActive method on appointment
    /// controller:\n" + e.getMessage());
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    /// **
    // * A method is created which works to obtain information
    // *
    // * @GetMapping is a compound annotation that acts as a shortcut
    // * for @RequestMapping
    // **/
    // @GetMapping("/patients/{id}")
    // private ResponseEntity<?> getAllByPatient(@PathVariable(name = "id") String
    /// id) {
    // try {
    // return new ResponseEntity<>(appointmentService.getAllByPatient(id),
    /// HttpStatus.OK);
    // } catch (IllegalArgumentException illegalArgumentException) {
    // System.out.println(
    // "IAE on getAllByUser method on appointment controller:\n" +
    /// illegalArgumentException.getMessage());
    // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    // } catch (Exception e) {
    // System.out.println("General Error on getAllByUser method on appointment
    /// controller:\n" + e.getMessage());
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    /// **
    // * A method is created which works to obtain information
    // *
    // * @GetMapping is a compound annotation that acts as a shortcut
    // * for @RequestMapping
    // **/
    // @GetMapping("/doctors/{id}")
    // private ResponseEntity<?> getAllByDoctor(@PathVariable(name = "id") String
    /// id) {
    // try {
    // return new ResponseEntity<>(appointmentService.getAllByDoctor(id),
    /// HttpStatus.OK);
    // } catch (IllegalArgumentException illegalArgumentException) {
    // System.out.println(
    // "IAE on getAllByUser method on appointment controller:\n" +
    /// illegalArgumentException.getMessage());
    // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    // } catch (Exception e) {
    // System.out.println("General Error on getAllByUser method on appointment
    /// controller:\n" + e.getMessage());
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    /// **
    // * A method is created which will say if the patient was created by means of
    /// id
    // *
    // * @PutMapping in your RESTful web services application to be able to accept
    // * HTTP Put requests that contain a JSON request body
    // **/
    // @PutMapping("/{id}")
    // private ResponseEntity<? extends Object> Update(@RequestBody AppointmentDTO
    /// appointmentDTO,
    // @PathVariable("id") int id) {
    // try {
    // AppointmentDTO updateAppointment =
    /// appointmentService.updateAppointment(appointmentDTO);
    // if (updateAppointment != null) {
    // return new ResponseEntity<>(updateAppointment, HttpStatus.CREATED);
    // }
    // return new ResponseEntity<>(new ErrorDTO("Patient not created"),
    /// HttpStatus.ACCEPTED);
    // } catch (IllegalArgumentException illegalArgumentException) {
    // System.out.println(illegalArgumentException.getCause());
    // return new ResponseEntity<>(new
    /// ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
    // } catch (Exception e) {
    // System.out.println(e.getMessage());
    // return new ResponseEntity<>(new ErrorDTO(e.getMessage()),
    /// HttpStatus.BAD_REQUEST);
    // }
    // }

    /// **
    // * A method is created that checks if the information is being obtained
    // *
    // * @GetMapping is a compound annotation that acts as a shortcut
    // * for @RequestMapping
    // **/
    // @GetMapping("/{id}")
    // public ResponseEntity<? extends Object> getById(@PathVariable("id") Integer
    /// id) {
    // try {
    // return new ResponseEntity<AppointmentDTO>(appointmentService.getById(id),
    /// HttpStatus.OK);
    // } catch (IllegalArgumentException illegalArgumentException) {
    // System.out.println(illegalArgumentException.getCause());
    // return new ResponseEntity<ErrorDTO>(new
    /// ErrorDTO(illegalArgumentException.getMessage()),
    // HttpStatus.NOT_FOUND);
    // } catch (Exception e) {
    // System.out.println(e.getCause());
    // return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),
    /// HttpStatus.BAD_REQUEST);
    // }
    // }

    /// **
    // * method that delete Appointment
    // *
    // * @DeleteMapping to remove a resource. We use annotations to configure a
    /// Spring
    // * web application
    // **/
    // @DeleteMapping("/{id}")
    // public ResponseEntity<?> deleteAppointment(@PathVariable int id) {
    // try {
    // return new ResponseEntity<>(appointmentService.delete(id), HttpStatus.OK);
    // } catch (IllegalArgumentException illegalArgumentException) {
    // System.out.println(
    // "IAE on delete method on appointment controller:\n" +
    /// illegalArgumentException.getMessage());
    // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    // } catch (Exception e) {
    // System.out.println("General Error on delete method on appointment
    /// controller:\n" + e.getMessage());
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

}
