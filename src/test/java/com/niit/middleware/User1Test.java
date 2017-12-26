/*package com.niit.middleware;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.Dao.UserDao;
import com.niit.configuration.DBConfiguartion;
import com.niit.model.User1;

@ComponentScan("com.niit.*")

@Ignore
public class User1Test {

static UserDao  userDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfiguartion.class);
		context.scan("com.niit.*");
		context.refresh();

		userDao=(UserDao)context.getBean("userDao");
	}
	
	
	@Ignore
	@Test
	public void saveUser1Test()
	{
		User1 user1=new User1();
		user1.setFirstName("saikumar");
		user1.setLastName("martha");
		user1.setContact("9501841426");
		user1.setEmail("martha@gmail.com");
		user1.setPassword("123");
		user1.setRole("Admin");
		assertTrue("Problem in Inserting user", userDao.saveOrUpdate(user1));
	}
}*/