package com.falara.springboot.rest.project.springbootcrudappplication.repository;

import com.falara.springboot.rest.project.springbootcrudappplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
