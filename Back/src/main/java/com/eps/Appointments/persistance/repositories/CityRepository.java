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
import com.eps.Appointments.persistance.entities.City;
/**
* interface with name CityRepository which comes from CrudRepository<City, Integer>
*/
@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

}
