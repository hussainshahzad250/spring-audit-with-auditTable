package com.spring.auditing.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.auditing.dao.EmployeeRepository;
import com.spring.auditing.dto.InputRequest;
import com.spring.auditing.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public String saveEmployee(InputRequest<Employee> request) {
		String currentUser = request.getLoggedInUser();
		request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
		Employee employee = request.getEmployee();
		employee.setCreatedBy(currentUser);
		repository.save(employee);
		return "Employee saved successfully...";
	}

	public String updateEmployee(int employeeId, InputRequest<Employee> request) {
		Employee employee = repository.findById(employeeId).get();
		if (employee != null) {
			if (request.getEmployee() != null)
				employee.setSalary(request.getEmployee().getSalary());
			employee.setModifiedBy(request.getLoggedInUser());
			repository.saveAndFlush(employee);
		} else {
			throw new RuntimeException("Employee not found with id : " + employeeId);
		}
		return "Employee Updated successfully ";
	}
}
