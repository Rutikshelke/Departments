package com.dailycodebuffer.springboot.tutorial.Repository;

import com.dailycodebuffer.springboot.tutorial.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByName(String name);
}
