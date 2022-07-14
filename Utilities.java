package com.workLog;

import java.util.List;

import com.workLog.WorkLog;

public class Utilities {

	public static boolean validateWorkLogID (List<WorkLog> worklogList, int worklogID) {
		boolean foundInTable = false;
		for(WorkLog w : worklogList) {
			if(w.getId() == worklogID) {
				foundInTable = true;
				break;
			}
		}
		return foundInTable;
	}

	public boolean validateWorkLogIDUnderCurrentEmployee(List<WorkLog> worklogList, int worklogID, int empid) {
		boolean foundInTable = false;
		for(WorkLog w : worklogList) {
			if(w.getId() == worklogID && w.getEmp_id() == empid) {
				foundInTable = true;
				break;
			}
		}
		return foundInTable;
	}
}

