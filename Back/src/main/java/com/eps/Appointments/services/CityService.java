/**
* Package with which the services of the appointments access
**/
package com.eps.Appointments.services;
/**
* Imports of springframework
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* Imports of Appointments
*/
import com.eps.Appointments.persistance.entities.City;
import com.eps.Appointments.persistance.repositories.CityRepository;
/**
* Creation of the public class CityService
* @Service It is used to mark the class as a service provider 
**/
@Service
public class CityService {
/**
    * annotation that allows to inject some dependencies with others inside Spring
    **/
    @Autowired
    /**
    * Private attribute of type CityRepository of name cityRepository
    **/
    private CityRepository cityRepository;
/**
    * creation of the class City getUser with id attributes
    **/
    public City getUser(Integer id){
        return cityRepository.findById(id).map(city -> {
            return city;
        }).orElse(null);
    }

}
