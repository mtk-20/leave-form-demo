package com.example.leave_form_demo.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private LocalDate dob;
    private String nrc;
    private String title;
    private String department;
    private String phone;
    private String email;
    private String address;

    private List<EmployeeDetailsDto> details = new ArrayList<>();
}
