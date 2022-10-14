package com.eps.Appointments.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Se crea la clase Departament para saber en donde se encuentra ubicado
 * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class Department {
/**
 * Creamos sus atributos con su respectivo id y department con sus respectivos tipos que son private
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String department;
    
}
