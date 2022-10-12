package com.eps.Appointments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.DTOs.PatientDTO;
import com.eps.Appointments.mappers.PatientMapper;
import com.eps.Appointments.persistance.repositories.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientMapper patientMapper;

    public PatientDTO getById(String id) {
        return patientMapper.toPatientDTO(patientRepository.findById(id).map(patient -> {
            return patient;
        }).orElseGet(null));
    }
    
}
