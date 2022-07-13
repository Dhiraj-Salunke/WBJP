package com.cdac.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carParts2")
public class CarPartsInventoryImpl2  implements CarPartsInventory{

	@Autowired
	private DataSource dataSource;
	
	public void addNewParts(CarPart carPart) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			long ms1 = System.currentTimeMillis();
			// new method to get connection
			conn = dataSource.getConnection();
			long ms2 = System.currentTimeMillis();
			System.out.println("approx time taken to obtain a connection from the pool : " + (ms2 - ms1) + " ms approx");
			
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
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement st = conn.prepareStatement("select * from tbl_carpart");
			ResultSet rs = st.executeQuery();
			
			List<CarPart> list = new ArrayList <>();
			while(rs.next()) {
				CarPart carPart = new CarPart();
				carPart.setPartNo(rs.getInt(1));
				carPart.setPartName(rs.getString(2));
				carPart.setCarModel(rs.getString(3));
				carPart.setPrice(rs.getDouble(4));
				carPart.setQuantity(rs.getInt(5));
				list.add(carPart);
			}
			return list;
		}
		catch( Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}				
	}
}