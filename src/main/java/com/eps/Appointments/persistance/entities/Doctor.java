package com.eps.Appointments.persistance.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Doctor implements Serializable{

    @Id
    @Column(name = "eps_user")
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "eps_user")
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Headquarter headquarter;
    @ManyToMany
    @JoinTable(name = "doctor_specialization")
    private List<Specialization> specialization;
    
}
