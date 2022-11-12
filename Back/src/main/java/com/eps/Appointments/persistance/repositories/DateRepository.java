/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.repositories;

import java.time.LocalDateTime;
import java.util.List;

/**
* Imports org.springframework
*/
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
* Imports com.eps
*/
import com.eps.Appointments.persistance.entities.MedicalDate;

/**
 * interface with name DateRepository which comes from CrudRepository<Date,
 * Integer>
 */
@Repository
public interface DateRepository extends CrudRepository<MedicalDate, Integer> {

  public List<MedicalDate> findAllByInitialTimeAfter(LocalDateTime initialTime);

}
