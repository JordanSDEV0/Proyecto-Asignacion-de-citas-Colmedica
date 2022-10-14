package com.eps.Appointments.persistance.entities;

import java.time.LocalDateTime;

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
 * Se tiene la clase Access la cual va a servir para acceder a la eps
 * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class Access {
/**
 *Se define los atributos con su respectivo tipo para poder acceder tranquilamente a la eps
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "eps_user", nullable = false)    
    private User user;
    @Column(name = "access_time")
    private LocalDateTime accessTime;

}
