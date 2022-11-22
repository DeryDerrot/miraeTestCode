package com.mirae.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue
    @Column(name = "employees_id")
    private int employeesID;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private String title;

    @Column(name = "work_phone", nullable = false)
    private String workPhone;
}
