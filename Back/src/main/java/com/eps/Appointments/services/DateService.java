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
import org.springframework.transaction.annotation.Transactional;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.MedicalDateDTO;
import com.eps.Appointments.mappers.DateMapper;
import com.eps.Appointments.persistance.entities.MedicalDate;
import com.eps.Appointments.persistance.repositories.DateRepository;

/**
 * Creation of the public class DateService
 * 
 * @Service It is used to mark the class as a service provider
 **/
@Service
public class DateService {
    /**
     * annotation that allows to inject some dependencies with others inside Spring
     **/
    @Autowired
    /**
     * attribute of type DateRepository of name dateRepository
     **/
    DateRepository dateRepository;
    @Autowired
    /**
     * attribute of type DateMapper of name dateMapper
     **/
    DateMapper dateMapper;

    /**
     * creation of the class DateDTO getById with dateId attributes
     **/
    public MedicalDateDTO getById(int dateId) {
        return dateMapper.toDateDto(dateRepository.findById(dateId).map(date -> {
            return date;
        }).orElseGet(null));
    }

    /**
     * class creation DateDTO with attributes dateDTO and exception
     * IllegalArgumentException
     * 
     * @Transactional annotation is the metadata that specifies the semantics of the
     *                transactions on a method
     **/
    @Transactional
    public MedicalDateDTO create(MedicalDateDTO dateDTO) throws IllegalArgumentException {
        return dateMapper.toDateDto(dateRepository.save(dateMapper.toDate(dateDTO)));
    }

    /**
     * creation of the class List<DateDTO> getAll
     **/
    public List<MedicalDateDTO> getAll() {
        List<MedicalDate> dates = (List<MedicalDate>) dateRepository.findAll();
        return dateMapper.toDateDTOs(dates);
    }

    /**
     * class creation DateDTO with attributes updateDate and dateDTO
     * 
     * @Transactional annotation is the metadata that specifies the semantics of the
     *                transactions on a method
     **/
    @Transactional
    public MedicalDateDTO updateDate(MedicalDateDTO dateDTO) {
        if (getById(dateDTO.getId()) != null) {
            MedicalDate updatedDate = dateMapper.toDate(dateDTO);
            return dateMapper.toDateDto(dateRepository.save(updatedDate));
        }
        return null;
    }

    public MedicalDateDTO getById(Integer id) {
        return dateMapper.toDateDto(dateRepository.findById(id).map(ocupation -> {
            return ocupation;
        }).orElseGet(null));

    }

}
