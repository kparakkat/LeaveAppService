package leaveappservice.models;

import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class EmployeeDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
	return _sessionFactory.getCurrentSession();
  }

  public void save(Employee emp) {
    getSession().save(emp);
    return;
  }
  
  public void delete(Employee emp) {
    getSession().delete(emp);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<Employee> getRepEmps(int mngrId) {
	  System.out.println("getRepEmps DAO method started");
	    return (List<Employee>) getSession().createQuery(
	    		"from Employee as emp where emp.emp_id in ("
	    		+ "select rep.emp_id from Employee as rep "
	    		+ "where rep.emp_mng_id = :mngrid)").
	    		setParameter("mngrid", mngrId).list();
	  }
  
  @SuppressWarnings("unchecked")
  public List<Employee> getAll() {
    return getSession().createQuery("from employee").list();
  }
  
  public Employee getByEmployeeId(int empId) {
	System.out.println("getByEmployeeId DAO method have executed");
    return (Employee) getSession().createQuery(
        "from Employee where emp_id = :empid")
        .setParameter("empid", empId)
        .uniqueResult();
  }
  
  public Employee getMngrDtls(int empId) {
	  
	  Employee emp = getByEmployeeId(empId);
	  Employee mngr = getByEmployeeId(emp.getemp_mng_id());
	  return mngr;
  }
  

  public Employee getById(int id) {
    return (Employee) getSession().load(Employee.class, id);
  }

  public void update(Employee emp) {
    getSession().update(emp);
    return;
  }

} // class UserDao
