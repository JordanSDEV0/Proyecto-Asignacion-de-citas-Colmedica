package com.eps.Appointments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.persistance.repositories.HeadquarterRepository;

@Service
public class HeadquarterService {

    @Autowired
    private HeadquarterRepository headquarterRepository;

}
