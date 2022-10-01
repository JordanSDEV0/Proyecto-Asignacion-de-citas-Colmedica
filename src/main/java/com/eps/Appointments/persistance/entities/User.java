package com.eps.Appointments.persistance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "eps_user")
@NoArgsConstructor
@Data
public class User {

    @Id
    private String id;
    @Column(nullable = false)
    private String password;
    
}
