package com.bootapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bootapplication.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("update Employee e set e.leaveStatus=?1 where e.id=?2")
	void updateStatus(String leaveStatus,Long id);

}
