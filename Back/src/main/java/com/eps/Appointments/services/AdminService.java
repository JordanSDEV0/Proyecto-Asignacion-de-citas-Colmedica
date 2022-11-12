/**
* Package with which the services of the appointments access
**/
package com.eps.Appointments.services;

/**
* Imports of java util
*/
import java.util.List;
/**
* Imports of transaction
*/
import javax.transaction.Transactional;
/**
* Imports of springframework
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.AdminDTO;
import com.eps.Appointments.mappers.AdminMapper;
import com.eps.Appointments.mappers.UserMapper;
import com.eps.Appointments.persistance.entities.Admin;
import com.eps.Appointments.persistance.entities.User;
import com.eps.Appointments.persistance.repositories.AdminRepository;

/**
 * Creation of the public class AdminService
 * 
 * @Service It is used to mark the class as a service provider
 **/
@Service
public class AdminService {
    /**
     * annotation that allows to inject some dependencies with others inside Spring
     **/
    @Autowired
    /**
     * Private attribute of type AdminRepository of name adminRepository
     **/
    private AdminRepository adminRepository;
    @Autowired
    /**
     * Private attribute of type AdminMapper of name adminMapper
     **/
    private AdminMapper adminMapper;
    @Autowired
    /**
     * Private attribute of type UserService of name userService
     **/
    private UserService userService;
    @Autowired
    /**
     * Private attribute of type UserMapper of name userMapper
     **/
    private UserMapper userMapper;

    /**
     * class creation AdminDTO with attributes adminDTO and exception
     * IllegalArgumentException
     * 
     * @Transactional annotation is the metadata that specifies the semantics of the
     *                transactions on a method
     **/
    @Transactional
    public AdminDTO create(AdminDTO adminDTO) throws IllegalArgumentException {
        if (userService.getById(adminDTO.getId()) == null) {
            User newUser = userMapper.toUser(
                    userService.create(userMapper.toUserDTO(new User(adminDTO.getId(), adminDTO.getPassword()))));
            if (newUser != null) {
                Admin newAdmin = adminMapper.toAdmin(adminDTO);
                newAdmin.setUser(newUser);
                return adminMapper.toAdminDTO(adminRepository.save(newAdmin));
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * creation of the class AdminDTO getById with id attributes
     **/
    public AdminDTO getById(String id) {
        return adminMapper.toAdminDTO(adminRepository.findById(id).map(admin -> {
            return admin;
        }).orElseGet(null));
    }

    /**
     * creation of the class List<AdminDTO> getAll
     **/
    public List<AdminDTO> getAll() {
        List<Admin> admin = (List<Admin>) adminRepository.findAll();
        return adminMapper.toAdminDTOs(admin);
    }

}
