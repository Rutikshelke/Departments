package com.dailycodebuffer.springboot.tutorial.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    @NotBlank(message = "Please Enter the Employee name")
    private String name;

    private String age;
    @NotBlank(message = "Please Enter the phone number")
    private String phoneNo;
    @NotBlank(message = "Please Enter the Employee email")
    private String email;
    private String bloodGroup;
    private String Designation;
    private int salary;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Address address;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public @NotBlank(message = "Please Enter the Employee name") String getName() {

        return name;
    }

    public void setName(@NotBlank(message = "Please Enter the Employee name") String name) {

        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public @NotBlank(message = "Please Enter the phone number") String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(@NotBlank(message = "Please Enter the phone number") String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public @NotBlank(message = "Please Enter the Employee email") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Please Enter the Employee email") String email) {
        this.email = email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
