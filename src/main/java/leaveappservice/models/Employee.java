package leaveappservice.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name="employee")
public class Employee {

  @Id
  private int emp_id;
  
  private String emp_name;
  
  private long emp_phone;
  
  private String emp_dept;
  
  private String emp_mail;
  
  private Date emp_doj;
  
  private int leave_balance;
  
  private Integer emp_mng_id;
  
  @Where( clause = "leave_status = 'PENDING'")
  @OneToMany(mappedBy = "emp_id", fetch = FetchType.EAGER)
  private Set<LeaveHistory> leaveHistory = new HashSet<LeaveHistory>(0);
	 
  public Employee() { }
  
  public Employee(int emp_id, String emp_name, long emp_phone, String emp_dept, 
		  String emp_mail, Date emp_doj, int leave_balance, int emp_mng_id) { 
	  this.emp_id = emp_id;
	  this.emp_name = emp_name;
	  this.emp_phone = emp_phone;
	  this.emp_dept = emp_dept;
	  this.emp_mail = emp_mail;
	  this.emp_doj = emp_doj;
	  this.leave_balance = leave_balance;
	  this.emp_mng_id = emp_mng_id;
  }

  public Employee(int emp_id) { 
    this.emp_id = emp_id;
  }

  public int getemp_id() {
    return emp_id;
  }

  public void setemp_id(int value) {
    this.emp_id = value;
  }

  public String getemp_name() {
    return emp_name;
  }
  
  public void setemp_name(String value) {
    this.emp_name = value;
  }
  
  public long getemp_phone() {
    return emp_phone;
  }

  public void setemp_phone(long value) {
    this.emp_phone = value;
  }
  
  public String getemp_dept() {
	    return emp_dept;
  }
	  
  public void setemp_dept(String value) {
	    this.emp_dept = value;
  }
  
  public String getemp_mail() {
	    return emp_mail;
  }
	  
  public void setemp_mail(String value) {
	    this.emp_mail = value;
  }
  
  public Date getemp_doj() {
	  return emp_doj;
  }
  
  public void setemp_doj(Date value) {
	  this.emp_doj = value;
  }
  
  public int getleave_balance() {
	    return leave_balance;
  }

  public void setleave_balance(int value) {
	   this.leave_balance = value;
  }
  
  public Integer getemp_mng_id() {
	    return emp_mng_id;
  }

  public void setemp_mng_id(Integer value) {
	    this.emp_mng_id = value;
  }
  
  public Set<LeaveHistory> getleaveHistory() {
	    return leaveHistory;
  }

  public void setleaveHistory(Set<LeaveHistory> value) {
	    this.leaveHistory = value;
  }
} // class Employee
