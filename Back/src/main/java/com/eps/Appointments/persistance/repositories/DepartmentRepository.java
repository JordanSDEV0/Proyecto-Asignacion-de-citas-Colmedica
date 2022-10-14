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
import com.eps.Appointments.persistance.entities.Department;
/**
* interface with name DepartmentRepository which comes from CrudRepository<Department, Integer>
*/
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>{

}
