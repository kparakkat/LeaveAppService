package leaveappservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import leaveappservice.models.Employee;
import leaveappservice.models.EmployeeDao;

@RestController
public class EmployeeController {

  @Autowired
  private EmployeeDao _empDao;
  
  @GetMapping(value="/emp/delete/{id}")
  public String delete(@PathVariable("id") int id) {
    try {
      Employee emp = new Employee(id);
      _empDao.delete(emp);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Employee succesfully deleted!";
  }
  
  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping(value="/emp/getById/{id}")
  public Employee getById(@PathVariable("id") int id) {
    Employee emp;
    try {
      emp = _empDao.getByEmployeeId(id);
    }
    catch(Exception ex) {
      return null;
    }
    return emp;
  }
  
  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping(value="/emp/getMngrDtls/{id}")
  public Employee getMngrDtls(@PathVariable("id") int id) {
    Employee emp;
    try {
      emp = _empDao.getMngrDtls(id);
    }
    catch(Exception ex) {
      return null;
    }
    return emp;
  }
  
  
  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping(value="/emp/getRepEmps/{id}")
  public List<Employee> getRepEmps(@PathVariable("id") int id) {
    List<Employee> empList = null;
    try {
    	System.out.println("getRepEmps controller method started");
    	empList = _empDao.getRepEmps(id);
    	System.out.println("getRepEmps controller method completed");
    }
    catch(Exception ex) {
    	System.out.println("getRepEmps controller method has errors");
      return null;
    }
    return empList;
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping(value="/emp/save")
  public String createEmp(@RequestBody Employee emp) {
    try {
    	_empDao.save(emp);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Employee succesfully saved!";
  }
  
  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping(value="/emp/update")
  public String updateEmp(@RequestBody Employee emp) {
    try {
    	_empDao.update(emp);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Employee succesfully updated!";
  }
  
} 
