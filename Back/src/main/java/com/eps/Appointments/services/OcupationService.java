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
Imports of springframework
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
Imports of Appointments
*/
import com.eps.Appointments.DTOs.OccupationDTO;
import com.eps.Appointments.mappers.OccupationMapper;
import com.eps.Appointments.persistance.entities.Occupation;
import com.eps.Appointments.persistance.repositories.OcupationRepository;

/**
 * Creation of the public class OcupationService
 * 
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
    private OccupationMapper ocupationMapper;

    /**
     * class creation OcupationDTO with attributes ocupation and exception
     * IllegalArgumentException
     * 
     * @Transactional annotation is the metadata that specifies the semantics of the
     *                transactions on a method
     **/
    @Transactional
    public OccupationDTO create(OccupationDTO ocupation) throws IllegalArgumentException {
        ocupationRepository.save(ocupationMapper.toOccupation(ocupation));
        return ocupation;
    }

    /**
     * creation of the class OcupationDTO getById with id attributes
     **/
    public OccupationDTO getById(int id) {
        return ocupationMapper.toOccupationDTO(ocupationRepository.findById(id).map(ocupation -> {
            return ocupation;
        }).orElseGet(null));
    }

    /**
     * creation of the class List<OcupationDTO> getAll
     **/
    public List<OccupationDTO> getAll() {
        List<Occupation> ocupation = (List<Occupation>) ocupationRepository.findAll();
        return ocupationMapper.toOccupationDTOs(ocupation);
    }

    /**
     * class creation OcupationDTO with updateOcupation and attributes ocupationDTO
     **/
    @Transactional
    public OccupationDTO updateOcupation(OccupationDTO ocupationDTO) {
        if (getById(ocupationDTO.getId()) != null) {
            Occupation updatedOcupation = ocupationMapper.toOccupation(ocupationDTO);
            return ocupationMapper.toOccupationDTO(ocupationRepository.save(updatedOcupation));
        }
        return null;
    }

}
