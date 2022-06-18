package pranto.bootdemo.erm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pranto.bootdemo.erm.entity.Employee;
import pranto.bootdemo.erm.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService)
	{
		employeeService = theEmployeeService;
	}
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// add to the spring model
		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// add to the spring model
		Employee theEmployee = new  Employee();
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		// add to the spring model
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
	{
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// add to the spring model
	    employeeService.deleteById(theId);
		
	    return "redirect:/employees/list";
	}


}
