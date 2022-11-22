package com.mirae.service;

import com.mirae.entity.EmployeeEntity;
import com.mirae.model.Employee;
import com.mirae.repository.EmployeeRepository;
import com.mirae.util.Common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    Common common;

    public Employee findEmployeeById(int employeeId) {
        log.info("============ find Employee by Id : {}", employeeId);
        EmployeeEntity emp = employeeRepository.findById(employeeId).get();

        return common.mappingEmployee(emp);
    }
}
