package com.eps.Appointments.DTOs;

import com.eps.Appointments.persistance.entities.Date;

import lombok.Data;

@Data
public class LaboratoryResultDTO {
    private Integer id;
    private Date date;
    private String description;
    private String archiveRute;

}
