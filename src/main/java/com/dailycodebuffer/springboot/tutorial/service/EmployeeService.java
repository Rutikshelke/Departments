package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.Entity.Address;
import com.dailycodebuffer.springboot.tutorial.Entity.Department;
import com.dailycodebuffer.springboot.tutorial.Entity.Employee;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
     public  Employee saveEmployee(Employee employee);

   public List<Employee> getAllEmployees();

    public Optional<Employee> getEmployeeById(Long empId);

    public Employee updateEmployee(Long id, Employee employee);

    public void deleteEmployee(Long id);

    public Address updateAddress(Long empId, Address address);


    public  Address getAddressByEmployeeId(Long empId);

   public Optional<Employee> fetchEmployeeByEmployeeName(String name);


   public Department fetchDepartmentByEmployeeName(String name) throws DepartmentNotFoundException;
}
