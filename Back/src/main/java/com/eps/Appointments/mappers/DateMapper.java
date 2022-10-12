package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.DateDTO;
import com.eps.Appointments.persistance.entities.Date;
import com.eps.Appointments.persistance.entities.DateType;
import com.eps.Appointments.persistance.entities.Headquarter;

@Mapper(componentModel = "spring", uses = {DateTypeMapper.class, HeadquarterMapper.class})
public interface DateMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dateType", target = "dateTypeId")
    @Mapping(source = "headquarter", target = "headquarterId")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "initialTime", target = "initialTime")
    @Mapping(source = "finalTime", target = "finalTime")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "status", target = "status")
    DateDTO toDateDto (Date date);

    default int mapDateType(DateType dateType){
        return dateType.getId();
    }
    
    default int mapHeadquarter(Headquarter headquarter){
        return headquarter.getId();
    }

    default Headquarter mapHeadquarter(int id){
        Headquarter headquarter= new Headquarter();
        headquarter.setId(id);
        return headquarter;
    }

    default DateType mapDateType(int id){
        DateType dateType= new DateType();
        dateType.setId(id);
        return dateType;
    }

    @InheritInverseConfiguration
    abstract Date toDate (DateDTO dateDTO);
    
}
