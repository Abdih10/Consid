package com.example.consid.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class EmployeeDto {
    private String id;
    private String FirstName;
    private String LastName;
    private BigDecimal Salary;
    private long IsCEO;
    private long IsManager;
    private Integer ManagerId;

}
