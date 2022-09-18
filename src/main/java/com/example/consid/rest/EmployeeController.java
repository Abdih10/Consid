package com.example.consid.rest;

import com.example.consid.models.Employee;
import com.example.consid.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public Iterable<Employee> all() {
        return employeeService.findALl();
    }

    @GetMapping
    public Employee employeeId(@RequestParam String id) {
        return employeeService.findbyID(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee newEMployee) {
        return employeeService.addEmployee(newEMployee);
    }
}
