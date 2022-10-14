package com.eps.Appointments.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Se crea la clase IdType para tener cada tipo de ID
 * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class IdType {
/**
 * Se definen sus atributos que son id y type con sus respectivos tipos que son private 
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;
    
}
