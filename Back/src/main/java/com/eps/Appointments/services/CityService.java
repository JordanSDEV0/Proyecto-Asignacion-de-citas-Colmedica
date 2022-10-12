package com.eps.Appointments.services;

import com.eps.Appointments.persistance.entities.City;
import com.eps.Appointments.persistance.repositories.CityRepository;



public class CityService {
    private CityRepository cityRepository;

    public City getUser(Integer id){
        return cityRepository.findById(id).map(city -> {
            return city;
        }).orElse(null);
    }
}
