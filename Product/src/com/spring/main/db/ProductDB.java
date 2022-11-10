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

import com.spring.main.model.Product;

@Component
public class ProductDB {

	private NamedParameterJdbcTemplate jdbc; //for query execution
	
	private DataSource dataSource; //est. conn to DB

	@Autowired
	public void setDataSource(DataSource dataSource) {
		 jdbc = new NamedParameterJdbcTemplate
				 (dataSource);
	}

	public List<Product> fetchAllProducts() {
		String sql="select * from products where category='Mobile' or category='Laptop'or category='Tablet' order by category; ";
		return jdbc.query(sql, new A()); 
	}
	//insert , update, delete 
	public void insertProduct(Product product) {
		Map<String,Object> map =new HashMap<>();
		map.put("name",product.getName());
		map.put("price", product.getPrice());
		map.put("descrip",product.getDescrip());
		map.put("category", product.getCategory());
		
		String sql="insert into products(name,price,descrip,category) "
				+ "values (:name, :price, :descrip, :category)";
		jdbc.update(sql, map);
	}

	public void deleteProductById(int id) {
		Map<String,Integer> map =new HashMap<>();
		map.put("id",id);
		 String sql="delete from products where id=:id";
		 jdbc.update(sql, map);
		
	}

	public void processEdit(Product product) {
		// TODO Auto-generated method stub
		Map<String,Object> map =new HashMap<>();
		map.put("id", product.getId());
		map.put("name",product.getName());
		map.put("price", product.getPrice());
		map.put("descrip",product.getDescrip());
		map.put("category", product.getCategory());
		
		String sql="update products SET name=:name, price=:price, descrip=:descrip, category=:category where id=:id";
		 jdbc.update(sql, map);
		
		
	}
}

class A implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rst, int rowNum) throws SQLException {
		 Product e=new Product(); 
		 e.setId(rst.getInt("id"));
		 e.setName(rst.getString("name"));
		 e.setPrice(rst.getDouble("price"));
		 e.setDescrip(rst.getString("descrip"));
	
		 e.setCategory(rst.getString("category"));
		 
		return e;
	}
	
}