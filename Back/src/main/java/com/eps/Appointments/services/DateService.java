package com.eps.Appointments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eps.Appointments.DTOs.DateDTO;
import com.eps.Appointments.mappers.DateMapper;
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
    
}
