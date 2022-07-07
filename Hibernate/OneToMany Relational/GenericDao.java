package com.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericDao {

	public void save(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("funkopop");
		try {
				EntityManager em = emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				tx.begin();
		
				//em.persist(obj); //will generate insert query
				
				//2 in 1 method
				em.merge(obj); //used for insert as well as update 
				
				tx.commit();
			}
		finally {
				emf.close();
			}
	}
	
	//fetch method
	public Object fetchById(Class clazz, Object pk) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("funkopop");
		try {
				EntityManager em = emf.createEntityManager();
		
				//find method generates select query where pk = ?
				Object obj = em.find(clazz, pk);
				return obj;	
		}
		finally {
		emf.close();
		}
	}
	
	//delet method
	public void delete(Class clazz, Object pk) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("funkopop");
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			//find method generates select query where pk = ?
			Object obj = em.find(clazz, pk);
			em.remove(obj); //remove will generate delete query
			
			tx.commit();
		}
		finally {
			emf.close();
		}
		
	}
}
