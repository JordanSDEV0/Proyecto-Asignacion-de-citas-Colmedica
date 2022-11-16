package com.eps.Appointments.services.Domains;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.eps.Appointments.persistance.entities.MedicalDate;
import com.eps.Appointments.persistance.repositories.DatetypeRepository;
import com.eps.Appointments.persistance.repositories.HeadquarterRepository;

@Service
public class MedicalDateService {

   private DatetypeRepository datetypeRepository;
   private HeadquarterRepository headquarterRepository;

   @Transactional
   public Optional<MedicalDate> create(int dateTypeId, int headquarterId, String description, Date initialHour,
         Date finalHour, Date appointmentDate) {
      return null;
   }

}
