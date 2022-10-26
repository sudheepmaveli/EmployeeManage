package com.task.employeemanage.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.task.employeemanage.entity.Employee;

@Component
public class EmployeeValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
		String dob = employee.getDob();
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(employee.getDob());

			Calendar calendar = GregorianCalendar.getInstance();
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 20);
			if (calendar.getTime().before(date)) {
				errors.rejectValue("dob", "employee.dob.invalid", "Invalid Date of Birth(20 Years old Minimum).");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}