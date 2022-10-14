/**
* Package with which the services of the appointments access
**/
package com.eps.Appointments.services;
/**
* Imports of java util
*/
import java.util.List;
/**
* Imports of springframework
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.HeadquarterDTO;
import com.eps.Appointments.mappers.HeadquarterMapper;
import com.eps.Appointments.persistance.entities.Headquarter;
import com.eps.Appointments.persistance.repositories.HeadquarterRepository;
/**
* Creation of the public class HeadquarterService
* @Service It is used to mark the class as a service provider 
**/
@Service
public class HeadquarterService {
    /**
    * annotation that allows to inject some dependencies with others inside Spring
    **/
    @Autowired/**
    * Private attribute of type HeadquarterRepository of name headquarterRepository
    **/
    private HeadquarterRepository headquarterRepository;
    /**
    * Private attribute of type HeadquarterMapper of name headquarterMapper
    **/
    @Autowired
    private HeadquarterMapper headquarterMapper;
    /**
    * creation of the class HeadquarterDTO getById with name attributes
    **/
    public HeadquarterDTO getByName(String name){
        return headquarterMapper.toHeadquarterDTO(headquarterRepository.findByName(name).map(h -> {
            return h;
        }).orElse(null));
    }
    /**
    * creation of the class List<HeadquarterDTO> getAll
    **/
    public List<HeadquarterDTO> getAll(){
        return headquarterMapper.toHeadquarterDTOs((List<Headquarter>) headquarterRepository.findAll());
    }

}
