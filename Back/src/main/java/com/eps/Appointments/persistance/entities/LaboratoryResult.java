/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.entities;
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
 * The LaboratoryResult class is created
 * @entity The Entity Framework allows developers to work with data in the form of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data
 * @author:Sofware Bosque S.A
 */
@Entity(name = "laboratory_result")
@NoArgsConstructor
@Data
public class LaboratoryResult {
/**
 * This class helps us to be able to identify the results of the laboratories and check if the file with the laboratories is already
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
    * Private attribute of Date type with name date
    **/
    private Date date;
    /** 
    * Private attribute of String type with name description
    **/
    private String description;
    @Column(name = "archive_rute")
    /** 
    * Private attribute of String type with name archiveRute
    **/
    private String archiveRute;
    
}
