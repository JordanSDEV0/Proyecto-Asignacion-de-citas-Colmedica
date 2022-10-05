package com.eps.Appointments.DTOs;

import lombok.Data;

@Data
public class LaboratoryResultDTO {

    private int id;
    private DateDTO dateDTO;
    private String description;
    private String archiveRute;

}
