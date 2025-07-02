package com.ushan.employeeService.service;

import com.ushan.employeeService.dto.EmployeeRequestDTO;
import com.ushan.employeeService.dto.EmployeeResponseDTO;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    EmployeeResponseDTO create(EmployeeRequestDTO dto);
    EmployeeResponseDTO getById(UUID id);
    List<EmployeeResponseDTO> getAll();
    void delete(UUID id);
}
