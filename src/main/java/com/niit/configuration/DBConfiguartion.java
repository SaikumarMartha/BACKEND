package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.niit.model.BlogComment;
import com.niit.model.BlogPost;
import com.niit.model.BlogPostLikes;
import com.niit.model.Chat;
import com.niit.model.Friend;
import com.niit.model.Job;
import com.niit.model.Notification;
import com.niit.model.ProfilePicture;
import com.niit.model.UserDetails;


public class DBConfiguartion {
	
	Logger logger =LoggerFactory.getLogger(DBConfiguartion.class);
			@Bean(name = "dataSource")
			public DataSource getDataSource() {
				DriverManagerDataSource dataSource = new DriverManagerDataSource();
				dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
				dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
				dataSource.setUsername("project");
				dataSource.setPassword("123456");
				System.out.println("Datasource");
				return dataSource;

			}

			private Properties getHibernateProperties() {
				Properties properties = new Properties();
				properties.put("hibernate.show_sql", "true");
				properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			    //properties.put("hibernate.hbm2ddl.auto", "create");
			    properties.put("hibernate.hbm2ddl.auto", "update");
				properties.put("hibernate.format_sql", "true");
				System.out.println("Hibernate Properties");
				return properties;

			}
			//Session Factory Bean Created.
			@Autowired
			@Bean(name = "sessionFactory")
			public SessionFactory getSessionFactory(DataSource dataSource) {
				LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
				sessionBuilder.addProperties(getHibernateProperties());
				sessionBuilder.addAnnotatedClass(UserDetails.class);
				sessionBuilder.addAnnotatedClass(Job.class);
				sessionBuilder.addAnnotatedClass(BlogComment.class);
				sessionBuilder.addAnnotatedClass(BlogPost.class);
				sessionBuilder.addAnnotatedClass(BlogPostLikes.class);
				sessionBuilder.addAnnotatedClass(Notification.class);
				sessionBuilder.addAnnotatedClass(Friend.class);
				sessionBuilder.addAnnotatedClass(ProfilePicture.class);
				sessionBuilder.addAnnotatedClass(Chat.class);
				System.out.println("Session");
				return sessionBuilder.buildSessionFactory();
				
			}
			//Transaction Bean Object
			@Autowired
			@Bean(name = "transactionManager")
			public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
				HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
				System.out.println("Transaction");
				return transactionManager;
			}
		
			
}
