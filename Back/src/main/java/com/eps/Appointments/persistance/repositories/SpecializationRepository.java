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
import com.eps.Appointments.persistance.entities.Specialization;
/**
* interface with name SpecializationRepository which comes from CrudRepository<Specialization, Integer>
*/
@Repository
public interface SpecializationRepository extends CrudRepository<Specialization, Integer>{

}
