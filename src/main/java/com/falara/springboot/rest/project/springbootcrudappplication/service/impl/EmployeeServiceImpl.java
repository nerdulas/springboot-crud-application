package com.falara.springboot.rest.project.springbootcrudappplication.service.impl;

import com.falara.springboot.rest.project.springbootcrudappplication.dto.EmployeeDTO;
import com.falara.springboot.rest.project.springbootcrudappplication.model.Employee;
import com.falara.springboot.rest.project.springbootcrudappplication.repository.EmployeeRepository;
import com.falara.springboot.rest.project.springbootcrudappplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeesDTO;
        List<Employee> employees = this.employeeRepository.findAll();
        employeesDTO = employees.stream()
                                .map(employee -> new EmployeeDTO(employee.getId(), employee.getFirstName(),
                                        employee.getLastName(), employee.getEmail())).collect(Collectors.toList());
        return employeesDTO;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
