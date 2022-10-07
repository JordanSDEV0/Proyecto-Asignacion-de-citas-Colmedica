package com.eps.Appointments.persistance.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Patient implements Serializable{

    @Id
    @Column(name = "eps_user")
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "eps_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_type", nullable = false)
    private IdType idType;
    @ManyToOne
    @JoinColumn(name = "headquarter", nullable = false)
    private Headquarter headquarter;
    @ManyToOne
    @JoinColumn(name = "ocupation", nullable = false)
    private Ocupation ocupation;
    @Column(name = "regiment_type")
    private String regimenType;
    @Column(length = 10)
    private String phone;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String genre;
    
}
