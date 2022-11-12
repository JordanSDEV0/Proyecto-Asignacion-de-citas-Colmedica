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
 * The Headquarter class is created which serves us for the cedes
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
public class Headquarter {
  /**
   * These attributes will help us to know if there is a cede in a city and if it
   * becomes so, we will also put the name and address
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  /**
   * Private attribute of numeric type with name id
   **/
  private Integer id;
  @ManyToOne
  @JoinColumn(name = "city", nullable = false)
  /**
   * Private attribute of City type with name city
   **/
  private City city;
  @Column(unique = true)
  /**
   * Private attribute of String type with name name
   **/
  private String name;
  /**
   * Private attribute of String type with name address
   **/
  private String address;

}
