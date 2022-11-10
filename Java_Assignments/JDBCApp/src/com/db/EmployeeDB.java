package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Employee;

public class EmployeeDB {
	Connection con;

	public void dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycompdb_2000080620", "root", "Password123");
			System.out.println("Connection Established Successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Employee employee) {
		dbConnect();
		String sql = "insert into employee(name,salary,city) values(?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getName());
			pstmt.setDouble(2, employee.getSalary());
			pstmt.setString(3, employee.getCity());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}

	public List<Employee> fetch() {
		dbConnect();
		String sql = "select * from employee";
		List<Employee> list = new ArrayList<>();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Employee e = new Employee();
				int id = rst.getInt("id");
				String name = rst.getString("name");
				double salary = rst.getDouble("salary");
				String city = rst.getString("city");
				e.setId(id);
				e.setName(name);
				e.setSalary(salary);
				e.setCity(city);
				list.add(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		dbClose();
		return list;
	}

	public void dbClose() {
		try {
			con.close();
			System.out.println("Connection closed successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int id) {
		dbConnect();
		String sql = "delete from employee where id=?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}

}
