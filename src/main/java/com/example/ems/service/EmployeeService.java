package com.example.ems.service;

import com.example.ems.entity.Employee;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}