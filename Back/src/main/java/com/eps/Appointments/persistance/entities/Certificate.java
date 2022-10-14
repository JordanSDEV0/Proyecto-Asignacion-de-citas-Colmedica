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
 * The Certificate class is defined to give the certificates to the users of the eps
 * @entity The Entity Framework allows developers to work with data in the form of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data
 * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class Certificate {
/**
 * The patient is defined with his respective data to be able to enter him and later give him the certificate
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /** 
    * Private attribute of numeric type with name id
    **/
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "patient", nullable = false)
    /** 
    * Private attribute of Patient type with name patient
    **/
    private Patient patient;
    /** 
    * Private attribute of String type with name rute
    **/
    private String rute;
    /** 
    * Private attribute of String type with name type
    **/
    private String type;
    
}
