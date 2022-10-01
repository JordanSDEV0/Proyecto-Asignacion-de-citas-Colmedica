package com.eps.Appointments.persistance.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "eps_admin")
@NoArgsConstructor
@Data
public class Admin implements Serializable{

    @Id
    @Column(name = "eps_user")
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "eps_user")
    private User user;
    @Column(nullable = false)
    private String password;
    
}
