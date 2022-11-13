/**
* Package with which the services of the appointments access
**/
package com.eps.Appointments.services;

/**
* Imports of springframework
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.SchedulingDTO;
import com.eps.Appointments.DTOs.AppointmentDTO;
import com.eps.Appointments.DTOs.MedicalDateDTO;
import com.eps.Appointments.mappers.SchedulingMapper;

/**
 * Creation of the public class SchedulingService
 * 
 * @Service It is used to mark the class as a service provider
 **/
@Service
public class SchedulingService {
  /**
   * annotation that allows to inject some dependencies with others inside Spring
   **/
  @Autowired
  /**
   * Private attribute of type SchedulingMapper of name schedulingMapper
   **/
  private SchedulingMapper schedulingMapper;
  @Autowired
  /**
   * Private attribute of type AppointmentService of name appointmentService
   **/
  private AppointmentService appointmentService;
  @Autowired
  /**
   * Private attribute of type DateService of name dateService
   **/
  private DateService dateService;

  /**
   * class creation SchedulingDTO with attributes SchedulingDTO
   * 
   * @Transactional annotation is the metadata that specifies the semantics of the
   *                transactions on a method
   **/
  @Transactional
  public SchedulingDTO create(SchedulingDTO scheduling) {
    MedicalDateDTO dateDTO = dateService.create(schedulingMapper.toDateDto(scheduling));
    if (dateDTO != null) {
      scheduling.setDateId(dateDTO.getId());
      AppointmentDTO appointmentDTO = appointmentService.create(schedulingMapper.toAppointmentDTO(scheduling));
      if (appointmentDTO != null) {
        return scheduling;
      }
      return null;
    }
    return null;
  }

}
