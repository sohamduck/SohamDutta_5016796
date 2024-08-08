package com.employeemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DepartmentDTO {
    private String name;
    private int employeeCount;
}
