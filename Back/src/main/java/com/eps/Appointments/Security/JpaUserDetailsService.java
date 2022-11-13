package com.eps.Appointments.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eps.Appointments.persistance.repositories.AdminRepository;
import com.eps.Appointments.persistance.repositories.DoctorRepository;
import com.eps.Appointments.persistance.repositories.PatientRepository;
import com.eps.Appointments.persistance.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

   private UserRepository userRepository;
   private AdminRepository adminRepository;
   private PatientRepository patientRepository;
   private DoctorRepository doctorRepository;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return userRepository.findById(username).map(user -> {
         return adminRepository.findById(username).map(admin -> {
            return new UserSecurity(user, Roles.ADMIN.name());
         }).orElse(patientRepository.findById(username).map(patient -> {
            return new UserSecurity(user, Roles.PATIENT.name());
         }).orElse(doctorRepository.findById(username).map(doctor -> {
            return new UserSecurity(user, Roles.DOCTOR.name());
         }).orElseThrow(() -> {
            return new UsernameNotFoundException("Username not found " + username);
         })));
      }).orElseThrow(() -> {
         return new UsernameNotFoundException("Username not found " + username);
      });
   }

}
