package com.eps.Appointments.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.DTOs.OcupationDTO;
import com.eps.Appointments.mappers.OcupationMapper;
import com.eps.Appointments.persistance.entities.Ocupation;
import com.eps.Appointments.persistance.repositories.OcupationRepository;

@Service
public class OcupationService {

    @Autowired
    private OcupationRepository ocupationRepository;
    @Autowired
    private OcupationMapper ocupationMapper;

    @Transactional
    public OcupationDTO create(OcupationDTO ocupation) throws IllegalArgumentException{
        ocupationRepository.save(ocupationMapper.toOcupation(ocupation));
        return ocupation;
    }

    public OcupationDTO getById(int id){
        return ocupationMapper.toOcupationDTO(ocupationRepository.findById(id).map(ocupation -> {
            return ocupation;
        }).orElseGet(null));
    }

    public List<OcupationDTO> getAll(){
        List<Ocupation> ocupation= (List<Ocupation>) ocupationRepository.findAll();
        return ocupationMapper.toOcupationDTOs(ocupation);
    }

    @Transactional
    public OcupationDTO updateOcupation(OcupationDTO ocupationDTO){
        if(getById(ocupationDTO.getId()) != null){
            Ocupation updatedOcupation = ocupationMapper.toOcupation(ocupationDTO);
            return ocupationMapper.toOcupationDTO(ocupationRepository.save(updatedOcupation));
        }
        return null;
    }

}
