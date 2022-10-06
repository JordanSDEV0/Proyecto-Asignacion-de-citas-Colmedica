package com.eps.Appointments.DTOs;

import lombok.Data;

@Data
public class LaboratoryResultDTO {

    private int id;
    private DateDTO date;
    private String description;
    private String archiveRute;

}
