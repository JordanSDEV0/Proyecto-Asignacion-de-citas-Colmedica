/**
* Package with which the services of the appointments access
**/
package com.eps.Appointments.services;
/**
* Imports of java util
*/
import java.util.List;
/**
* Imports of transaction
*/
import javax.transaction.Transactional;
/**
* Imports of springframework
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.OcupationDTO;
import com.eps.Appointments.mappers.OcupationMapper;
import com.eps.Appointments.persistance.entities.Ocupation;
import com.eps.Appointments.persistance.repositories.OcupationRepository;
/**
* Creation of the public class OcupationService
* @Service It is used to mark the class as a service provider 
**/
@Service
public class OcupationService {
    /**
    * annotation that allows to inject some dependencies with others inside Spring
    **/
    @Autowired
    /**
    * Private attribute of type OcupationRepository of name ocupationRepository
    **/
    private OcupationRepository ocupationRepository;
    @Autowired
    /**
    * Private attribute of type OcupationMapper of name ocupationMapper
    **/
    private OcupationMapper ocupationMapper;
    /**
    * class creation OcupationDTO with attributes ocupation and exception IllegalArgumentException
    * @Transactional annotation is the metadata that specifies the semantics of the transactions on a method
    **/
    @Transactional
    public OcupationDTO create(OcupationDTO ocupation) throws IllegalArgumentException{
        ocupationRepository.save(ocupationMapper.toOcupation(ocupation));
        return ocupation;
    }
    /**
    * creation of the class OcupationDTO getById with id attributes
    **/
    public OcupationDTO getById(int id){
        return ocupationMapper.toOcupationDTO(ocupationRepository.findById(id).map(ocupation -> {
            return ocupation;
        }).orElseGet(null));
    }
    /**
    * creation of the class List<OcupationDTO> getAll
    **/
    public List<OcupationDTO> getAll(){
        List<Ocupation> ocupation= (List<Ocupation>) ocupationRepository.findAll();
        return ocupationMapper.toOcupationDTOs(ocupation);
    }
    /**
    * class creation OcupationDTO with updateOcupation and attributes ocupationDTO 
    **/
    @Transactional
    public OcupationDTO updateOcupation(OcupationDTO ocupationDTO){
        if(getById(ocupationDTO.getId()) != null){
            Ocupation updatedOcupation = ocupationMapper.toOcupation(ocupationDTO);
            return ocupationMapper.toOcupationDTO(ocupationRepository.save(updatedOcupation));
        }
        return null;
    }

}
