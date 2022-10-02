package com.eps.Appointments.persistance.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eps.Appointments.persistance.entities.Patient;
@Repository
public sealed interface PatientRepository extends CrudRepository<Patient, String>{

}
