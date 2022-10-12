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
    //@Transactional
    //public OcupationDTO getById(Integer id){
      //  return ocupationMapper.toOcupationDTO(ocupationMapper.findById(id).map(ocupation -> {
        //    return ocupation;
        //}).orElseGet(null));
    //}
    @Transactional
    public List<OcupationDTO> getAll(){
        List<Ocupation> ocupation= (List<Ocupation>) ocupationRepository.findAll();
        return ocupationMapper.toOcupationDTOs(ocupation);
    }
}
