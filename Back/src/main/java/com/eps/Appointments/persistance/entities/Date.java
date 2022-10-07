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

@Entity
@NoArgsConstructor
@Data
public class Date {

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
