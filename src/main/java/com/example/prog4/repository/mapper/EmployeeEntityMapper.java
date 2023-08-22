package com.example.prog4.repository.mapper;

import com.example.prog4.repository.cnaps.entity.EmployeeCnaps;
import com.example.prog4.repository.employee.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEntityMapper {
  public Employee toDomain(EmployeeCnaps employeeCnaps, Employee employee) {
    employee.setCnaps(employeeCnaps.getCnaps());
    return employee;
  }
}
