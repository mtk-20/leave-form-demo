package com.example.leave_form_demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emp_tbl")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name required!")
    private String name;

    @NotNull(message = "Date of birth required!")
    private LocalDate dob;

    @NotBlank(message = "NRC required!")
    private String nrc;

    @NotBlank(message = "Title required!")
    private String title;

    @NotNull(message = "Department required!")
    @Enumerated(EnumType.STRING)
    private Department department;

    @Pattern(regexp = "^09\\d{9}$", message = "eg: 09123123123")
    private String phone;

    @Email(message = "Invalid email!")
    private String email;

    @NotBlank(message = "Address required!")
    private String address;

    public enum Department {
        ITC, DIG, SMD
    }

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeDetails> details = new ArrayList<>();

}
