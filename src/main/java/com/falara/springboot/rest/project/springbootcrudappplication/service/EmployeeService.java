package com.falara.springboot.rest.project.springbootcrudappplication.service;

import com.falara.springboot.rest.project.springbootcrudappplication.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();
}
