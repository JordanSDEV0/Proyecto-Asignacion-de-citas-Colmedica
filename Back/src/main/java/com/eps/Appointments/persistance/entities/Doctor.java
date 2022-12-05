/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.entities;
/**
* Imports of java
*/
import java.io.Serializable;
import java.util.List;
/**
* Imports persistence
*/
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
/**
* Imports of lombok.data
*/
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * The doctor class is created to define its role in the eps
 * @entity The Entity Framework allows developers to work with data in the form of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data
 * @author:Sofware Bosque S.A
  */
@Entity
@NoArgsConstructor
@Data
public class Doctor implements Serializable{
/**
 * It has its attributes to know the doctor in which specialty he is and in which center he is attending
 */
    @Id
    @Column(name = "eps_user")
   /** 
    * Private attribute of String type with name id
    **/
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "eps_user")
    /** 
    * Private attribute of User type with name user
    **/
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    /** 
    * Private attribute of Headquarter type with name headquarter
    **/
    private Headquarter headquarter;
    @ManyToMany
    @JoinTable(name = "doctor_specialization")
    /** 
    * Private attribute of list Specialization type with name specialization
    **/
    private List<Specialization> specialization;
 /**
    * Private attribute of type string of name name doctor
    **/
    private String name_doctor;
    @Column(name = "last_name")
 /**
    * Private attribute of type string of name last name
    **/
    private String lastName;
  /**
    * Private attribute of type string of email 
    **/
    private String email;
  /**
    * Private attribute of type int of name phone
    **/
    private int phone;
    
}
