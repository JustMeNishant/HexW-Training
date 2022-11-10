package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootapp.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
