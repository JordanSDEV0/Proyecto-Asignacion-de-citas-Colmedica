package com.eps.Appointments.DTOs;

import com.eps.Appointments.controllers.AbstractResponse;

import lombok.Data;

@Data
public class AdminDTO extends AbstractResponse{
    
    private String id;
    private String password;

}
