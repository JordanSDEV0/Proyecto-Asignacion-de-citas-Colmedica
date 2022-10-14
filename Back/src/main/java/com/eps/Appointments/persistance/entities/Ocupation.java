package com.eps.Appointments.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
  *  Se tiene la clase Ocupation la cual asiganara cada una de esta dependiendo de sus caracteristicas
   * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data

public class Ocupation {
/**
 * 
 * Se define los atributos para poder generar la ocupacion dependiendo de su ID y Ocupation
  */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String ocupation;
    
}
