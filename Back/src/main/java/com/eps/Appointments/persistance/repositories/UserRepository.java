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
import com.eps.Appointments.persistance.entities.User;
/**
* interface with name UserRepository which comes from CrudRepository<User, String>
*/
@Repository
public interface UserRepository extends CrudRepository<User, String>{
    
}
