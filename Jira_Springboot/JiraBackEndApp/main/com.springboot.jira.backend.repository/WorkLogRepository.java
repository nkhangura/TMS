package com.springboot.jira.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.jira.backend.model.WorkLog;

public interface WorkLogRepository extends JpaRepository<WorkLog, Long>{
	
	/* Get All WorkLogs By Employee ID */
	@Query("select w from WorkLog w where w.employee.id=?1")
	List<WorkLog> getAllWorkLogsByEmployeeId(Long eid);

}

