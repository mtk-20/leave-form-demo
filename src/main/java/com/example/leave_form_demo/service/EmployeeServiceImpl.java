package com.example.leave_form_demo.service;

import com.example.leave_form_demo.dto.EmployeeDto;
import com.example.leave_form_demo.entity.Employee;
import com.example.leave_form_demo.exceptions.EmployeeNotFoundException;
import com.example.leave_form_demo.mapper.EmployeeMapper;
import com.example.leave_form_demo.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo repo;
    private final EmployeeMapper mapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {
        Employee emp = repo.save(mapper.toEmpEntity(dto));
        return mapper.toEmpDto(emp);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        return repo.findAll().stream().map(mapper::toEmpDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee emp = repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        return mapper.toEmpDto(emp);
    }

    @Override
    public List<EmployeeDto> findByName(String name) {
        return repo.findByNameContainingIgnoreCase(name)
                .stream()
                .map(mapper::toEmpDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        emp.setName(dto.getName());
        emp.setDob(dto.getDob());
        emp.setNrc(dto.getNrc());
        emp.setTitle(dto.getTitle());
        emp.setDepartment(Employee.Department.valueOf(dto.getDepartment()));
        emp.setPhone(dto.getPhone());
        emp.setEmail(dto.getEmail());
        emp.setAddress(dto.getAddress());

        emp.getDetails().clear();
        emp.getDetails().addAll(dto.getDetails().stream()
                .map(d -> mapper.toEmpDetailsEntity(d, emp))
                .collect(Collectors.toList()));
        return mapper.toEmpDto(repo.save(emp));
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!repo.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        repo.deleteById(id);
    }
}
