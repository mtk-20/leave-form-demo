package com.example.leave_form_demo.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailsDto {

    private Long id;
    private String leaveType;
    private LocalDate fromDate;
    private LocalDate toDate;
}
