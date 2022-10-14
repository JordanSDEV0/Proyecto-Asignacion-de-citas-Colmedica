package com.eps.Appointments.persistance.entities;

import java.time.LocalDate;
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
 * Se crea la clase date la cual tendra todas las caracteristicas de esta misma
 * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class Date {
/**
 * Se definen los atributos de los datos y se llaman algunos otros y cada uno es de tipo private
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "date_type", nullable = false)
    private DateType dateType;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Headquarter headquarter;
    private String description;
    @Column(name = "initial_hour", nullable = false)
    private LocalDateTime initialTime;
    @Column(name = "final_hour")
    private LocalDateTime finalTime;
    private LocalDate date;
    private String status;
    
}
