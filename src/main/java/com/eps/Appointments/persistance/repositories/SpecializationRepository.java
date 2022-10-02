package com.eps.Appointments.persistance.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eps.Appointments.persistance.entities.Specialization;
@Repository
public interface SpecializationRepository extends CrudRepository<Specialization, String>{

}
