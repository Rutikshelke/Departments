package com.dailycodebuffer.springboot.tutorial.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@AllArgsConstructor

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank(message = "Please Enter the Department name")

    private String name;
    @NotBlank(message = "please enter the address location")

    private String address;
    @NotBlank(message = "Please Enter the Department Code")

    private String code;
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateTime;
    @Autowired
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public @NotBlank(message = "Please Enter the Department name") String getName() {
        return name;
    }

    public Department() {
    }

    public void setName(@NotBlank(message = "Please Enter the Department name") String name) {
        this.name =name;
    }

    public @NotBlank(message = "please enter the address location") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "please enter the address location") String address) {
        this.address = address;
    }

    public @NotBlank(message = "Please Enter the Department Code") String getCode() {
        return code;
    }

    public void setCode(@NotBlank(message = "Please Enter the Department Code") String code) {
        this.code = code;
    }

    public Long getid() {
        return id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public LocalDateTime getUpdatetime(){
        return updateTime;
    }

}