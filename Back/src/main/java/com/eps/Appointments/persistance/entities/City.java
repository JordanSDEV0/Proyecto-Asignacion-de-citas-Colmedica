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
 * Se define la clase city para saber las ubicaciones de los centros
 * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class City {
/**
 * Se define las ciudades con su departamento id y ciudad esto quiere decir que nos mostrara el departamiento y ciudad en donde este el centro 
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "department", nullable = false)
    private Department department;
    private String city;
    
}
