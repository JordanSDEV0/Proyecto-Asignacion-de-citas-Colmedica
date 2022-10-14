package com.eps.Appointments.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Se crea la clase DateType
 * @author:Sofware Bosque S.A
 */
@Entity(name = "date_type")
@NoArgsConstructor
@Data
public class DateType {
/**
 * Se generan los atributos como id y description con sus respectivo tipo
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;
    
}
