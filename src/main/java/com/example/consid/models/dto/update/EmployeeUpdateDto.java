package com.example.consid.models.dto.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeUpdateDto {
    private String FirstName;
    private String LastName;
    private BigDecimal Salary;
    private long IsCEO;
    private long IsManager;
    private Integer ManagerId;
}
