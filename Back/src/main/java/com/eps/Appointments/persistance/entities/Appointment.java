package com.eps.Appointments.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Se tiene la clase Appointment la cual son citas 
 * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class Appointment {
/**
 * Esta clase esta definida por el doctor, paciente y dato para poder saber todo acerca sobre la cita
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Date date;
    
}
