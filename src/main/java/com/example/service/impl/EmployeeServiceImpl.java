package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.EmployeeDao;
import com.example.model.Employees;
import com.example.service.EmployeeService;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override	
	public List<Employees> getAllData() throws Exception {
		return this.employeeDao.getAllData();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean saveData(Employees klass) throws Exception {
		return this.employeeDao.saveData(klass);
	}

	@Override
	public boolean updateData(Employees klass) throws Exception {
		return this.employeeDao.updateData(klass);
	}

	@Override
	public boolean deleteData(Employees klass) throws Exception {
		return this.employeeDao.deleteData(klass);
	}

	@Override
	public Employees getSingleData(Employees klass) throws Exception {
		return this.employeeDao.getSingleData(klass);
	}

}
