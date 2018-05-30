package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;

public class TestUser {
	@Test
	public void TestInsert() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		User user = new User();
		user.setUsername("GIGI");
		user.setPassword("555");
		user.setEmail("a999@hotmail.com");
		user.setPhone("029998877");
		um.insert(user);
	}

	@Test
	public void testSelect() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		User user = um.selectByUsername("ads");
		System.out.println(user);
	}

	@Test
	public void testregist() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml", "spring-service.xml");
		IUserService us = ac.getBean("userService", IUserService.class);
		User user = new User();
		user.setUsername("ads");
		user.setPassword("a123");
		user.setEmail("a123@hotmail.com");
		user.setPhone("123222666");
		us.register(user);

	}

	@Test
	public void emailtest() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		System.out.println(um.selectByEmail("a123@hotmail.com"));

	}

	@Test
	public void testcheckemail() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml", "spring-service.xml");
		IUserService us = ac.getBean("userService", IUserService.class);
		System.out.println(us.checkemail("a124@hotmail.com"));
	}

	@Test
	public void testcheckphone() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		System.out.println(um.selectByPhone("123222666"));
	}

	@Test
	public void testphone2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml", "spring-service.xml");
		IUserService us = ac.getBean("userService", IUserService.class);
		System.out.println(us.checkphone("123222666"));

	}

	@Test
	public void checkTUsername() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml", "spring-service.xml");
		IUserService us = ac.getBean("userService", IUserService.class);
		System.out.println(us.checkUsername("ada"));
	}

	@Test
	public void testLogin() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml", "spring-service.xml");
		IUserService us = ac.getBean("userService", IUserService.class);
		System.out.println(us.login("455","123"));
	}
	
	@Test
	public void TESTupdate() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml", "spring-service.xml");
		UserMapper um=ac.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setId(1);
		user.setEmail("rf123@gmail.com");
		um.update(user);
	}
	
		
		
	
	
}
