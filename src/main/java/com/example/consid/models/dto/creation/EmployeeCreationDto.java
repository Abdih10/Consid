package com.example.consid.models.dto.creation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
public class EmployeeCreationDto {
    private String FirstName;
    private String LastName;
    private BigDecimal Salary;
    private long IsCEO;
    private long IsManager;
    private Integer ManagerId;
}
