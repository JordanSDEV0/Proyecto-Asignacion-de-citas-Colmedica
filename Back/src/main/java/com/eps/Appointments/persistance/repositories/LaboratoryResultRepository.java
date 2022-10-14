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
import com.eps.Appointments.persistance.entities.LaboratoryResult;
/**
* interface with name LaboratoryResultRepository which comes from CrudRepository<LaboratoryResult, Integer>
*/
@Repository
public interface LaboratoryResultRepository extends CrudRepository<LaboratoryResult, Integer>{

}
