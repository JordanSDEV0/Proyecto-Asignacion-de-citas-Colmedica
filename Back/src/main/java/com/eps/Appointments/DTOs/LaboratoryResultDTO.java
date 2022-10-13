package com.eps.Appointments.DTOs;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class LaboratoryResultDTO {

    private int id;
    private DateDTO date;
    private String description;
    private String archiveRute;

}
