package com.example.prog4.repository;

import com.example.prog4.repository.entity.Employee;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@ConfigurationProperties(prefix = "spring.datasource")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
