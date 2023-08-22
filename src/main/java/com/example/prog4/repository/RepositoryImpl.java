package com.example.prog4.repository;

import com.example.prog4.repository.cnaps.EmployeeCnapsRepository;
import com.example.prog4.repository.cnaps.entity.EmployeeCnaps;
import com.example.prog4.repository.employee.EmployeeRepository;
import com.example.prog4.repository.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;

public class RepositoryImpl implements Repository, com.example.prog4.repository.Repository {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCnapsRepository cnapsRepository;

    @Override
    public Employee save(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public EmployeeCnaps save(EmployeeCnaps entity) {
        return cnapsRepository.save(entity);
    }
}
