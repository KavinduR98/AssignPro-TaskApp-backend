package com.ushan.employeeService.mapper;

import com.ushan.employeeService.dto.EmployeeRequestDTO;
import com.ushan.employeeService.dto.EmployeeResponseDTO;
import com.ushan.employeeService.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequestDTO dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setDepartment(dto.getDepartment());
        emp.setEmail(dto.getEmail());
        return emp;
    }

    public EmployeeResponseDTO toDTO(Employee emp) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setDepartment(emp.getDepartment());
        dto.setEmail(emp.getEmail());
        return dto;
    }
}
