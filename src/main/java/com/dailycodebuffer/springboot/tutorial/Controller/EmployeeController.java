package com.dailycodebuffer.springboot.tutorial.Controller;

import com.dailycodebuffer.springboot.tutorial.Entity.Department;
import com.dailycodebuffer.springboot.tutorial.Entity.Employee;
import com.dailycodebuffer.springboot.tutorial.Entity.Address;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(EmployeeController.class);


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        LOGGER.info("inside createEmployee of EmployeeController");
        return savedEmployee;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("inside getAllEmployee of EmployeeController");

        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        LOGGER.info("inside getEmployeeById of EmployeeController");
        return employee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return updatedEmployee;
    }

    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable("empId") Long empId) {
        employeeService.deleteEmployee(empId);
        return "Employee deleted successfully";
    }

    @PostMapping("/{empId}/address")
    public Address saveAddress(@PathVariable Long empId, @RequestBody Address address) {
        Address savedAddress = employeeService.updateAddress(empId, address);
        return savedAddress;
    }

    @GetMapping("/{empId}/address")
    public Address getAddress(@PathVariable Long empId) {
        Address address = employeeService.getAddressByEmployeeId(empId);
        return address;  }
    @GetMapping("/name/{name}")
    public Optional<Employee> fetchDepartmentByEmployeeName(@PathVariable("name") String name) throws DepartmentNotFoundException {
        LOGGER.info("inside fetchDepartmentByDepartmentName of DepartmentController");

        return employeeService.fetchEmployeeByEmployeeName(name);
    }

    }


