package com.example.leave_form_demo.repo;

import com.example.leave_form_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContainingIgnoreCase(String name);
}
