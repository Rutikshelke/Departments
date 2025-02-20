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
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> fetchDepartmentList() {
        LOGGER.info("inside fetchDepartmentList of DepartmentController");

        return departmentService.fetchdepartment();

    }

    @GetMapping("/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        LOGGER.info("inside fetchDepartmentById of DepartmentController");

        return departmentService.fetchDepartmentById(id);

    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id) {
        LOGGER.info("inside deleteDepartmentById of DepartmentController");

        departmentService.deleteDepartmentById(id);
        return "department Deleted Successfully";
    }

    @PutMapping("/{id}")
    public Department UpdateDepartmentById(@PathVariable("id") Long id, @RequestBody Department department) {
        LOGGER.info("inside UpdateDepartmentById of DepartmentController");


        return departmentService.updateDepartmentById(id, department);

    }

    @GetMapping("/departmentCode/{code}")
    public Department fetchDepartmentByDepartmentCode(@PathVariable("code") String code) {
        LOGGER.info("inside fetchDepartmentByDepartmentCode of DepartmentController");

        return departmentService.fetchDepartmentByDepartmentCode(code);
    }

}

