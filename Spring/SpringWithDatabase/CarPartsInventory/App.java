package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.CarPart;
import com.cdac.component.CarPartsInventory;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		
//		CarPartsInventory inv = (CarPartsInventory) ctx.getBean("carParts1");
		CarPartsInventory inv = (CarPartsInventory) ctx.getBean("carParts2");
		
		CarPart cp = new CarPart();
		cp.setPartName("nut");
		cp.setCarModel("Maruti 800");
		cp.setPrice(100);
		cp.setQuantity(300);
		
		CarPart cp2 = new CarPart();
		cp2.setPartName("bolt");
		cp2.setCarModel("Maruti 800");
		cp2.setPrice(200);
		cp2.setQuantity(300);
		
		long ms1 = System.currentTimeMillis();
		inv.addNewParts(cp);
		long ms2 = System.currentTimeMillis();
		System.out.println("Total time taken : " + (ms2 - ms1) + " ms approx");
		
		//adding second part will be fast 
		ms1 = System.currentTimeMillis();
		inv.addNewParts(cp2);
		ms2 = System.currentTimeMillis();
		System.out.println("Total time taken : " + (ms2 - ms1) + " ms approx");
	}
}
