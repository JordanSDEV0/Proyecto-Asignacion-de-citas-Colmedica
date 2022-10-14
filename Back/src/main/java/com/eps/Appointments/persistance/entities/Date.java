/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.entities;
/**
* Imports of time
*/
import java.time.LocalDate;
import java.time.LocalDateTime;
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
/**
* Imports of lombok.data
*/
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * The date class is created which will have all the characteristics of it
 * @entity The Entity Framework allows developers to work with data in the form of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data
 * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class Date {
/**
 * The attributes of the data are defined and some others are called and each one is of type private
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
    /** 
    * Private attribute of LocalDateTime type with name initialTime
    **/
    private LocalDateTime initialTime;
    @Column(name = "final_hour")
    /** 
    * Private attribute of LocalDateTime type with name finalTime
    **/
    private LocalDateTime finalTime;
    /** 
    * Private attribute of LocalDate type with name date
    **/
    private LocalDate date;
    /** 
    * Private attribute of String type with name status
    **/
    private String status;
    
}
