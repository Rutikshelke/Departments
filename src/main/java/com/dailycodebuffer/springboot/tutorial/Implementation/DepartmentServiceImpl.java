package com.dailycodebuffer.springboot.tutorial.Implementation;

import com.dailycodebuffer.springboot.tutorial.Entity.Department;
import com.dailycodebuffer.springboot.tutorial.Entity.Employee;
import com.dailycodebuffer.springboot.tutorial.Repository.DepartmentRepository;
import com.dailycodebuffer.springboot.tutorial.Repository.EmployeeRepository;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchdepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException(" Department not available");
        }
        Department dept = department.get();
        return dept;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Department depDB = departmentRepository.findById(id).get();
        if (Objects.nonNull(department.getName()) &&
                !"".equalsIgnoreCase(department.getName())) {
            depDB.setName(department.getName());
        }
        if (Objects.nonNull(department.getCode()) &&
                !"".equalsIgnoreCase(department.getCode())) {
            depDB.setCode(department.getCode());
        }
        if (Objects.nonNull(department.getAddress()) &&
                !"".equalsIgnoreCase(department.getAddress())) {
            depDB.setAddress(department.getAddress());
        }
        if (Objects.nonNull(department.getName()) && !department.getName().trim().isEmpty()) {
            depDB.setName(department.getName());
        }
        return departmentRepository.save(depDB);
    }




    @Override
    public Department fetchDepartmentByDepartmentCode(String code) {


        return departmentRepository.findByCode(code);
    }

}
