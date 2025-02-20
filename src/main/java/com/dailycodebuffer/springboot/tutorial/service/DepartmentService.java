package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.Entity.Department;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> fetchdepartment();

  public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

   public  void deleteDepartmentById(Long id);

   public  Department updateDepartmentById(Long id, Department department);


     public  Department fetchDepartmentByDepartmentCode(String code);

}

