package com.example.consid.services;

import com.example.consid.models.dto.creation.EmployeeCreationDto;
import com.example.consid.models.dto.response.EmployeeDto;
import com.example.consid.models.dto.update.EmployeeUpdateDto;
import com.example.consid.models.entities.Employee;
import com.example.consid.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository emloyeeRepository) {
        this.employeeRepository = emloyeeRepository;
    }

    /**
     * Converts dto to employee.
     *
     * @param creationDto contains required information to create an employee entity
     * @return employee entity
     */
    private static Employee toEntity(EmployeeCreationDto creationDto) {
        return Employee.builder()
                .FirstName(creationDto.getFirstName())
                .LastName(creationDto.getLastName())
                .Salary(creationDto.getSalary())
                .IsCEO(creationDto.getIsCEO())
                .IsManager(creationDto.getIsManager())
                .ManagerId(creationDto.getManagerId())
                .build();
    }

    /**
     * Converts employee to response dto
     *
     * @param employee employee to convert
     * @return response dto
     */
    private static EmployeeDto toDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .FirstName(employee.getFirstName())
                .LastName(employee.getLastName())
                .Salary(employee.getSalary())
                .IsCEO(employee.getIsCEO())
                .IsManager(employee.getIsManager())
                .ManagerId(employee.getManagerId())
                .build();
    }

    /**
     * Find all employees
     *
     * @return list of employees, each contained in an dto
     */
    public List<EmployeeDto> findAllEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeService::toDto).collect(Collectors.toList());
    }

    /**
     * Find employee by id.
     *
     * @param id employee id
     * @return dto containing
     */
    public EmployeeDto findEmployeeById(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return toDto(employee);
    }

    /**
     * Create employee
     *
     * @param creationDto dto with required fields
     * @return dto, including the id of the new entity
     */
    public EmployeeDto createEmployee(EmployeeCreationDto creationDto) {
        var employee = toEntity(creationDto);
        return toDto(employeeRepository.save(employee));
    }

    /**
     * Update employee
     *
     * @param employeeId        the id of the employee to update
     * @param employeeUpdateDto dto containing all required fields
     * @return dto of the employee resource
     */
    public EmployeeDto updateEmployeeById(String employeeId, EmployeeUpdateDto employeeUpdateDto) {
        return employeeRepository.findById(employeeId).map(employee -> {
            employee.setFirstName(employeeUpdateDto.getFirstName());
            employee.setLastName(employeeUpdateDto.getLastName());
            employee.setSalary(employeeUpdateDto.getSalary());
            employee.setIsManager(employeeUpdateDto.getIsManager());
            employee.setIsCEO(employeeUpdateDto.getIsCEO());
            employee.setManagerId(employeeUpdateDto.getManagerId());
            return toDto(employeeRepository.save(employee));
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    /**
     * Delete employee
     *
     * @param employeeId id of employee
     */
    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
