package leaveappservice.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="leave_history")
public class LeaveHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int leave_id;
  
  private int number_of_days;
  
  @NotNull
  private Date start_date;
  
  @NotNull
  private Date end_date;
  
  private String leave_status;
  
  private Date applied_on;
  
  private String manager_comments;
  
  @NotNull 
  private int emp_id;
      
  private String reasons;
  
  private String leave_type;
  
  public LeaveHistory() { }
  
  public int getleave_id() {
    return leave_id;
  }

  public void setleave_id(int value) {
    this.leave_id = value;
  }
  
  public int getnumber_of_days() {
	    return number_of_days;
  }

  public void setnumber_of_days(int value) {
	    this.number_of_days = value;
  }
  
  public Date getstart_date() {
	    return start_date;
  }

  public void setstart_date(Date value) {
	    this.start_date = value;
  }
	  
  public Date getend_date() {
	    return end_date;
  }

  public void setend_date(Date value) {
	    this.end_date = value;
  }
  
  public String getleave_status() {
	    return leave_status;
  }
	  
  public void setleave_status(String value) {
	    this.leave_status = value;
  }
  
  public Date getapplied_on() {
	    return applied_on;
  }

  public void setapplied_on(Date value) {
	    this.applied_on = value;
  }
  
  public String getmanager_comments() {
	    return manager_comments;
  }
	  
  public void setmanager_comments(String value) {
	    this.manager_comments = value;
  }
  
	
  public int getemp_id() { return emp_id; }
	  
  public void setemp_id(int value) { this.emp_id = value; }
	 
  
  public String getreasons() {
	    return reasons;
  }
	  
  public void setreasons(String value) {
	    this.reasons = value;
  }
  
  public String getleave_type() {
	    return leave_type;
  }
	  
  public void setleave_type(String value) {
	    this.leave_type = value;
  }
  

}
