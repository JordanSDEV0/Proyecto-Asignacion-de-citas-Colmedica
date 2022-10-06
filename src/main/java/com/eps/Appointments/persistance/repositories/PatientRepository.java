package com.eps.Appointments.persistance.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eps.Appointments.persistance.entities.Patient;
import com.eps.Appointments.persistance.entities.User;
@Repository
public interface PatientRepository extends CrudRepository<Patient, User>{

}
