/**
* Package with which the persistence of the mappers is accessed
**/
package com.eps.Appointments.mappers;

/**
* Imports of mapstruct
*/
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.SchedulingDTO;
import com.eps.Appointments.DTOs.MedicalDateDTO;
import com.eps.Appointments.DTOs.AppointmentDTO;

/**
 * public name interface SchedulingMapper
 * 
 * @mapper geographic information system (GIS)
 **/
// @Mapper(componentModel = "spring")
public interface SchedulingMapper {

    @Mapping(source = "dateTypeId", target = "dateTypeId")
    @Mapping(source = "headquarterId", target = "headquarterId")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "initialTime", target = "initialTime")
    @Mapping(source = "finalTime", target = "finalTime")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "status", target = "status")
    MedicalDateDTO toDateDto(SchedulingDTO scheduling);

    @Mapping(source = "doctorId", target = "doctorId")
    @Mapping(source = "patientId", target = "patientId")
    @Mapping(source = "dateId", target = "dateId")
    AppointmentDTO toAppointmentDTO(SchedulingDTO scheduling);

}
