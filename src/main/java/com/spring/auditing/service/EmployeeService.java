package com.spring.auditing.service;

import com.spring.auditing.dto.InputRequest;
import com.spring.auditing.model.Employee;

public interface EmployeeService {

	String saveEmployee(InputRequest<Employee> request);

	String updateEmployee(int employeeId, InputRequest<Employee> request);

}
