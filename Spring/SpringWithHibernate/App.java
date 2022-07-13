package com.java.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.dao.UserDao;
import com.java.entity.User;

public class App {

	public static void main(String[] args) {
		
		//Loading Spring/IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		
		UserDao dao = (UserDao) ctx.getBean("userDao");
		
		User user = new User();
		user.setUsername("Suraj");
		user.setPassword("123456");
		user.setEmail("dhiraj@gmail");
		
		dao.add(user);
	}

}
