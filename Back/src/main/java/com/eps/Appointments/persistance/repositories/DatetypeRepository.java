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
import com.eps.Appointments.persistance.entities.DateType;
/**
* interface with name DatetypeRepository which comes from CrudRepository<DateType, Integer>
*/
@Repository
public interface DatetypeRepository extends CrudRepository<DateType, Integer> {

}
