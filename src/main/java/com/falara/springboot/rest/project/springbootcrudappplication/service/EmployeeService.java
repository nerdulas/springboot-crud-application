package com.falara.springboot.rest.project.springbootcrudappplication.service;

import com.falara.springboot.rest.project.springbootcrudappplication.dto.EmployeeDTO;
import com.falara.springboot.rest.project.springbootcrudappplication.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId) throws ResourceNotFoundException;
}
