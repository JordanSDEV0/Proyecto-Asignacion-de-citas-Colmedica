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

@Entity(name = "laboratory_result")
@NoArgsConstructor
@Data
public class LaboratoryResult {

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
