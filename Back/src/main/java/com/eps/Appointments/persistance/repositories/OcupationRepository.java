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
import com.eps.Appointments.persistance.entities.Ocupation;
/**
* interface with name OcupationRepository which comes from CrudRepository<Ocupation, Integer>
*/
@Repository
public interface OcupationRepository extends CrudRepository<Ocupation, Integer>{

}
