package com.eps.Appointments.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.DTOs.AdminDTO;
import com.eps.Appointments.mappers.AdminMapper;
import com.eps.Appointments.persistance.entities.Admin;
import com.eps.Appointments.persistance.entities.User;
import com.eps.Appointments.persistance.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserService userService;

    @Transactional
    public AdminDTO create(AdminDTO adminDTO) throws IllegalArgumentException{
        if(userService.getUser(adminDTO.getId()) == null){
            User newUser= userService.create(new User(adminDTO.getId(), adminDTO.getPassword()));
            if(newUser != null){
                Admin newAdmin= adminMapper.toAdmin(adminDTO);
                newAdmin.setUser(newUser);
                return adminMapper.toAdminDTO(adminRepository.save(newAdmin));
            }
            return null;
        }else{
            return null;
        }
    }

    public AdminDTO getById(String id){
        return adminMapper.toAdminDTO(adminRepository.findById(id).map(admin -> {
            return admin;
        }).orElseGet(null));
    }

    public List<AdminDTO> getAll(){
        List<Admin> admin= (List<Admin>) adminRepository.findAll();
        return adminMapper.toAdminDTOs(admin);
    }

}
