package com.eps.Appointments.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.MedicalDateDTO;
import com.eps.Appointments.persistance.entities.DateType;
import com.eps.Appointments.persistance.entities.Headquarter;
import com.eps.Appointments.persistance.entities.MedicalDate;

@Mapper(componentModel = "spring")
public abstract class MedicalDateMapper {

   @Mapping(source = "dateTypeId", target = "dateType")
   @Mapping(source = "headquarterId", target = "headquarter")
   public abstract MedicalDate toEntity(MedicalDateDTO dto);

   DateType mapDateType(int id) {
      DateType dateType = new DateType();
      dateType.setId(id);
      return dateType;
   }

   Headquarter mapHeadquarter(int id) {
      Headquarter headquarter = new Headquarter();
      headquarter.setId(id);
      return headquarter;
   }

}
