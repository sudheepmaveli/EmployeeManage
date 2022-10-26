package com.task.employeemanage.entity;

/**
 * @author sudheep
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstname;
	private String lastname;
	private String dob;
	private String department;
	private int salary;
	private String manager;

	public Employee() {
	}

	public Employee(String firstname, String lastname, String dob, String department, int salary, String manager) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.department = department;
		this.salary = salary;
		this.manager = manager;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

}
