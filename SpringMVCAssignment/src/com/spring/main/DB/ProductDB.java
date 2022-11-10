package com.spring.main.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.main.model.Product;

@Component
public class ProductDB {

	private NamedParameterJdbcTemplate jdbc;
	
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		 jdbc = new NamedParameterJdbcTemplate
				 (dataSource);
	}

	public List<Product> fetchAllProducts() {
		String sql = "select * from products";	
		return jdbc.query(sql, new A()); 
	}

	public void insertProduct(Product product) {
		
		Map<String,Object> map =new HashMap<>();
		map.put("title",product.getTitle());
		map.put("ram", product.getRam());
		map.put("memory",product.getMemory());
		map.put("display",product.getDisplay());
		map.put("category",product.getCategory());
		map.put("price",product.getPrice());
		String sql = "insert into products(title,ram,memory,display,category,price) values(:title,:ram,:memory,:display,:category,:price)";	
		jdbc.update(sql,map);
	}

	public void deleteProductById(int id) {
		Map<String,Integer> map =new HashMap<>();
		map.put("id",id);
		String sql = "delete from products where id=:id";
		jdbc.update(sql,map);
		
	}

	public void updateProductById(Product product) {
		Map<String,Object> map =new HashMap<>();
		map.put("id", product.getId());
		map.put("title",product.getTitle());
		map.put("ram", product.getRam());
		map.put("memory",product.getMemory());
		map.put("display",product.getDisplay());
		map.put("category",product.getCategory());
		map.put("price",product.getPrice());
		String sql = "update products set title=:title,ram=:ram,memory=:memory,display=:display,"
				+ "category=:category,price=:price where id=:id";
		jdbc.update(sql,map);
	}

}
class A implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rst, int rowNum) throws SQLException {
		Product p = new Product();
		p.setId(rst.getInt("id"));
		p.setTitle(rst.getString("title"));
		p.setRam(rst.getInt("ram"));
		p.setMemory(rst.getInt("memory"));
		p.setDisplay(rst.getString("display"));
		p.setCategory(rst.getString("category"));
		p.setPrice(rst.getDouble("price"));
		return p;
	}
	
}