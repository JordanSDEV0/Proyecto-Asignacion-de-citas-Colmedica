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
 * Se crea la clase LaboratoryResult
 * @author:Sofware Bosque S.A
 */
@Entity(name = "laboratory_result")
@NoArgsConstructor
@Data
public class LaboratoryResult {
/**
 * Esta clase nos sirve para poder idendificar los resultados de los laboratorios y comprobar si el archivo con los laboratorios ya esta
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Date date;
    private String description;
    @Column(name = "archive_rute")
    private String archiveRute;
    
}
