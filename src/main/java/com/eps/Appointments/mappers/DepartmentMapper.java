package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.DepartmentDTO;
import com.eps.Appointments.persistance.entities.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "department", target = "department")
    DepartmentDTO toDepartmentDto (Department department);

    @InheritInverseConfiguration
    Department toDepartment (DepartmentDTO departmentDTO);
}
