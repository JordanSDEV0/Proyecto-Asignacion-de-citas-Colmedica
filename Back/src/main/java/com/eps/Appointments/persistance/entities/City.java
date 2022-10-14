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
 * The city class is defined to know the locations of the centers
 * @entity The Entity Framework allows developers to work with data in the form of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data
 * @author:Sofware Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class City {
/**
 * The cities are defined with their department id and city, this means that it will show us the department and city where the center is.
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     /** 
    * Private attribute of numeric type with name id
    **/
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "department", nullable = false)
     /** 
    * Private attribute of Department type with name department
    **/
    private Department department;
     /** 
    * Private attribute of String type with name city
    **/
    private String city;
    
}
