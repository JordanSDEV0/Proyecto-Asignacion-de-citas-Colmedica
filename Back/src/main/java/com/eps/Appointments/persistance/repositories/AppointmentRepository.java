/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.repositories;

import java.util.List;

/**
* Imports org.springframework
*/
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
* Imports com.eps
*/
import com.eps.Appointments.persistance.entities.Appointment;
import com.eps.Appointments.persistance.entities.MedicalDate;

/**
 * interface with name AppointmentRepository which comes from
 * CrudRepository<Appointment, Integer>
 */
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

  public List<Appointment> findAllByDateIn(List<MedicalDate> dates);
}
