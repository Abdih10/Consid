package com.example.consid.services;

import com.example.consid.models.entities.Employee;
import com.example.consid.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository emloyeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository emloyeeRepository) {
        this.emloyeeRepository = emloyeeRepository;
    }

    public List<Employee> findALl() {
        return (List<Employee>) emloyeeRepository.findAll();
    }

    public Employee findbyID(String id) {
        return emloyeeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return emloyeeRepository.save(newEmployee);
    }
}
