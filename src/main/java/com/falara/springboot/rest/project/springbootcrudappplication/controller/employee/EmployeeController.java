package com.falara.springboot.rest.project.springbootcrudappplication.controller.employee;

import com.falara.springboot.rest.project.springbootcrudappplication.dto.EmployeeDTO;
import com.falara.springboot.rest.project.springbootcrudappplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
