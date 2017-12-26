package com.niit.Dao;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User1;
@Repository("userDao")

public class UserDaoImpl implements UserDao{

	
	Logger Logger=LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
	
		this.sessionFactory=sessionFactory;
	}

	
		@Transactional
		public boolean saveOrUpdate(User1 user1) {
	
			try
			{
			sessionFactory.getCurrentSession().save(user1);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:" +e);
			return false;
			}	
		}
		@Transactional
		public User1 updateUser(User1 validUser) {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.update(validUser);
			tx.commit();
			
			return validUser;
		}
		@Transactional
		public void delete(User1 user1) {
			sessionFactory.getCurrentSession().delete(user1);
			}	
		@SuppressWarnings("deprecation")
		@Transactional
		public User1 getUser(String username) {
			Criteria c=sessionFactory.getCurrentSession().createCriteria(User1.class);
			c.add(Restrictions.eq("username", username));
			User1 user=(User1)c.uniqueResult();
			return user;
		}
		
		@SuppressWarnings("deprecation")
		@Transactional
		public User1 viewUser(int userid) {
			Criteria c=sessionFactory.getCurrentSession().createCriteria(User1.class);
			c.add(Restrictions.eq("userid", userid));
			User1 user=(User1) c.uniqueResult();
			return user;
		}
		@SuppressWarnings({ "unchecked", "deprecation" })
		@Transactional
		public List<User1> UserList() {
			Criteria c=sessionFactory.openSession().createCriteria(User1.class);
			List<User1> l = c.list();
			return l;
		}
		@SuppressWarnings({ "rawtypes", "deprecation" })
		@Transactional
		public User1 login(User1 user1) {
			Session session=sessionFactory.openSession();

			Query query=session.createQuery("from User1 where userName=? and password=? and enable=?");
		
			query.setString(0, user1.getUserName()); //for assigning the values to parameter username
			query.setString(1, user1.getPassword());
			query.setBoolean(2, true);
			User1 validUsers=(User1)query.uniqueResult();
			session.close();
			System.out.println("Dao completed");
			return validUsers;	
		}
		
		@Transactional
		public boolean isEmailValid(String email) {
			List<User1> list = UserList();

			for (User1 usersDetail : list) {
				if (usersDetail.getEmail().equals(email)){
					return false;// invalid user
				}
			}
			return true;// valid user
		}
		@Transactional
		public boolean isUsernameValid(String username) {
			List<User1> list = UserList();

			for (User1 user : list) {
				if (user.getUserName().equals(username)) {
					return false;// invalid user
				}
			}
			return true;// valid user	
		}


		public User1 getUserById(int userid) {
			// TODO Auto-generated method stub
			return null;
		}
		

	

}
