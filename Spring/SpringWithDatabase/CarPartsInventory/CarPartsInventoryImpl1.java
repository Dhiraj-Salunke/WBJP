package com.cdac.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Component;

//create table in mysql first
@Component("carParts1")
public class CarPartsInventoryImpl1 implements CarPartsInventory  {

	public void addNewParts(CarPart carPart) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			long ms1 = System.currentTimeMillis();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/latur", "root", "cdac");
			long ms2 = System.currentTimeMillis();
			System.out.println("approx time taken to connect to db : " + (ms2 - ms1) + " ms approx");
			
			PreparedStatement st = conn.prepareStatement("insert into tbl_carpart(part_name, car_model, price, quantity) values(?, ?, ?, ?)");
			st.setString(1, carPart.getPartName());
			st.setString(2, carPart.getCarModel());
			st.setDouble(3, carPart.getPrice());
			st.setInt(4, carPart.getQuantity());
			st.executeUpdate();
		}
		catch( Exception e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}				
	}

	public List<CarPart> getAvailableParts() {
		
		return null;
	}

	
}
