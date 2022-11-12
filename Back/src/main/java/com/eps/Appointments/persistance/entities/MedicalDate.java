/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.entities;

/**
* Imports of time
*/
import java.util.Date;

/**
* Imports persistence
*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* Imports of lombok.data
*/
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The date class is created which will have all the characteristics of it
 *
 * @entity The Entity Framework allows developers to work with data in the form
 *         of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data
 * @author:Software Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
@Table(name = "medical_date")
public class MedicalDate {
    /**
     * The attributes of the data are defined and some others are called and each
     * one is of type private
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * Private attribute of numeric type with name id
     **/
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "date_type", nullable = false)
    /**
     * Private attribute of DateType type with name dateType
     **/
    private DateType dateType;
    @ManyToOne
    @JoinColumn(nullable = false)
    /**
     * Private attribute of Headquarter type with name headquarter
     **/
    private Headquarter headquarter;
    /**
     * Private attribute of String type with name description
     **/
    private String description;
    @Column(name = "initial_hour", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    /**
     * Private attribute of LocalDateTime type with name initialTime
     **/
    private Date initialTime;
    @Column(name = "final_hour")
    @Temporal(TemporalType.TIMESTAMP)
    /**
     * Private attribute of LocalDateTime type with name finalTime
     **/
    private Date finalTime;
    @Temporal(TemporalType.DATE)
    /**
     * Private attribute of LocalDate type with name date
     **/
    private Date date;
    /**
     * Private attribute of String type with name status
     **/
    private String status;

}
