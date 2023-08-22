package com.example.prog4.repository;

import com.example.prog4.repository.cnaps.entity.EmployeeCnaps;
import com.example.prog4.repository.employee.entity.Employee;

public interface Repository {
    Employee save(Employee entity);

    EmployeeCnaps save(EmployeeCnaps entity);
}
