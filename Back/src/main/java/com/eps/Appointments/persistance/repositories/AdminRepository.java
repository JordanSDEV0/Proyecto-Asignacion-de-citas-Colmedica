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
import com.eps.Appointments.persistance.entities.Admin;
/**
* interface with name AdminRepository which comes from CrudRepository<Admin, Stringr>
*/
@Repository
public interface AdminRepository extends CrudRepository<Admin, String>{
    
}
