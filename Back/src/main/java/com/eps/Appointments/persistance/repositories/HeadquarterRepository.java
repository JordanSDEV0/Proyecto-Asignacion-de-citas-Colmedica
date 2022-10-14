/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.repositories;
/**
* Imports java.util.Optional
*/
import java.util.Optional;
/**
* Imports org.springframework
*/
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
* Imports com.eps
*/
import com.eps.Appointments.persistance.entities.Headquarter;
/**
* interface with name HeadquarterRepository which comes from CrudRepository<Headquarter, Integer>
*/
@Repository
public interface HeadquarterRepository extends CrudRepository<Headquarter, Integer>{

    Optional<Headquarter> findByName(String name);

}
