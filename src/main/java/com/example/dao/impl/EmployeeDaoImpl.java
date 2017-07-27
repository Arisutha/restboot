package com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.constant.sql.EmployeeSqlConstant;
import com.example.dao.EmployeeDao;
import com.example.model.Employees;


@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employees> getAllData() throws Exception {
		String sql = EmployeeSqlConstant.LIST_EMPLOYEES;
		List<Employees> listEmployees = jdbcTemplate.query(sql, new RowMapper<Employees>(){
			@Override
			public Employees mapRow(ResultSet rs, int row) throws SQLException {
				Employees employees = new Employees(); 
				employees.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employees.setFirstName(rs.getString("FIRST_NAME"));
				employees.setLastName(rs.getString("LAST_NAME"));
				employees.setEmail(rs.getString("EMAIL"));
				employees.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				employees.setHireDate(rs.getDate("HIRE_DATE"));
				employees.setJobsId(rs.getString("JOB_ID"));
				employees.setSalary(rs.getBigDecimal("SALARY"));
				employees.setCommissionPct(rs.getInt("COMMISSION_PCT"));
				employees.setManagerId(rs.getInt("MANAGER_ID"));
				employees.setDepartementId(rs.getInt("DEPARTMENT_ID"));		
				return employees;
			}
			
		});
		return listEmployees;
	}

	@Override
	public boolean saveData(Employees employees) throws Exception {
		boolean success = false;
		try {
			String sql = EmployeeSqlConstant.INSERT_EMPLOYEES;
			jdbcTemplate.update(sql,
			employees.getEmployeeId(),
			employees.getFirstName(),
			employees.getLastName(),
			employees.getEmail(),
			employees.getPhoneNumber(),
			employees.getHireDate(),
			employees.getJobsId(),
			employees.getSalary(),
			employees.getCommissionPct(),
			employees.getManagerId(),
			employees.getDepartementId());
			success = true;
		} catch (Exception e) {
			throw new Exception(e);
		}
		return success;
	}

	@Override
	public boolean updateData(Employees employees) throws Exception {
		boolean success = false;
		try {
			String sql = EmployeeSqlConstant.UPDATE_EMPLOYEES;
			jdbcTemplate.update(sql,
			employees.getFirstName(),
			employees.getLastName(),
			employees.getEmail(),
			employees.getPhoneNumber(),
			employees.getHireDate(),
			employees.getJobsId(),
			employees.getSalary(),
			employees.getCommissionPct(),
			employees.getManagerId(),
			employees.getDepartementId(),
			employees.getEmployeeId());
			success = true;
		} catch (Exception e) {
			throw new Exception(e);
		}
		return success;
	}

	@Override
	public boolean deleteData(Employees employees) throws Exception {
		boolean success = false;
		try {
			String sql = EmployeeSqlConstant.DELETE_EMPLOYEES_BY_EMPLOYEEID;
			jdbcTemplate.update(sql, employees.getEmployeeId());
			success = true;
		} catch (Exception e) {
			throw new Exception(e);
		}
		return success;
	}

	@Override
	public Employees getSingleData(Employees employees) throws Exception {
		String sql = EmployeeSqlConstant.GET_EMPLOYEES_BY_EMPLOYEEID + employees.getEmployeeId();
		return jdbcTemplate.query(sql, new ResultSetExtractor<Employees>() {
			@Override
			public Employees extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()){
					Employees employees = new Employees(); 
					employees.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
					employees.setFirstName(rs.getString("FIRST_NAME"));
					employees.setLastName(rs.getString("LAST_NAME"));
					employees.setEmail(rs.getString("EMAIL"));
					employees.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					employees.setHireDate(rs.getDate("HIRE_DATE"));
					employees.setJobsId(rs.getString("JOB_ID"));
					employees.setSalary(rs.getBigDecimal("SALARY"));
					employees.setCommissionPct(rs.getInt("COMMISSION_PCT"));
					employees.setManagerId(rs.getInt("MANAGER_ID"));
					employees.setDepartementId(rs.getInt("DEPARTMENT_ID"));
					return employees;
				}
				return null;
			}
		});
	}

}
