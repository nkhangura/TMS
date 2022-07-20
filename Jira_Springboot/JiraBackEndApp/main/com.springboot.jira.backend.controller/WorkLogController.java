package com.springboot.jira.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jira.backend.model.Employee;
import com.springboot.jira.backend.model.WorkLog;
import com.springboot.jira.backend.repository.EmployeeRepository;
import com.springboot.jira.backend.repository.WorkLogRepository;

@RestController
public class WorkLogController {

	@Autowired
	private WorkLogRepository workLogRepository;
	
	@Autowired
	private EmployeeRepository employeeRespository;

	/* Post worklog */
	@PostMapping("/worklog/{eid}")
	public void postWorkLog(@RequestBody WorkLog worklog, @PathVariable("eid") Long eid) {
		/* Check whether the employee id is valid */
		Optional<Employee> opt = employeeRespository.findById(eid);
		if(opt.isPresent()) {
			/* Get the contents of the employee*/
			Employee emp = opt.get();
			
			/* Set new Employee for a worklog */
			worklog.setEmployee(emp);
			
			/* Save worklog in DB */
			workLogRepository.save(worklog);
		}
		else
			throw new RuntimeException("Invalid Employee ID");
	}
	
	/* Get All WorkLogs */
	@GetMapping("/worklog")
	public List<WorkLog> getAllWorkLogs(){
		List<WorkLog> list = workLogRepository.findAll();
		return list;
	}
	
	/* Get All WorkLogs By Employee ID */
	@GetMapping("/worklog/employee/{eid}")
	public List<WorkLog> getAllWorkLogsByEmployeeId(@PathVariable("eid") Long eid){
		List<WorkLog> list = workLogRepository.getAllWorkLogsByEmployeeId(eid);
		return list;
	}
	
	/* Delete WorkLog By ID */ 
	@DeleteMapping("/worklog/{wid}")
	public void deleteWorkLogByEmployeeId(@PathVariable("wid") Long wid) {
		workLogRepository.deleteById(wid);
	}
	
	/* Update WorkLog By ID */ 
	@PutMapping("/worklog/{wid}")
	public WorkLog updateWorkLog(@PathVariable("wid") Long wid, @RequestBody WorkLog newWorkLog) {
		/* Check whether the worklog id is valid */
		Optional<WorkLog> opt = workLogRepository.findById(wid);
		if(opt.isPresent()) {
			/* get current worklog information */
			WorkLog currentWorkLog = opt.get();
			
			/* update the description of the current worklog */
			currentWorkLog.setDescription(newWorkLog.getDescription());
			
			/* save worklog and return it */
			return workLogRepository.save(currentWorkLog);
		}
		else
			throw new RuntimeException("Invalid WorkLog ID");
	}
}

