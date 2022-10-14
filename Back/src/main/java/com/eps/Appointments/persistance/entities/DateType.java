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
/**
* Imports of lombok.data
*/
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * DateType class is created
 * @entity The Entity Framework allows developers to work with data in the form of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data 
 * @author:Sofware Bosque S.A
 */
@Entity(name = "date_type")
@NoArgsConstructor
@Data
public class DateType {
/**
 * Attributes are generated as id and description with their respective type
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     /** 
    * Private attribute of numeric type with name id
    **/
    private Integer id;
     /** 
    * Private attribute of numeric type with name id
    **/
    private String description;
    
}
