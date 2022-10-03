package com.eps.Appointments.persistance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eps.Appointments.persistance.entities.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {


}
