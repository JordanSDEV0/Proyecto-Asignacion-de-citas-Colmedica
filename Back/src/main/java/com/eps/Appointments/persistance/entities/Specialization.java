package com.eps.Appointments.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author: 
 */
@Entity
@NoArgsConstructor
@Data
/**
 *Esta clase se encarga de manejar la asignacion de especialidad segun el id y la description
 */
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    
}
