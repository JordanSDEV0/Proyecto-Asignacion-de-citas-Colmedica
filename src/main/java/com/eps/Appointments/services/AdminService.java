package com.eps.Appointments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.DTOs.AdminDTO;
import com.eps.Appointments.mappers.AdminMapper;
import com.eps.Appointments.persistance.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserService userService;

    public AdminDTO create(AdminDTO adminDTO) throws IllegalArgumentException{
        if(true){//userService.getUser(adminDTO.getId()) != null){
            return adminMapper.toAdminDTO(adminRepository.save(adminMapper.toAdmin(adminDTO)));
        }else{
            return null;
        }
    }
    
}
