package org.jsp.hobernateTemplate.controller;

import java.util.List;
import java.util.Scanner;
import org.jsp.hobernateTemplate.dao.EmployeeDao;
import org.jsp.hobernateTemplate.dto.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static EmployeeDao empo;
	static Scanner sc = new Scanner(System.in);

	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("Employee.xml");
		empo = context.getBean(EmployeeDao.class);
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("1.Add Employee");
			System.out.println("2.Update Employee");
			System.out.println("3.Find Employee By Id..");
			System.out.println("4.Find All Employee..");
			System.out.println("5.Delete Employee By Id...");
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				save();
				break;
			case 2:
				update();
				break;
			case 3:
				findById();
				break;
			case 4:
				findAllEmp();
				break;
			case 5:
				delete();
				break;
			}
		}
	}

	private static void save() {
		System.out.println("Enter name,phone,email,password to Save Employee...");
		Employee e = new Employee();
		e.setName(sc.next());
		e.setPhone(sc.nextLong());
		
		e.setEmail(sc.next());
		e.setPassword(sc.next());
		e = empo.saveEmployee(e);
		System.out.println("Employee save with a Id:" + e.getId());
		
	}

	private static void update() {
		System.out.println("Enter id,name,phone,email,password to Save Employee...");
		Employee e = new Employee();
		e.setId(sc.nextInt());
		e.setName(sc.next());
		e.setPhone(sc.nextLong());
		
		e.setEmail(sc.next());
		e.setPassword(sc.next());
		e=empo.updateEmployee(e);
		if(e!=null) {
			System.out.println("Update Sucessfull");
		}else {
			System.out.println("Can Not Update");
		}
		
	}

	private static void findById() {
		System.out.println("Enter id");
		int id=sc.nextInt();
		Employee e= new Employee();
		e=empo.findEMployeeById(id);
		printEmp(e);
		
	}

	private static void findAllEmp() {
		List<Employee> e=empo.findAllProduct();
		for(Employee emp:e) {
			printEmp(emp);
		}
		
	}

	private static void delete() {
		System.out.println("Enter Id To Delet");
		int id=sc.nextInt();
		if(empo.Delete(id)) {
			System.out.println("Delet Sucessfully");
		}else {
			System.out.println("Can Not Delet  ");
		}
		
	}
	public static void printEmp(Employee e) {
		System.out.println("Id : "+e.getId());
		System.out.println("Name : "+e.getName());
		System.out.println("Phnone : "+e.getPhone() );
		System.out.println("------------------------------");
	}

}
