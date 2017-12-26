package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.Dao.UserDaoImpl;
import com.niit.model.Job;
import com.niit.model.User1;

@Configuration

@EnableTransactionManagement
@ComponentScan("com.niit")

public class DBConfiguartion {
	// user Database
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
			//	properties.put("hibernate.hbm2ddl.auto", "create");
				properties.put("hibernate.hbm2ddl.auto", "update");
				System.out.println("Hibernate Properties");
				return properties;

			}
			//Session Factory Bean Created.
			@Autowired
			@Bean(name = "sessionFactory")
			public SessionFactory getSessionFactory(DataSource dataSource) {
				LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
				sessionBuilder.addProperties(getHibernateProperties());
				sessionBuilder.scanPackages("com.niit");
				sessionBuilder.addAnnotatedClasses(User1.class);
				sessionBuilder.addAnnotatedClasses(Job.class);
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
			@Autowired
			@Bean(name="userDAO")
			public UserDaoImpl getUserDAO(SessionFactory sessionFactory)
			{
				System.out.println("User DAO object Created");
				return new UserDaoImpl(sessionFactory);
			}
			
			
}
