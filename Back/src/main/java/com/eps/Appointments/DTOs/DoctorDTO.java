package com.eps.Appointments.DTOs;

import java.util.List;
import com.eps.Appointments.controllers.AbstractResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DoctorDTO extends AbstractResponse{

    private String id;
    private String password;
    private HeadquarterDTO headquarter;
    private List<SpecializationDTO> specializationList;


}
