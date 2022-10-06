package com.eps.Appointments.DTOs;

import java.time.LocalDateTime;

import com.eps.Appointments.controllers.AbstractResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccessDTO extends AbstractResponse{

    private int id;
    private UserDTO user;
    private LocalDateTime accessTime;

}
