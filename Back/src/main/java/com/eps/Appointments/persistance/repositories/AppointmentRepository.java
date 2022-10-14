/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.repositories;
/**
* Imports org.springframework
*/
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
* Imports com.eps
*/
import com.eps.Appointments.persistance.entities.Appointment;
/**
* interface with name AppointmentRepository which comes from CrudRepository<Appointment, Integer>
*/
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{
    
}
