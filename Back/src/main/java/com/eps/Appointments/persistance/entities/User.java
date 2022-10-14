package com.eps.Appointments.persistance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Desde esta clase se podra acceder a los user
 * @author: 
 *
 */
@Entity(name = "eps_user")
@NoArgsConstructor
@Data
@AllArgsConstructor
/**
 *Esta clase sera user y estara con atributos de tipo privado con su respectivo Id y password para poder acceder
 */
public class User {

    @Id
    private String id;
    @Column(nullable = false)
    private String password;
    
}
