/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.entities;

/**
* Imports of time
*/
import java.time.LocalDateTime;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* Imports of lombok.data
*/
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * There is the Access class which will be used to access the eps
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
public class Access {
    /**
     * The attributes are defined with their respective type to be able to easily
     * access the eps
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * Private attribute of numeric type with name id
     **/
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "eps_user", nullable = false)
    /**
     * Private attribute of user type with name user
     **/
    private User user;
    @Column(name = "access_time")
    @Temporal(TemporalType.TIMESTAMP)
    /**
     * Private attribute of LocalDateTime type with name accessTime
     **/
    private Date accessTime;

}
