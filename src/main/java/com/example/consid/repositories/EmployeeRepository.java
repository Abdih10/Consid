package com.example.consid.repositories;

import com.example.consid.models.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    @Override
    List<Employee> findAll();
}
