package com.falara.springboot.rest.project.springbootcrudappplication.service.impl;

import com.falara.springboot.rest.project.springbootcrudappplication.dto.EmployeeDTO;
import com.falara.springboot.rest.project.springbootcrudappplication.exception.ResourceNotFoundException;
import com.falara.springboot.rest.project.springbootcrudappplication.model.Employee;
import com.falara.springboot.rest.project.springbootcrudappplication.repository.EmployeeRepository;
import com.falara.springboot.rest.project.springbootcrudappplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Employee employee = this.employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        return employeeDTO;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail());
        Employee savedEmployee = this.employeeRepository.save(newEmployee);
        return new EmployeeDTO(savedEmployee.getId(), savedEmployee.getFirstName(), savedEmployee.getLastName(), savedEmployee.getEmail());
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long employeeId) throws ResourceNotFoundException {
        Employee existingEmployee = this.employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        existingEmployee.setFirstName(employeeDTO.getFirstName());
        existingEmployee.setLastName(employeeDTO.getLastName());
        existingEmployee.setEmail(employeeDTO.getEmail());
        Employee updatedEmployee = this.employeeRepository.save(existingEmployee);
        return new EmployeeDTO(updatedEmployee.getId(), updatedEmployee.getFirstName(), updatedEmployee.getLastName(), updatedEmployee.getEmail());
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
