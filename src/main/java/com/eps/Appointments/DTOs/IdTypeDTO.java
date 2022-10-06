package com.eps.Appointments.DTOs;



import com.eps.Appointments.controllers.AbstractResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IdTypeDTO extends AbstractResponse{

	private int id;
    private String type;
    
}
