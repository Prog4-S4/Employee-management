package com.example.prog4.repository;

import com.example.prog4.model.Employee;
import org.springframework.stereotype.Component;

@Component
public interface Repository {
  Employee getById(String id);
  Employee save(Employee employee);
}
