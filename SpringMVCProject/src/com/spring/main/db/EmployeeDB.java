package com.spring.main.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.main.model.Employee;

@Component
public class EmployeeDB {

	private NamedParameterJdbcTemplate jdbc; //for query execution
	
	private DataSource dataSource; //est. conn to DB

	@Autowired
	public void setDataSource(DataSource dataSource) {
		 jdbc = new NamedParameterJdbcTemplate
				 (dataSource);
	}

	public List<Employee> fetchAllEmployees() {
		String sql="select * from employee";
		return jdbc.query(sql, new A()); 
	}
	//insert , update, delete 
	public void insertEmployee(Employee employee) {
		Map<String,Object> map =new HashMap<>();
		map.put("name",employee.getName());
		map.put("city", employee.getCity());
		map.put("salary",employee.getSalary());
		
		String sql="insert into employee(name,city,salary) "
				+ "values (:name, :city, :salary)";
		jdbc.update(sql, map);
	}

	public void deleteEmployeeById(int id) {
		Map<String,Integer> map =new HashMap<>();
		map.put("id",id);
		 String sql="delete from employee where id=:id";
		 jdbc.update(sql, map);
		
	}

	public void processEdit(Employee employee) {
		Map<String,Object> map =new HashMap<>();
		map.put("id", employee.getId());
		map.put("name",employee.getName());
		map.put("city", employee.getCity());
		map.put("salary",employee.getSalary());
		
		String sql="update employee SET name=:name,salary=:salary,city=:city where id=:id";
		 jdbc.update(sql, map);
		
	}
}

class A implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rst, int rowNum) throws SQLException {
		 Employee e=new Employee(); 
		 e.setId(rst.getInt("id"));
		 e.setName(rst.getString("name"));
		 e.setCity(rst.getString("city"));
		 e.setSalary(rst.getDouble("salary"));
		 
		return e;
	}
	
}
