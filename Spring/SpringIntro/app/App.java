package com.cdac.app;


import java.util.Currency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.Calculator;
import com.cdac.component.Car;
import com.cdac.component.CurrencyConverter;
import com.cdac.component.HelloWorld;
import com.cdac.component.LoginService;
import com.cdac.component.TextEditor;

public class App {

	public static void main(String[] args) {
		// Loading Spring /IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		
		HelloWorld hw = (HelloWorld) ctx.getBean("hello");
		
		System.out.println(hw.sayHello("Dhiraj"));
		
		Calculator clc = (Calculator) ctx.getBean("calc");
		System.out.println(clc.add(10, 20));
		System.out.println(clc.sub(10, 20));
		
		CurrencyConverter cc = (CurrencyConverter) ctx.getBean("currencyConv");
		System.out.println(cc.convert("USD", "INR", 1));
		
		LoginService ls = (LoginService) ctx.getBean("loginService");
		System.out.println(ls.isValidUser("Dhira", "luffy"));
		
		TextEditor te = (TextEditor) ctx.getBean("TxtEdtr");
		te.load("abc.txt");
		
		Car car = (Car) ctx.getBean("car");
		car.drive();
	}
}
