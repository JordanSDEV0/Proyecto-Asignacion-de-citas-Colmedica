/**
* Package with which the services of the appointments access
**/}
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
import com.eps.Appointments.DTOs.DateTypeDTO;
import com.eps.Appointments.mappers.DateTypeMapper;
import com.eps.Appointments.persistance.entities.DateType;
import com.eps.Appointments.persistance.repositories.DatetypeRepository;
/**
* Creation of the public class DateTypeService
* @Service It is used to mark the class as a service provider 
**/
@Service
public class DateTypeService {
    /**
    * annotation that allows to inject some dependencies with others inside Spring
    **/
    @Autowired
    /**
    * Private attribute of type DatetypeRepository of name datetypeRepository
    **/
    private DatetypeRepository datetypeRepository;
    @Autowired/**
    * Private attribute of type DateTypeMapper of name dateTypeMapper
    **/
    private DateTypeMapper dateTypeMapper;
    /**
    * creation of the class List<DateTypeDTO> getAll
    **/
    public List<DateTypeDTO> getAll(){
        return dateTypeMapper.toDateTypeDTOs((List<DateType>) datetypeRepository.findAll());
    };
    
}
