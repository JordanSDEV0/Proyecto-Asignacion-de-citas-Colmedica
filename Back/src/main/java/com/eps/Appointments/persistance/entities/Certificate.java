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
 * Se define la clase Certificate para darle los certificado a los usuarios de la eps
 * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class Certificate {
/**
 * Se define el paciente con su respectivo dato para poder ingresarlo y mas adelante darle el certificado
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "patient", nullable = false)
    private Patient patient;
    private String rute;
    private String type;
    
}
