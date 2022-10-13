package com.eps.Appointments.DTOs;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccessDTO{

    private int id;
    private UserDTO user;
    private LocalDateTime accessTime;

}
