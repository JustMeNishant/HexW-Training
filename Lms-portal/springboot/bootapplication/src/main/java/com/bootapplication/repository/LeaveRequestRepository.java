package com.bootapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapplication.model.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long>{

}
