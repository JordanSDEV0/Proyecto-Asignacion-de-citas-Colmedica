package com.eps.Appointments.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eps.Appointments.DTOs.AdminDTO;
import com.eps.Appointments.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    private ResponseEntity<AdminDTO> create(@RequestBody AdminDTO admin){
        try {
            return new ResponseEntity<AdminDTO>(adminService.create(admin), HttpStatus.CREATED);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
