package com.example.leave_form_demo.service;

import com.example.leave_form_demo.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto dto);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> findByName(String name);

    EmployeeDto updateEmployee(Long id, EmployeeDto dto);

    void deleteEmployee(Long id);

}
