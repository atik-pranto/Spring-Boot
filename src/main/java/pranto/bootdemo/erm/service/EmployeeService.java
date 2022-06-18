package pranto.bootdemo.erm.service;

import java.util.List;

import pranto.bootdemo.erm.entity.Employee;



public interface EmployeeService {
	
    public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);


}
