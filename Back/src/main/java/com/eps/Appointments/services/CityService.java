package com.eps.Appointments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.persistance.entities.City;
import com.eps.Appointments.persistance.repositories.CityRepository;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City getUser(Integer id){
        return cityRepository.findById(id).map(city -> {
            return city;
        }).orElse(null);
    }

}
