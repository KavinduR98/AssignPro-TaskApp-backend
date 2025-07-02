package com.ushan.employeeService.dto;

public class EmployeeRequestDTO {
    private String name;
    private String department;
    private String email;

    public EmployeeRequestDTO(String department, String email, String name) {
        this.department = department;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
