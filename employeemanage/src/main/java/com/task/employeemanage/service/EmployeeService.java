package com.task.employeemanage.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.employeemanage.entity.Employee;
import com.task.employeemanage.repository.EmployeeRepository;

/**
 * @author sudheep
 *
 */
@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Save/Update an Employee data.
	 *
	 * @param employee
	 * @return void
	*/
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	/**
	 * List all employees.
	 *
	 * @return List of Employee
	 */
	public List<Employee> listAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

	/**
	 * List Employee details by id.
	 * 
	 * @param id
	 * @return Employee
	 */
	public Employee get(Long id) {
		return employeeRepository.getOne(id);
	}
}
