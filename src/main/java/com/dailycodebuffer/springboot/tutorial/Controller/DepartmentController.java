package com.dailycodebuffer.springboot.tutorial.Controller;

import com.dailycodebuffer.springboot.tutorial.Entity.Department;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER=(Logger) LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments")
    public Department saveDepartment(@Valid@RequestBody Department department) {
    LOGGER.info("inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("inside fetchDepartmentList of DepartmentController");

        return departmentService.fetchdepartment();

    }

    @GetMapping("departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("inside fetchDepartmentById of DepartmentController");

        return departmentService.fetchDepartmentById(departmentId);

    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        LOGGER.info("inside deleteDepartmentById of DepartmentController");

        departmentService.deleteDepartmentById(departmentId);
        return "department Deleted Successfully";
    }

    @PutMapping("departments/{id}")
    public Department UpdateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        LOGGER.info("inside UpdateDepartmentById of DepartmentController");

        return departmentService.updateDepartmentById(departmentId, department);

    }
    @GetMapping("departments/name/{name}")
    public Department fetchDepartmentByDepartmentName( @PathVariable ("name")String departmentName){
        LOGGER.info("inside fetchDepartmentByDepartmentName of DepartmentController");

        return departmentService.fetchDepartmentByName(departmentName);

    }}
