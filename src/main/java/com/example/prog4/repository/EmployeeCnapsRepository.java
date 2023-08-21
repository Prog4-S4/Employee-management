package com.example.prog4.repository;

import com.example.prog4.repository.entity.EmployeeCnaps;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@ConfigurationProperties(prefix = "spring.datasource-db2")
@Repository
public interface EmployeeCnapsRepository extends JpaRepository<EmployeeCnaps, String> {
}
