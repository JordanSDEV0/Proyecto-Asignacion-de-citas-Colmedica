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
import com.eps.Appointments.persistance.entities.Access;
/**
* interface with name AccessRepository which comes from CrudRepository<Access, Integer>
*/
@Repository
public interface AccessRepository extends CrudRepository<Access, Integer>{

}
