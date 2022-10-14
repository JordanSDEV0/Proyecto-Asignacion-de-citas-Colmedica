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
import com.eps.Appointments.persistance.entities.Doctor;
/**
* interface with name DoctorRepository which comes from CrudRepository<Doctor, String>
*/
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, String>{

}
