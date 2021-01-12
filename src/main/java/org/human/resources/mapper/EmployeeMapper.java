package org.human.resources.mapper;

import org.human.resources.dto.EmployeeDto;
import org.human.resources.domain.hr.employee.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toDto(Employee employee);

    @InheritInverseConfiguration
    Employee fromDto(EmployeeDto dto);


}
