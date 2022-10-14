/**
* Package with which the persistence of the mappers is accessed
**/
package com.eps.Appointments.mappers;
/**
* Imports of mapstruct
*/
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.DepartmentDTO;
import com.eps.Appointments.persistance.entities.Department;
/**
* public name interface DepartmentMapper
* @mapper geographic information system (GIS)
**/
@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "department", target = "department")
    DepartmentDTO toDepartmentDTO (Department department);

    @InheritInverseConfiguration
    Department toDepartment (DepartmentDTO departmentDTO);
}
