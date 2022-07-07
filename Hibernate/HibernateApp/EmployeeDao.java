package com.cdac.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Employee;

public class EmployeeDao {
	private static EntityManagerFactory emf;
	//type2 add method in separate class 
	public void add(Employee emp) {
		//persistence.xml file will be read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("funkopop");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(emp); 
		
		tx.commit();
		emf.close();
	}
	
	//fetch method
		public Employee fetch(int empno) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("funkopop");
			EntityManager em = emf.createEntityManager();
			//find method is used for fetching database
			Employee emp = em.find(Employee.class, empno);
			
			emf.close();
	
			return emp;
		}
		
		//fetchAll method
		public List<Employee> fetchAll() {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("funkopop");
			EntityManager em = emf.createEntityManager();
			
			Query q = em.createQuery("select e from Employee e"); //HQL/JPQL
			List<Employee> list = q.getResultList();
			
			emf.close();
		
			return list;
			}

			public List<Employee> fetchAllBySalary(double salary) {
				EntityManager em = emf.createEntityManager();
				Query q = em.createQuery("select e from Employee e where e.salary >= :sal");
				q.setParameter("sal", salary);
				List<Employee> list = q.getResultList();
				
				return list;
			}

			public List<String> fetchAllNames() {
				EntityManager em = emf.createEntityManager();
			
				Query q = em.createQuery("select e.name from Employee e"); //HQL/JPQL
				List<String> list = q.getResultList();
				
				return list;
			}

			public List<Object[]> fetchAllNamesAndSalaries() {
				EntityManager em = emf.createEntityManager();
			
				Query q = em.createQuery("select e.name,e.salary from Employee e"); //HQL/JPQL
				List<Object[]> list = q.getResultList();
				
				return list;
			}
}

