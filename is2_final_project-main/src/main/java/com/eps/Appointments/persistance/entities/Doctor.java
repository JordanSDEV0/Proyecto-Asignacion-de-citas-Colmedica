package com.eps.Appointments.persistance.entities;

import java.io.Serializable;
import java.util.List;

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
    @OneToOne
    @MapsId
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Headquarter headquarter;
    @ManyToMany
    @JoinTable(name = "doctor_specialization")
    private List<Specialization> specialization;
    
}
