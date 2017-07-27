package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.model.Employees;
import com.example.model.User;
import com.example.service.EmployeeService;
import com.example.service.UserService;


@RestController
@RequestMapping("/api")
public class RestApiController {
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeService employeeServiceKedua;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public ResponseEntity<List<Employees>> listAllEmp(){
		List<Employees> employees;
		try {
			// buat ngambil datanya pakai employee impl kedua
			employees = this.employeeServiceKedua.getAllData();
			if (employees.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }
			return new ResponseEntity<List<Employees>>(employees, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/emp/map", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listAllEmpMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Employees> employees = new ArrayList<Employees>();
		try {
			employees = this.employeeService.getAllData();
			if (employees.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }
			map.put("dataEmp", employees);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	}
	
	@RequestMapping(value = "/emp/save", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> createUser(@RequestBody Employees employees){
		boolean success = false;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			success = this.employeeService.saveData(employees);
			map.put("isNoError", success);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			map.put("isNoError", success);
			map.put("DesError", ExceptionUtils.getRootCauseMessage(e));
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/emp/update", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> updateUser(@RequestBody Employees employees){
		boolean success = false;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			success = this.employeeService.updateData(employees);
			map.put("isNoError", success);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			map.put("isNoError", success);
			map.put("DesError", ExceptionUtils.getRootCauseMessage(e));
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/emp/delete", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> deleteeUser(@RequestBody Employees employees){
		boolean success = false;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			success = this.employeeService.deleteData(employees);
			map.put("isNoError", success);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			map.put("isNoError", success);
			map.put("DesError", ExceptionUtils.getRootCauseMessage(e));
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
	}
}
