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
import com.eps.Appointments.persistance.entities.IdType;
/**
* interface with name IdTypeRepository which comes from CrudRepository<IdType, Integer>
*/
@Repository
public interface IdTypeRepository extends CrudRepository<IdType, Integer>{

}
