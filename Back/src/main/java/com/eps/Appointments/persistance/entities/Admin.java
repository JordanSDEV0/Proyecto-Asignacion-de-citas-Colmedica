package com.eps.Appointments.persistance.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Se tien la clase admin la cual sera la que manejara todo
 * @author:Sofware Bosque S.A
 */
@Entity(name = "eps_admin")
@NoArgsConstructor
@Data
public class Admin implements Serializable{
/**
* Se crea sus atributos de los admin para que puedan ingresar por medio sus datos
 */
    @Id
    @Column(name = "eps_user")
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "eps_user")
    private User user;
    @Column(nullable = false)
    private String password;
    
}
