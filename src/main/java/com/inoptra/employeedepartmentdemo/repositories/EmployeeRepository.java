package com.inoptra.employeedepartmentdemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inoptra.employeedepartmentdemo.models.Employee;

/**
 * @Author: Shrikrishna Prabhumirashi
 * @Description: Persistence layer which performs operations on Employee entity
 **/
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //    SELECT SUM(esc.FACTOR * e.BASE_SALARY) FROM DEPARTMENT d JOIN EMPLOYEE e ON d.id = e.department_ID JOIN EMPLOYEE_SALARY_COMONENTS esc ON e.ID = esc.EMPLOYEE_ID;
//    SELECT * FROM DEPARTMENT d JOIN EMPLOYEE e ON d.id = e.department_ID JOIN EMPLOYEE_SALARY_COMONENTS esc ON e.ID = esc.EMPLOYEE_ID;
    @Query(value = "SELECT SUM(esc.FACTOR * e.BASE_SALARY) " +
            "FROM DEPARTMENT d JOIN EMPLOYEE e ON d.id = e.department_ID " +
            "JOIN EMPLOYEE_SALARY_COMONENTS esc ON e.ID = esc.EMPLOYEE_ID"
            , nativeQuery = true)
    Double getTotalSalaryForAllDepartments();


    @Query(value = "SELECT SUM(esc.FACTOR * e.BASE_SALARY) " +
            "FROM DEPARTMENT d JOIN EMPLOYEE e ON d.id = e.department_ID " +
            "JOIN EMPLOYEE_SALARY_COMONENTS esc ON e.ID = esc.EMPLOYEE_ID " +
            "WHERE d.ID = ?1", nativeQuery = true)
    Double getTotalSalaryForAllDepartmentsForDepartment(Long depId);

    @Query(value = "SELECT ((SELECT SUM(esc.FACTOR * e.BASE_SALARY) / COUNT(DISTINCT(E.ID))  \n" +
            "            FROM DEPARTMENT d JOIN EMPLOYEE e ON d.id = e.department_ID \n" +
            "            JOIN EMPLOYEE_SALARY_COMONENTS esc ON e.ID = esc.EMPLOYEE_ID\n" +
            "            WHERE d.ID = od.ID) / (SELECT COUNT(od.id))) avg_salary_per_dep\n" +
            "FROM Department od", nativeQuery = true)
    List<Double> getAverageSalaryForAllDepartments();

    @Query(value = "SELECT SUM(esc.FACTOR * e.BASE_SALARY) / COUNT(DISTINCT(E.ID))  " +
            "FROM DEPARTMENT d JOIN EMPLOYEE e ON d.id = e.department_ID " +
            "JOIN EMPLOYEE_SALARY_COMONENTS esc ON e.ID = esc.EMPLOYEE_ID " +
            "WHERE d.ID = ?1", nativeQuery = true)
    Double getAverageSalaryForDepartment(Long depId);


}
