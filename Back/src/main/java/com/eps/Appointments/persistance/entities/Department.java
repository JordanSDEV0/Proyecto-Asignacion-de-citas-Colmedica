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
 * The Department class is created to know where it is located
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
public class Department {
    /**
     * We create its attributes with their respective id and department with their
     * respective types that are private
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * Private attribute of numeric type with name id
     **/
    private Integer id;
    /**
     * Private attribute of String type with name department
     **/
    private String department;

}
