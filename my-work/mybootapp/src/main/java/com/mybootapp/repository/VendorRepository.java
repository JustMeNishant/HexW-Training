package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootapp.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long>{

	Vendor findByName(String name);

}
