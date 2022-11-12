/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.entities;

/**
* Imports of java
*/
import java.io.Serializable;
/**
* Imports persistence
*/
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
/**
* Imports of lombok.data
*/
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * There is the admin class which will be the one that will handle everything
 * 
 * @entity The Entity Framework allows developers to work with data in the form
 *         of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data
 * @author:Sofware Bosque S.A
 */
@Entity(name = "eps_admin")
@NoArgsConstructor
@Data
public class Admin implements Serializable {
    /**
     * Their admin attributes are created so that they can enter their data through
     */
    @Id
    @Column(name = "eps_user")
    /**
     * Private attribute of string type with name id
     **/
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "eps_user")
    /**
     * Private attribute of numeric type with name id
     **/
    private User user;

}
