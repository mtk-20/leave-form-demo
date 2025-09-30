package com.example.leave_form_demo.repo;

import com.example.leave_form_demo.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Long> {
}
