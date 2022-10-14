package com.eps.Appointments.persistance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Se crea la clase Headquarter la cual nos sirve para las cedes
 * @author:Sofware Bosque S.A
  */
@Entity
@NoArgsConstructor
@Data
public class Headquarter {
/**
 * Estos atributos nos serviran para saber si hay una cede en una ciudad y si llega a ser asi tambien le colocamos el nombre y dirreccion
  */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "city", nullable = false)
    private City city;
    @Column(unique = true)
    private String name;
    private String address;
    
}
