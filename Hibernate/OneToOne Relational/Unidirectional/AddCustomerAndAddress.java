package com.cdac.app;

import com.cdac.dao.CustomerAddressDao;
import com.cdac.entity.Address;
import com.cdac.entity.Customer;

public class AddCustomerAndAddress {
	
	public static void main(String[] args) {
	CustomerAddressDao dao = new CustomerAddressDao();
	
	Customer cs  = new Customer();
	cs.setName("Dhiraj");
	cs.setEmail("dhiraj@gmail");
	dao.add(cs);
	
	Address a = new Address();
	a.setPincode(413531);
	a.setCity("Latur");
	a.setState("Maharashtra");
	dao.add(a);
	}
}
