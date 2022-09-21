package com.example.consid.rest;

import com.example.consid.models.entities.Employee;
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

    /**
     * Create, update and delete employees
     */

    /**
     * Say the employee should be a manager or even a CEO
     */

    /**
     * Only one CEO can be created at a time in the application database
     */

    /**
     * The salary should be calculated when creating the employee using the logic described in the task
     */

    /**
     * You should not be able to delete a manger or CEO that is managing another employee
     */
    /**
     * CEO can manage managers but not employees
     */

    /**
     *  Managers can manage other managers and employees
     */

    /**
     * No one can manage the CEO
     */

    /**
     * Validation on input fields
     *
     */
}
