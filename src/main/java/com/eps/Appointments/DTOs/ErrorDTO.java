package com.eps.Appointments.DTOs;

import com.eps.Appointments.controllers.AbstractResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorDTO extends AbstractResponse{

    private String message;
    
}
