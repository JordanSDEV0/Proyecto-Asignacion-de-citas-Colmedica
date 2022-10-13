package com.eps.Appointments.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.DTOs.DateTypeDTO;
import com.eps.Appointments.mappers.DateTypeMapper;
import com.eps.Appointments.persistance.entities.DateType;
import com.eps.Appointments.persistance.repositories.DatetypeRepository;

@Service
public class DateTypeService {

    @Autowired
    private DatetypeRepository datetypeRepository;
    @Autowired
    private DateTypeMapper dateTypeMapper;

    public List<DateTypeDTO> getAll(){
        return dateTypeMapper.toDateTypeDTOs((List<DateType>) datetypeRepository.findAll());
    };
    
}
