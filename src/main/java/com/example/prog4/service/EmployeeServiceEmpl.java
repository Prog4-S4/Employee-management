package com.example.prog4.service;

import com.example.prog4.repository.cnaps.EmployeeCnapsRepository;
import com.example.prog4.repository.cnaps.entity.EmployeeCnaps;
import com.example.prog4.repository.employee.EmployeeRepository;
import com.example.prog4.repository.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceEmpl  {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCnapsRepository cnapsRepository;

    public Employee getEmployeeInfo(String employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (employee != null) {
            EmployeeCnaps cnaps = cnapsRepository.findById(employee.getCnaps()).orElse(null);

            if (cnaps != null) {
                // Update the CNAPS number if it has changed
                if (!employee.getCnaps().equals(cnaps.getCnaps())) {
                    employee.setCnaps(cnaps.getCnaps());
                    employeeRepository.save(employee);
                }
            }
        }

        return employee;
    }
}
