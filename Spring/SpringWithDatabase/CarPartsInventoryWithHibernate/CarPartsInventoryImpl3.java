package com.cdac.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("carParts3")
public class CarPartsInventoryImpl3 implements CarPartsInventory {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void addNewParts(CarPart carPart) {
		em.persist(carPart);
	}

	@Override
	public List<CarPart> getAvailableParts() {
		return em
						.createQuery("select c from CarPart c", CarPart.class)
						.getResultList();
	}

	
}
