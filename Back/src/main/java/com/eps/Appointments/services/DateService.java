package com.eps.Appointments.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eps.Appointments.DTOs.DateDTO;
import com.eps.Appointments.mappers.DateMapper;
import com.eps.Appointments.persistance.entities.Date;
import com.eps.Appointments.persistance.repositories.DateRepository;

@Service
public class DateService {

    @Autowired
    DateRepository dateRepository;
    @Autowired
    DateMapper dateMapper;

    public DateDTO getById(int dateId) {
        return dateMapper.toDateDto(dateRepository.findById(dateId).map(date -> {
            return date;
        }).orElseGet(null));
    }

    @Transactional
    public DateDTO create(DateDTO dateDTO) throws IllegalArgumentException{
        return dateMapper.toDateDto(dateRepository.save(dateMapper.toDate(dateDTO)));
    }
    public List<DateDTO> getAll(){
        List<Date> dates= (List<Date>) dateRepository.findAll();
        return dateMapper.toDateDTOs(dates);
    }
    @Transactional
    public DateDTO updateDate(DateDTO dateDTO){
        if(getById(dateDTO.getId()) != null){
            Date updatedDate = dateMapper.toDate(dateDTO);
            return dateMapper.toDateDto(dateRepository.save(updatedDate));
        }
        return null;
    }
      @Transactional
    public DateDTO getById(Integer id){
       return dateMapper.toDateDto(dateRepository.findById(id).map(date -> {
           return date;
      }).orElseGet(null));
    }
    
}
