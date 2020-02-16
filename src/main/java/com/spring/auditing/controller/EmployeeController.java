package com.spring.auditing.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.auditing.dto.InputRequest;
import com.spring.auditing.model.Employee;
import com.spring.auditing.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService service;

	@PostMapping("/addEmployee")
	public ResponseEntity<Object> saveEmployee(@RequestBody InputRequest<Employee> request) {
		logger.info("Request initiated to save employee details on {}", new Date());
		return new ResponseEntity<>(service.saveEmployee(request), HttpStatus.OK);
	}

	@PutMapping("/updateEmployee/{employeeId}")
	public ResponseEntity<Object> updateEmployeeSalary(@PathVariable("employeeId") int employeeId,
			@RequestBody InputRequest<Employee> request) {
		logger.info("Request initiated to update employee details for EMP_ID => {} ", employeeId);
		return new ResponseEntity<>(service.updateEmployee(employeeId, request), HttpStatus.OK);
	}
}
