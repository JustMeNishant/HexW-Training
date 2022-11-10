package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootapp.model.Slots;

public interface SlotRepository extends JpaRepository<Slots, Long>{

}
