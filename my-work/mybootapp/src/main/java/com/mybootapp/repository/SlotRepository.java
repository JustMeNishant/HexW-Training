package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootapp.model.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long>{

}
