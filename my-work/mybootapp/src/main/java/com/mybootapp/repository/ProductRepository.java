package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybootapp.model.Product;
import com.mybootapp.model.Vendor;

public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query("select p.vendor from Product p where p.name=?1")
	Vendor getVendorNameByProductName(String pname);


}
