/**
 * 
 */
package com.task.employeemanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.employeemanage.entity.Employee;

/**
 * @author sudheep
 *
 */
@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}