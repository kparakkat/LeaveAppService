package leaveappservice.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class LeaveHistoryDao {

	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	  }

	  public void save(LeaveHistory leaveHist) {
	    getSession().save(leaveHist);
	    return;
	  }
	  
	  public void delete(LeaveHistory leaveHist) {
	    getSession().delete(leaveHist);
	    return;
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<LeaveHistory> getLeaveHistByEmpId(int empId) {
	    return (List<LeaveHistory>) getSession().createQuery("from LeaveHistory where emp_id = :empid")
	    		.setParameter("empid", empId).list();
	  }
	  
	  public LeaveHistory getByLeaveHistoryById(int leaveId) {
		System.out.println("getByEmployeeId DAO method have executed");
	    return (LeaveHistory) getSession().createQuery(
	        "from leave_history where leave_id = :leaveid")
	        .setParameter("leaveid", leaveId)
	        .uniqueResult();
	  }
	  
	  
	  public LeaveHistory getById(int id) {
	    return (LeaveHistory) getSession().load(LeaveHistory.class, id);
	  }

	  public void update(LeaveHistory leaveHist) {
	    getSession().update(leaveHist);
	    return;
	  }
}
