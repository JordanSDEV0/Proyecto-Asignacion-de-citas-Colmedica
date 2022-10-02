package com.eps.Appointments.DTOs;

import java.time.LocalDateTime;

import com.eps.Appointments.persistance.entities.User;
import lombok.Data;

@Data
public class AccessDTO {
    private Integer id;
    private User user;
    private LocalDateTime accessTime;

}
