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
import com.eps.Appointments.persistance.entities.Patient;
/**
* interface with name PatientRepository which comes from CrudRepository<Patient, Integer>
*/
@Repository
public interface PatientRepository extends CrudRepository<Patient, String>{

}
