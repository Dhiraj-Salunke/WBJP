package com.cdac.component;

import java.util.List;

public interface CarPartsInventory {
	//In this method inser query code
	public void addNewParts(CarPart carPart);
	
	//In this method select query code(fetch method)
	public List<CarPart> getAvailableParts(); 

}