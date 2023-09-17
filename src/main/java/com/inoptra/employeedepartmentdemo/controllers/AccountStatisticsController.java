package com.inoptra.employeedepartmentdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inoptra.employeedepartmentdemo.repositories.EmployeeRepository;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description: Supports Account keeping for Employees working under department
 *         Below are few operations supported by this controller
 *         - Get total salary to be paid to a department
 *         - Get total salary to be paid to all departments
 *         - Get average salary to be paid to a department
 *         - Get average salary to be paid to all departments
 **/

@RestController
@RequestMapping("/account/accountstats")
public class AccountStatisticsController {

    @Autowired
    private EmployeeRepository empRepository;

    @GetMapping("/all/total")
    public double getTotalSalaryForAllDepartments() {
        return empRepository.getTotalSalaryForAllDepartments();
    }

    @GetMapping("/{deptId}/total")
    public double getTotalSalaryForDepartment(@PathVariable Long deptId) {
        return empRepository.getTotalSalaryForAllDepartmentsForDepartment(deptId);
    }

    @GetMapping("/all/avg")
    public double getAverageSalaryForAllDepartments() {
        return empRepository.getAverageSalaryForAllDepartments();
    }

    @GetMapping("/{deptId}/avg")
    public double getAverageSalaryForDepartment(@PathVariable Long deptId) {
        return empRepository.getAverageSalaryForDepartment(deptId);
    }
}
