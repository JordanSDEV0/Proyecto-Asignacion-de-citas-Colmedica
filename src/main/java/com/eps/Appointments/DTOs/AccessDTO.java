package com.eps.Appointments.DTOs;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AccessDTO {

    private int id;
    private UserDTO user;
    private LocalDateTime accessTime;

}
