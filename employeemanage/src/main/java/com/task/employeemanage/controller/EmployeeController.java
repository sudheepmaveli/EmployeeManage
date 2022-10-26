/**
 * 
 */
package com.task.employeemanage.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.task.employeemanage.entity.Employee;
import com.task.employeemanage.service.EmployeeService;
import com.task.employeemanage.validator.EmployeeValidator;

/**
 * @author sudheep
 *
 */
@Controller
@RequestMapping("/")
@Transactional
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeValidator employeeValidator;

	@GetMapping(value = "/")
	public String home(Map<String, Object> model) {

		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Calendar calendar = Calendar.getInstance();
			System.out.println("Current Date = " + calendar.getTime());
			// Subtract 20 Years
			calendar.add(Calendar.YEAR, -18);
			System.out.println("Updated Date = " + calendar.getTime());
			sm.format(calendar.getTime());
			model.put("minDate", sm.format(calendar.getTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Employee employee = new Employee();
		model.put("employee", employee);
		return "addEmployee";
	}

	@PostMapping(value = "/save")
	public String saveCustomer(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			Map<String, Object> model) {

		employeeValidator.validate(employee, result);
		if (result.hasErrors()) {
			return "addEmployee";
		}
		model.put("employee", employee);
		employeeService.save(employee);
		return "redirect:/list";
	}

	@GetMapping("/list")
	public ModelAndView home() {
		List<Employee> listEmployee = employeeService.listAll();
		ModelAndView mav = new ModelAndView("listEmployee");
		mav.addObject("listEmployee", listEmployee);
		return mav;
	}

	@GetMapping("/edit")
	public ModelAndView editEmployeeForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("addEmployee");
		Employee employee = employeeService.get(id);
		mav.addObject("employee", employee);
		return mav;
	}

	@GetMapping("/view")
	public ModelAndView viewEmployeeForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("viewEmployee");
		Employee employee = employeeService.get(id);
		mav.addObject("employee", employee);
		return mav;
	}

}
