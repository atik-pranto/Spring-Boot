package pranto.bootdemo.erm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pranto.bootdemo.erm.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
