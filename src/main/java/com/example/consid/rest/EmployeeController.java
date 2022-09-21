package com.example.consid.rest;

import com.example.consid.models.dto.creation.EmployeeCreationDto;
import com.example.consid.models.dto.response.EmployeeDto;
import com.example.consid.models.dto.update.EmployeeUpdateDto;
import com.example.consid.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Find all employees
     *
     * @return employee dto
     */
    @GetMapping("/all")
    public List<EmployeeDto> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    /**
     * Find employee by id
     *
     * @param id category id
     * @return employee dto
     */
    @GetMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDto findEmployeeById(@RequestParam String id) {
        return employeeService.findEmployeeById(id);
    }

    /**
     * Create a employee
     *
     * @param creationDto dto
     * @return employee dto
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDto createEmployee(@RequestBody EmployeeCreationDto creationDto) {
        return employeeService.createEmployee(creationDto);
    }

    /**
     * Update a employee
     *
     * @param employeeId        id of employee to update
     * @param employeeUpdateDto dto containing fields that will be updated
     * @return employee dto
     */
    @PutMapping(params = "/{employee_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDto updateEmployeeById(@PathVariable(name = "employee_id") String employeeId, @RequestBody EmployeeUpdateDto employeeUpdateDto) {
        return employeeService.updateEmployeeById(employeeId, employeeUpdateDto);
    }

    /**
     * Delete a employee
     *
     * @param employeeId id of employee to delete
     */
    @DeleteMapping(path = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

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
