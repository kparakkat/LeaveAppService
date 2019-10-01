package leaveappservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import leaveappservice.models.LeaveHistory;
import leaveappservice.models.LeaveHistoryDao;

@RestController
public class LeaveHistoryController {

	@Autowired
	private LeaveHistoryDao _leaveHistDao;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/leavehistory/getByEmpId/{id}")
	public List<LeaveHistory> getById(@PathVariable("id") int id) {
	    List<LeaveHistory> leaveHist;
	    try {
	      System.out.println("Leave History getByEmpId controller method started");
	      leaveHist = _leaveHistDao.getLeaveHistByEmpId(id);
	      // emp = new Employee(1, "John", 123456, "IT", "john@abc.com", new Date(), 5, 2);
	      // System.out.println("getById controller method completed");
	    }
	    catch(Exception ex) {
	      System.out.println("getById controller method have errors" + ex.getMessage());
	      return null;
	    }
	    return leaveHist;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/leavehistory/save")
	public String createLeaveHistory(@RequestBody LeaveHistory leaveHistory) {
	    try {
	    	_leaveHistDao.save(leaveHistory);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "Leave succesfully saved!";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/leavehistory/update")
	public String updateLeaveHistory(@RequestBody LeaveHistory leaveHistory) {
	    try {
	    	_leaveHistDao.update(leaveHistory);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "Leave succesfully updated!";
	}
	
}
