package com.example.prog4.repository.implementation;

import com.example.prog4.controller.mapper.EmployeeMapper;
import com.example.prog4.model.Employee;
import com.example.prog4.model.exception.NotFoundException;
import com.example.prog4.repository.Repository;
import com.example.prog4.repository.cnaps.EmployeeCnapsRepository;
import com.example.prog4.repository.cnaps.entity.EmployeeCnaps;
import com.example.prog4.repository.employee.EmployeeRepository;
import com.example.prog4.repository.mapper.EmployeeEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RepositoryImpl implements Repository {
  private final EmployeeRepository repository;
  private final EmployeeCnapsRepository cnapsRepository;
  private final EmployeeEntityMapper entityMapper;
  private final EmployeeMapper mapper;
  @Override
  public Employee getById(String id) {
    com.example.prog4.repository.employee.entity.Employee employee = repository.findById(id).orElseThrow(() -> new NotFoundException("Not found id=" + id));
    EmployeeCnaps employeeCnaps = cnapsRepository.findByEndToEndId(id);
    if(employeeCnaps == null) {
      throw new NotFoundException("Not found id=" + id);
    }
    return mapper.toView(entityMapper.toDomain(employeeCnaps, employee));
  }

  @Override
  public Employee save(Employee employee) {
    com.example.prog4.repository.employee.entity.Employee savedEmployee = repository.save(mapper.toDomain(employee));
    cnapsRepository.save(entityMapper.toDomain(savedEmployee));
    return mapper.toView(savedEmployee);
  }
}
