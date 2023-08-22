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

  public EmployeeCnaps toDomain(Employee employee) {
    return EmployeeCnaps.builder()
        .cin(employee.getCin())
        .cnaps(employee.getCnaps())
        .image(employee.getImage())
        .address(employee.getAddress())
        .lastName(employee.getLastName())
        .firstName(employee.getFirstName())
        .personalEmail(employee.getPersonalEmail())
        .professionalEmail(employee.getProfessionalEmail())
        .registrationNumber(employee.getRegistrationNumber())
        .birthDate(employee.getBirthDate())
        .entranceDate(employee.getEntranceDate())
        .departureDate(employee.getDepartureDate())
        .childrenNumber(employee.getChildrenNumber())
        .sex(employee.getSex())
        .csp(employee.getCsp())
        .endToEndId(employee.getId())
        .build();
  }

}
