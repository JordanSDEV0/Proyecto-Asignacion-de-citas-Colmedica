/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.entities;
/**
* Imports of java
*/
import java.io.Serializable;
import java.time.LocalDate;
/**
* Imports persistence
*/
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
/**
* Imports of lombok.data
*/
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This class will define the necessary attributes for the patients
 * @entity The Entity Framework allows developers to work with data in the form of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data
 */
@Entity
@NoArgsConstructor
@Data
public class Patient implements Serializable{
/**
 * The attributes of each user are defined with their respective private type
 * @author:Sofware Bosque S.A
 */
    @Id
    @Column(name = "eps_user")
    /** 
    * Private attribute of numeric type with name id
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
    @JoinColumn(name = "id_type", nullable = false)
    /** 
    * Private attribute of IdType type with name idType
    **/
    private IdType idType;
    @ManyToOne
    @JoinColumn(name = "headquarter", nullable = false)
    /** 
    * Private attribute of Headquarter type with name headquarter
    **/
    private Headquarter headquarter;
    @ManyToOne
    @JoinColumn(name = "ocupation", nullable = false)
    /** 
    * Private attribute of Ocupation type with name ocupation
    **/
    private Ocupation ocupation;
    @Column(name = "regiment_type")
    /** 
    * Private attribute of String type with name regimenType
    **/
    private String regimenType;
    @Column(length = 10)
    /** 
    * Private attribute of String type with name phone
    **/
    private String phone;
    /** 
    * Private attribute of String type with name name
    **/
    private String name;
    @Column(name = "last_name")
    /** 
    * Private attribute of String type with name lastName
    **/
    private String lastName;
    /** 
    * Private attribute of String type with name address
    **/
    private String address;
    @Column(nullable = false, unique = true)
    /** 
    * Private attribute of String type with name email
    **/
    private String email;
    @Column(name = "birth_date")
    /** 
    * Private attribute of LocalDate type with name birthDate
    **/
    private LocalDate birthDate;
    /** 
    * Private attribute of String type with name genre
    **/
    private String genre;
    
}
