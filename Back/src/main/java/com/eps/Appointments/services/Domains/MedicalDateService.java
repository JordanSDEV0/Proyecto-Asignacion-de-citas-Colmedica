package com.eps.Appointments.services.Domains;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.eps.Appointments.persistance.entities.MedicalDate;
import com.eps.Appointments.persistance.repositories.MedicalDateRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicalDateService {

   private final MedicalDateRepository medicalDateRepository;

   @Transactional
   public MedicalDate create(MedicalDate medicalDateDTO) {
      return medicalDateRepository.save(medicalDateDTO);
   }

   public List<MedicalDate> getAll() {
      return (List<MedicalDate>) medicalDateRepository.findAll();
   }

}
