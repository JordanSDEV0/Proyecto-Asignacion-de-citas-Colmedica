/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.entities;
/**
* Imports persistence
*/
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
 * Se tiene la clase Appointment la cual son citas 
 * @entity The Entity Framework allows developers to work with data in the form of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data
 * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class Appointment {
/**
 * This class is defined by the doctor, patient and data to be able to know everything about the appointment
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
    * Private attribute of numeric type with name id
    **/
    private Integer id;
    @ManyToOne
    @JoinColumn(nullable = false)
    /**
    * Private attribute of doctor type with name Doctor
    **/
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(nullable = false)
    /**
    * Private attribute of Patient type with name patient
    **/
    private Patient patient;
    @ManyToOne
    @JoinColumn(nullable = false)
    /**
    * Private attribute of Date type with name date
    **/
    private Date date;

}
