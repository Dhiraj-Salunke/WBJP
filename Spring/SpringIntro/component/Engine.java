package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("engine")
public class Engine {

	public void on() {
		System.out.println("vroom vroom..");
	}

	public void off() {
		System.out.println("phoosh phoosh..");
	}
}
