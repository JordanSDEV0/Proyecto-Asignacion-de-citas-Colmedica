package com.eps.Appointments.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Admin implements Serializable{

    @Id
    @OneToOne
    @MapsId
    private User user;
    @Column(nullable = false)
    private String password;
    
}
