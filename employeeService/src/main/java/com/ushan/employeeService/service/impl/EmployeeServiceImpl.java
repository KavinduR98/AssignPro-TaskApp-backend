package com.ushan.employeeService.service.impl;

import com.ushan.employeeService.dto.EmployeeRequestDTO;
import com.ushan.employeeService.dto.EmployeeResponseDTO;
import com.ushan.employeeService.entity.Employee;
import com.ushan.employeeService.exception.ResourceNotFoundException;
import com.ushan.employeeService.mapper.EmployeeMapper;
import com.ushan.employeeService.repository.EmployeeRepository;
import com.ushan.employeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public EmployeeResponseDTO create(EmployeeRequestDTO dto) {
        Employee emp = mapper.toEntity(dto);
        return mapper
                .toDTO(repo.save(emp));
    }

    @Override
    public EmployeeResponseDTO getById(UUID id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    @Override
    public List<EmployeeResponseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        repo.deleteById(id);
    }

}
