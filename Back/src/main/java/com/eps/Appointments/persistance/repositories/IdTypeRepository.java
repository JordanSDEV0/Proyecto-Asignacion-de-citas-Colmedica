package com.eps.Appointments.persistance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eps.Appointments.persistance.entities.IdType;

@Repository
public interface IdTypeRepository extends CrudRepository<IdType, Integer>{

}
