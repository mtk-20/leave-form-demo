package com.example.leave_form_demo.mapper;

import com.example.leave_form_demo.dto.EmployeeDetailsDto;
import com.example.leave_form_demo.dto.EmployeeDto;
import com.example.leave_form_demo.entity.Employee;
import com.example.leave_form_demo.entity.EmployeeDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public Employee toEmpEntity(EmployeeDto dto) {
        Employee emp = new Employee();

        emp.setId(dto.getId());
        emp.setName(dto.getName());
        emp.setDob(dto.getDob());
        emp.setNrc(dto.getNrc());
        emp.setTitle(dto.getTitle());
        emp.setDepartment(Employee.Department.valueOf(dto.getDepartment()));
        emp.setPhone(dto.getPhone());
        emp.setEmail(dto.getEmail());
        emp.setAddress(dto.getAddress());
        List<EmployeeDetails> details = dto.getDetails()
                .stream()
                .map(d -> toEmpDetailsEntity(d, emp))
                .collect(Collectors.toList());
        emp.setDetails(details);

        return emp;
    }

    public EmployeeDto toEmpDto(Employee emp) {
        EmployeeDto dto = new EmployeeDto();

        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setDob(emp.getDob());
        dto.setNrc(emp.getNrc());
        dto.setTitle(emp.getTitle());
        dto.setDepartment(emp.getDepartment().name());
        dto.setPhone(emp.getPhone());
        dto.setEmail(emp.getEmail());
        dto.setAddress(emp.getAddress());
        List<EmployeeDetailsDto> details = emp.getDetails()
                .stream()
                .map(this::toEmpDetailsDto)
                .collect(Collectors.toList());
        dto.setDetails(details);

        return dto;
    }

    public EmployeeDetails toEmpDetailsEntity(EmployeeDetailsDto dto, Employee emp) {
        EmployeeDetails details = new EmployeeDetails();

        details.setId(dto.getId());
        details.setLeaveType(EmployeeDetails.LeaveType.valueOf(dto.getLeaveType()));
        details.setFromDate(dto.getFromDate());
        details.setToDate(dto.getToDate());
        details.setEmployee(emp);

        return details;
    }

    public EmployeeDetailsDto toEmpDetailsDto(EmployeeDetails details) {
        EmployeeDetailsDto dto = new EmployeeDetailsDto();

        dto.setId(details.getId());
        dto.setLeaveType(details.getLeaveType().name());
        dto.setFromDate(details.getFromDate());
        dto.setToDate(details.getToDate());

        return dto;
    }
}
