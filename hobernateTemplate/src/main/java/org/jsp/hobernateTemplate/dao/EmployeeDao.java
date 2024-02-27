package org.jsp.hobernateTemplate.dao;

import java.util.List;

import org.jsp.hobernateTemplate.dto.Employee;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class EmployeeDao {
	 private HibernateTemplate template;
	 
	 public Employee saveEmployee(Employee e) {
		 template.save(e);
		 return e;
	 }
	 public Employee updateEmployee(Employee e) {
		 Employee emp=template.get(Employee.class, e.getId());
		 if(emp!=null) {
			emp.setEmail(e.getEmail());
			emp.setName(e.getName());
			emp.setPassword(e.getPassword());
			emp.setPhone(emp.getPhone());
			template.update(e);
			return e;
			 
		 }
		 return null;
	 }
	 public Employee findEMployeeById(int id) {
		 return template.get(Employee.class, id);
	 }
	 public List<Employee> findAllProduct(){
		 return template.loadAll(Employee.class);
	 }
	 public boolean Delete(int id) {
		 Employee e=template.get(Employee.class, id);
		 if(e!=null) {
			 template.delete(e);
			 return true;
		 }
		 return false;
	 }
	public HibernateTemplate getTemplate() {
		return template;
	}
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

}
