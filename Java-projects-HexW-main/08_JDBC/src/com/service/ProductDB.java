package com.service;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import com.model.Product;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class ProductDB
{
    Connection con;
    
    public void dbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded..");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproductdb_80625", "root", "Password123");
            System.out.println("Connection Established");
        }
        catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
    
    public void insert(final Product product) {
        this.dbConnect();
        final String sql = "insert into productss(name,price,describ) values (?,?,?)";
        try {
            final PreparedStatement pstmt = this.con.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setString(3, product.getDescrib());
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        this.dbClose();
    }
    
    public void dbClose() {
        try {
            this.con.close();
            System.out.println("conn closed");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Product> fetchProducts() {
        this.dbConnect();
        final String sql = "select * from productss";
        final List<Product> list = new ArrayList<Product>();
        try {
            final PreparedStatement pstmt = this.con.prepareStatement(sql);
            final ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                final Product e = new Product();
                final int id = rst.getInt("id");
                final String name = rst.getString("name");
                final double price = rst.getDouble("price");
                final String describ = rst.getString("describ");
                e.setId(id);
                e.setName(name);
                e.setPrice(price);
                e.setDescrib(describ);
                list.add(e);
            }
        }
        catch (SQLException e2) {
            e2.printStackTrace();
        }
        this.dbClose();
        return list;
    }

	public void delete(int id) {
		this.dbConnect();
		String sql="Delete from productss where id=?"; 
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate(); } 
		catch (SQLException e) {
			e.printStackTrace();
			dbClose();
		}
		
		// TODO Auto-generated method stub
		
	}
}