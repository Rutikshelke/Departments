package com.dailycodebuffer.springboot.tutorial.Implementation;

import com.dailycodebuffer.springboot.tutorial.Entity.Address;
import com.dailycodebuffer.springboot.tutorial.Entity.Department;
import com.dailycodebuffer.springboot.tutorial.Entity.Employee;
import com.dailycodebuffer.springboot.tutorial.Repository.AddressRepository;
import com.dailycodebuffer.springboot.tutorial.Repository.EmployeeRepository;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setEmpId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


    @Override
    public Address updateAddress(Long empId, Address address) {
        Optional<Employee> employee = employeeRepository.findById(empId);
            return addressRepository.save(address);
        }

    @Override
    public Address getAddressByEmployeeId(Long empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        return employee.get().getAddress();
    }

    @Override
    public Optional<Employee> fetchEmployeeByEmployeeName(String name) {
        return employeeRepository.findByName(name);
    }



    @Override
    public Department fetchDepartmentByEmployeeName(String name) throws DepartmentNotFoundException {
        Optional<Employee> employee = employeeRepository.findByName(name);
        if (employee.isPresent()) {
            return employee.get().getDepartment();
        } else {
            throw new DepartmentNotFoundException("No employee found with the name " + name);
        }
    }

}
