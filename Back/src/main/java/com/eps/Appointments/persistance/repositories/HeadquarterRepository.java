package com.eps.Appointments.persistance.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eps.Appointments.persistance.entities.Headquarter;

@Repository
public interface HeadquarterRepository extends CrudRepository<Headquarter, Integer>{

    Optional<Headquarter> findByName(String name);

}
